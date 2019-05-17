<?php
/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2019/5/8 0008
 * Time: 17:34
 */
function render($view)
{
    require_once './src/view/' . $view . '.php';
}

function getApiUrl()
{
//    return 'http://www.springmvcdemo.com/springmvcdemo/';
    return 'http://192.168.128.1:8100/springmvcdemo/';
}

function curlGet($url)
{
    //初始化
    $curl = curl_init();
    //设置抓取的url
    curl_setopt($curl, CURLOPT_URL, $url);
    //设置头文件的信息作为数据流输出
    curl_setopt($curl, CURLOPT_HEADER, 0);
    //设置获取的信息以文件流的形式返回，而不是直接输出。
    curl_setopt($curl, CURLOPT_RETURNTRANSFER, 1);

    //执行命令
    $data = curl_exec($curl);
    //关闭URL请求
    curl_close($curl);
    //返回获得的数据
    return $data;
}

function curlPost($url, array $postData = [])
{
    //初始化
    $curl = curl_init();
    //设置抓取的url
    curl_setopt($curl, CURLOPT_URL, $url);
    //设置头文件的信息作为数据流输出
    curl_setopt($curl, CURLOPT_HEADER, 0);
    //设置获取的信息以文件流的形式返回，而不是直接输出。
    curl_setopt($curl, CURLOPT_RETURNTRANSFER, 1);
    //设置post方式提交
    curl_setopt($curl, CURLOPT_POST, 1);
    //设置post数据
    curl_setopt($curl, CURLOPT_POSTFIELDS, $postData);

    //执行命令
    $data = curl_exec($curl);
    var_dump($url);
    var_dump(curl_error($curl));
    //关闭URL请求
    curl_close($curl);
    //返回获得的数据
    return $data;
}