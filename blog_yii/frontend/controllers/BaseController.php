<?php
namespace frontend\controllers;

use frontend\utils\CurlUtil;
use PHPUnit\Framework\Exception;
use Yii;
use yii\web\Controller;

/**
 * Site controller
 */
class BaseController extends Controller
{
    protected $url = 'http://127.0.0.1:8080/';

    public $category;

    public $isLogin = false;

    public $userId;
    public $token;
    public $nickname;

    protected $pageSize = 5;

    public $nav;

    public function beforeAction($action)
    {
        $this->category = [];

        $cookies = Yii::$app->request->cookies;
        if (!empty($cookies->get('token'))) {
            $this->isLogin = true;
            $this->token = $cookies->get('token')->value;
            $this->userId = $cookies->get('id')->value;
            $this->nickname = $cookies->get('nickname')->value;

            $this->category = $this->curlPost('listCategory',['userId' => $this->userId]);
        }

        return parent::beforeAction($action); // TODO: Change the autogenerated stub
    }

    public function curlPost($path, $postData = [])
    {
        $result = json_decode(CurlUtil::post($this->url . $path, $postData), true);
//        var_dump($result);
        if (isset($result['code']) && $result['code'] == 200) {
            return $result['data'];
        } else {
            return $result;
        }
    }

    public function post($name, $defaultValue = null)
    {
        return Yii::$app->request->post($name, $defaultValue);
    }

    public function get($name, $defaultValue = null)
    {
        return Yii::$app->request->get($name, $defaultValue);
    }

}