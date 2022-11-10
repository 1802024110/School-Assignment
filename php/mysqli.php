<?php
/** planetscale的连接方式
$mysqli = mysqli_init();
$mysqli->ssl_set(NULL, NULL, "用到的代码\cacert.pem", NULL, NULL);
$mysqli->real_connect('ap-northeast.connect.psdb.cloud', '1bdd05hkapbe1crd3iok', 'pscale_pw_bKGpeYnF63N4zUsUcZpnd08IrGjolI63UbQbZ5sYG2h', 'nodream');
$mysqli->close();
 */

$hostname = "127.0.0.1";
$username = "root";
$password = "123456";
$database = "phpLean";

$mysqli = mysqli_init();
$mysqli->real_connect($hostname, $username,$password,$database );

// 检测连接
if (!$mysqli) {
  die("Connection failed: " . mysqli_connect_error());
}
echo "连接成功\n";

// 执行SQL语句
$sql1 = "SELECT * FROM phpLean.employee;";
if($mysqli->query($sql1)){
  echo "执行成功\n";
}else{
  echo "执行失败:$mysqli->error\n";
}

// 执行多条语句
$sql2 = <<<SQL2
insert into phpLean.`Employee` (`num`, `name`, `sex`) values ('wG7', '任子轩', '女');
insert into phpLean.`Employee` (`num`, `name`, `sex`) values ('Nk2C', '潘烨伟', '女');
insert into phpLean.`Employee` (`num`, `name`, `sex`) values ('cZ', '卢智辉', '男');
SQL2;
// if($mysqli->multi_query($sql2)){
//   echo "新记录插入成功";
// }else{
//   echo "Error: " .$mysqli->error;
// }

// 预处理可以给SQL语句绑定变量
$sql3 = "insert into phpLean.`Employee` (`num`, `name`, `sex`) values (?, ?, ?);";
$num = "asdfsdf";
$name ="老王";
$sex="男";
if($stmt = $mysqli->prepare($sql3)){
  // 绑定变量，这里只能引用变量，不能直接传入值
  // s表示字符串，i表示int,d表示float,b表示blob二进制存储对象
  $stmt->bind_param("sss",$num,$name,$sex);
  // 执行
  if($stmt->execute()){
    echo "预处理插入成功\n";
  }else{
    echo "Error: " .$mysqli->error;
  }
}

// 读取数据
$sql4 = "SELECT * FROM phpLean.employee;";
if(($result = $mysqli->query($sql4))&&$result>0){
  // fetch_assoc是迭代器
  while($row = $result->fetch_assoc()){
    echo "num:{$row["num"]},name:{$row["name"]},sex:{$row["sex"]}";
  }
}

// $mysqli->close();
// ?>