<?
// 因为数据库有ssl验证连不上
$hostname = "127.0.0.1";
$username = "root";
$password = "123456";
$database = "phpLean";

try {
  $conn = new PDO("mysql:host=$hostname;", $username, $password);
  echo "连接成功"; 
}
catch(PDOException $e)
{
  echo $e->getMessage();
}

$resut = $conn->query("SELECT * FROM phpLean.employee;");
foreach($resut as $row){
  var_dump($row);
}