<?php
namespace frontend\controllers;

use frontend\utils\CurlUtil;
use frontend\utils\PageUtil;
use Yii;
use yii\web\Controller;
use yii\web\HttpException;
use yii\web\Request;

/**
 * Site controller
 */
class AuthController extends BaseController
{
    public $enableCsrfValidation = false;

    public function actionRegister()
    {
        $this->nav = 'register';

        return $this->render('register', []);
    }

    public function actionDoRegister()
    {
        $data['username'] = $this->post('username');
        $data['password'] = $this->post('password');
        $data['nickname'] = $this->post('nickname');
        $data['avatarUrl'] = $this->post('avatarUrl', 'xxx');
        $data['email'] = $this->post('email');

        $result = $this->curlPost('register', $data);

        if (isset($result['code'])) {
            Yii::$app->getSession()->setFlash('error', $result['msg']);
            return $this->redirect(['auth/register']);
        } else {
            Yii::$app->getSession()->setFlash('success', '注册成功');
            return $this->redirect(['auth/login']);
        }
    }

    public function actionLogin()
    {
        $this->nav = 'login';

        return $this->render('login', []);
    }

    public function actionDoLogin()
    {
        $data['username'] = $this->post('username');
        $data['password'] = $this->post('password');
        $data['captcha'] = $this->post('captcha');

        $result = $this->curlPost('login', $data);

        if (isset($result['code'])) {
            Yii::$app->getSession()->setFlash('error', $result['msg']);
            return $this->redirect(['auth/login']);
        } else {
           // Yii::$app->getSession()->setFlash('success', '登录成功');
            $cookies = Yii::$app->response->cookies;
            $cookies->add(new \yii\web\Cookie([
                    'name' => 'token',
                    'value' => $result['user']['token'],
                    'expire' => time() + 3600
                ])
            );

            $cookies->add(new \yii\web\Cookie([
                    'name' => 'id',
                    'value' => $result['user']['id'],
                    'expire' => time() + 3600
                ])
            );

            $cookies->add(new \yii\web\Cookie([
                    'name' => 'nickname',
                    'value' => $result['user']['nickname'],
                    'expire' => time() + 3600
                ])
            );
            return $this->redirect(['blog/list-article']);
        }
    }

    public function actionLoginOut()
    {
        $this->nav = 'loginOut';

        $cookies = Yii::$app->response->cookies;
        $cookies->remove('token');
        return $this->redirect(['blog/list-article']);
    }

    public function actionCaptcha()
    {
        header('Content-Type:image/png');
        $url = "http://hbyw.e21.edu.cn/global/gd.php";//图片链接
        $ch = curl_init();

        curl_setopt($ch, CURLOPT_URL, $url);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, 0);
        curl_setopt($ch, CURLOPT_TIMEOUT,0);//忽略超时
        curl_setopt($ch, CURLOPT_NOBODY, false);
        $str = curl_exec($ch);
        curl_close($ch);
    }
}
