<?php
$controller = $_GET['c'];
$action = $_GET['a'];

$file = "./src/controller/{$controller}.php";

require_once './src/function.php';
require_once $file;

if (!file_exists($file)) {
    echo 'file not exist';
    exit();
} else {
    $className = ucfirst($controller);

    $obj = new $controller;
    $obj->$action();
}
