<?
// session_start()必须位于html标签前

// 此函数会为用户赋予一个随机的session
session_start();

// session存储指定值
$_SESSION["UID"] = 323904280;

// 获得session
var_dump($_SESSION);

// 重置Session
session_destroy();
var_dump($_SESSION);

//销毁
unset($_SESSION["UID"]);
var_dump($_SESSION);