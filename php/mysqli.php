<?php
/** planetscale的连接方式
$mysqli = mysqli_init();
$mysqli->ssl_set(NULL, NULL, "用到的代码\cacert.pem", NULL, NULL);
$mysqli->real_connect('ap-northeast.connect.psdb.cloud', '1bdd05hkapbe1crd3iok', 'pscale_pw_bKGpeYnF63N4zUsUcZpnd08IrGjolI63UbQbZ5sYG2h', 'nodream');
$mysqli->close();
 */

$hostname = "ap-northeast.connect.psdb.cloud";
$username = "1bdd05hkapbe1crd3iok";
$password = "pscale_pw_bKGpeYnF63N4zUsUcZpnd08IrGjolI63UbQbZ5sYG2h";
$database = "nodream";
$ca = "用到的代码\cacert.pem";

$mysqli = mysqli_init();
$mysqli->ssl_set(NULL, NULL, "用到的代码\cacert.pem", NULL, NULL);
$mysqli->real_connect('ap-northeast.connect.psdb.cloud', '1bdd05hkapbe1crd3iok', 'pscale_pw_bKGpeYnF63N4zUsUcZpnd08IrGjolI63UbQbZ5sYG2h', 'nodream');

// 检测连接
if (!$mysqli) {
  die("Connection failed: " . mysqli_connect_error());
}
echo "连接成功";

$mysqli->close();
?>