<?php

/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2019/5/8 0008
 * Time: 17:29
 */
class User
{
    public function login()
    {
        render('user/login');
    }

    public function loginWithPet()
    {
        render('user/login_with_pet');
    }

    public function doLogin()
    {
        $username = $_POST['username'];
        $password = $_POST['password'];

        $data = curlPost(getApiUrl() . 'home/login', ['username' => $username, 'password' => $password]);
        var_dump($data);
    }

    public function doLoginWithPet()
    {
        $username = $_POST['username'];
        $password = $_POST['password'];
        $name = $_POST['name'];
        $age = $_POST['age'];

        $data = curlPost(getApiUrl() . 'home/login', ['username' => $username, 'password' => $password, 'name' => $name,'age'=>$age]);
        var_dump($data);
    }
}