<?
// 在 PHP 中，默认的错误会被发送到浏览器，这条消息带有文件名、行号以及描述错误的消息。

//"die()" 语句
try{
  // 手动报错
  // throw new Exception("手动报错");
}
catch(Exception $e){
  // 该方法会抛出一个信息，然后终止脚本，相当于输出一个echo然后exit
  die("出现了错误");
}

// 自定义错误和错误触发器
// 上面的处理方式显然非常无脑，我们可以自定义错误处理器替换php自带的处理器
// 触发错误时会有五个回调参数,分别是：错误等级、错误消息、错误文件名、错误行号、错误代码用的变量及值
// 创建自定义错误处理函数
function myCustomError($errLevel,$errMsg){
  die("错误等级：".$errLevel."错误消息为:".$errMsg);
}
// 替换php错误处理器
set_error_handler("myCustomError");
// 尝试触发错误测试
// echo($test);
// 另外可以使用trigger_error()手动触发错误，它的第二个参数可以选择错误类型。
// trigger_error("错误测试3",E_USER_WARNING);

// 错误报告
// 通过使用 error_log() 函数，您可以向指定的文件或远程目的地发送错误记录。
// error_log("错误消息",1,"someone@example.com","From: webmaster@example.com");

