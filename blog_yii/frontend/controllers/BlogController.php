<?php
namespace frontend\controllers;

use frontend\utils\CurlUtil;
use frontend\utils\PageUtil;
use Yii;
use yii\web\Controller;
use yii\web\Request;

/**
 * Site controller
 */
class BlogController extends BaseController
{
    public $enableCsrfValidation = false;

    public function actionListArticle()
    {
        $this->nav = 'listArticle';

        $pageNum = Yii::$app->request->get('pageNum', 1);

        $article = $this->curlPost('listArticle', [
            'pageNum' => $pageNum,
            'pageSize' => $this->pageSize,
        ]);

        $article = $article['article'];
        $article['showPage'] = '';
        if (!empty($article['list'])) {
            $pageUtil = new PageUtil($article['total'], $article['pageSize'], $article['pageNum'], 'index.php?r=blog/list-article&pageNum={page}');
            $article['showPage'] = $pageUtil->showPage();
        }

        return $this->render('listArticle', $article);
    }

    public function actionListMyArticle()
    {
        $this->nav = 'listMyArticle';

        $pageNum = Yii::$app->request->get('pageNum', 1);
        $categoryId = Yii::$app->request->get('categoryId', 0);

        $article = $this->curlPost('listMyArticle', [
            'pageNum' => $pageNum,
            'pageSize' => $this->pageSize,
            'userId' => $this->userId,
            'token' => $this->token,
            'categoryId' => $categoryId,
        ]);

        $article = $article['article'];
        $article['showPage'] = '';
        if (!empty($article['list'])) {
            $pageUtil = new PageUtil($article['total'], $article['pageSize'], $article['pageNum'], 'index.php?r=blog/list-my-article&pageNum={page}&categoryId=' . $categoryId);
            $article['showPage'] = $pageUtil->showPage();
        }

        return $this->render('listMyArticle', $article);
    }

    public function actionListCategory()
    {
        $this->nav = 'listCategory';

        $categories = $this->curlPost('listCategory', [
            'userId' => $this->userId,
            'token' => $this->token,
        ]);

//        var_dump($categories);exit();
        return $this->render('listCategory', ['categories' => $categories]);
    }

    public function actionShowArticle()
    {
        $this->nav = 'showArticle';

        $id = $this->get('id', 1);
        $pageNum = $this->get('pageNum', 1);
        $article = $this->curlPost('showArticle', [
            'id' => $id,
        ]);

        $comment = $this->curlPost('listComment', [
            'articleId' => $id,
            'pageNum' => $pageNum,
            'pageSize' => 10
        ]);

        $comment = $comment['comment'];

//        var_dump($comment);exit();

        $comment['showPage'] = '';
        if (!empty($comment['list'])) {
            $pageUtil = new PageUtil($comment['total'], $comment['pageSize'], $comment['pageNum'], 'index.php?r=blog/show-article&pageNum={page}');
            $comment['showPage'] = $pageUtil->showPage();
        }

        return $this->render('showArticle', ['article' => $article, 'comment' => $comment]);
    }

    public function actionAddArticle()
    {
        $this->nav = 'addArticle';

        return $this->render('addArticle');
    }

    public function actionDoAddArticle()
    {
        $data['token'] = $this->token;
        $data['userId'] = $this->userId;
        $data['categoryId'] = $this->post('categoryId');
        $data['title'] = $this->post('title');
        $data['content'] = $this->post('content');

        $result = $this->curlPost('addArticle', $data);

//        var_dump($data);exit();
        if (isset($result['code'])) {
            Yii::$app->getSession()->setFlash('error', $result['msg']);
            return $this->render('addArticle');
        } else {
            return $this->redirect(['blog/list-my-article']);
        }
    }

    public function actionEditArticle()
    {
        $this->nav = 'editArticle';

        $id = $this->get('id');

        $article = $this->curlPost('showArticle', [
            'id' => $id,
        ]);

//        var_dump($article);exit();
        return $this->render('editArticle', ['article' => $article]);
    }

    public function actionDoEditArticle()
    {
        $data['token'] = $this->token;
        $data['userId'] = $this->userId;
        $data['categoryId'] = $this->post('categoryId');
        $data['title'] = $this->post('title');
        $data['content'] = $this->post('content');
        $data['id'] = $this->post('id');

        $result = $this->curlPost('editArticle', $data);

//        var_dump($data);exit();
        if (isset($result['code'])) {
            Yii::$app->getSession()->setFlash('error', $result['msg']);
            return $this->render('editArticle');
        } else {
            return $this->redirect(['blog/list-my-article']);
        }
    }

    public function actionDeleteArticle()
    {
        $data['token'] = $this->token;
        $data['userId'] = $this->userId;
        $data['id'] = $this->get('id');

        $result = $this->curlPost('deleteArticle', $data);

//        var_dump($data);exit();
        return $this->redirect(['blog/list-my-article']);
    }

    public function actionAddComment()
    {
        $data['token'] = $this->token;
        $data['userId'] = $this->userId;
        $data['contentId'] = $this->post('id');
        $data['content'] = $this->post('content');

        $result = $this->curlPost('addComment', $data);

        if (isset($result['code'])) {
            Yii::$app->getSession()->setFlash('error', $result['msg']);
            return $this->redirect(['blog/show-article', 'id' => $data['contentId']]);
        } else {
            return $this->redirect(['blog/show-article', 'id' => $data['contentId']]);
        }
    }

    public function actionAddCategory()
    {
        $this->nav = 'listCategory';

        return $this->render('addCategory');
    }

    public function actionDoAddCategory()
    {
        $data['token'] = $this->token;
        $data['userId'] = $this->userId;
        $data['name'] = $this->post('name');

        $result = $this->curlPost('addCategory', $data);

//        var_dump($data);exit();
        if (isset($result['code'])) {
            Yii::$app->getSession()->setFlash('error', $result['msg']);
            return $this->render('addCategory');
        } else {
            return $this->redirect(['blog/list-category']);
        }
    }

    public function actionEditCategory()
    {
        $this->nav = 'listCategory';
        $id = $this->get('id');

        $category = $this->curlPost('showCategory', [
            'id' => $id,
            'userId' => $this->userId,
            'token' => $this->token,
        ]);

//        var_dump($category);exit();
        return $this->render('editCategory', $category);
    }

    public function actionDoEditCategory()
    {
        $data['token'] = $this->token;
        $data['userId'] = $this->userId;
        $data['id'] = $this->post('id');
        $data['name'] = $this->post('name');

        $result = $this->curlPost('editCategory', $data);

//        var_dump($data);exit();
        if (isset($result['code'])) {
            Yii::$app->getSession()->setFlash('error', $result['msg']);
            return $this->render('editCategory');
        } else {
            return $this->redirect(['blog/list-category']);
        }
    }

    public function actionDeleteCategory()
    {
        $data['token'] = $this->token;
        $data['userId'] = $this->userId;
        $data['id'] = $this->get('id');

        $result = $this->curlPost('deleteCategory', $data);

//        var_dump($data);exit();
//        var_dump($result);exit();
        return $this->redirect(['blog/list-category']);
    }
}
