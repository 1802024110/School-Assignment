<?php
/** $GLOBALS
* 包含了全部变量的数组，变量名就是键
*/
$a = 1;
var_dump($GLOBALS['a']);

/**
 * $_SERVER
 * 包含了头信息(header),路径(path),脚本位置(script locations)等web数据
 */

var_dump($_SERVER["HTTP_HOST"]);

/** $_REQUEST
 * 收集表单提交的数据
 */

$apiPath ='/login';
var_dump($_REQUEST);

/** $_POST
 * 用于POST的表单数据收集
 * 
 */

var_dump($_POST);

/** $_GET
 * 用于GET的表单数据收集
 * 
 */

var_dump($_GET);