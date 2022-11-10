<?
// 因为数据库有ssl验证连不上
$hostname = "ap-northeast.connect.psdb.cloud";
$username = "1bdd05hkapbe1crd3iok";
$password = "pscale_pw_bKGpeYnF63N4zUsUcZpnd08IrGjolI63UbQbZ5sYG2h";
$database = "nodream";
$ca = "用到的代码\cacert.pem";

$options = array_merge($options,array(
  PDO::MYSQL_ATTR_SSL_CA =>$ca
));
try {
  $conn = new PDO("mysql:host=$hostname;", $username, $password,$options);
  echo "连接成功"; 
}
catch(PDOException $e)
{
  echo $e->getMessage();
}
$conn = null;