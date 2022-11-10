<?
// session_start()必须位于html标签前
// session是由php随机生成的加密数字
// session信息是在服务器，但session id在浏览器的cookie
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

// session_start()函数可以传入一个数组，可以覆盖php.ini中session的配置.例如:
session_start([
  // 设置session是私有的
  'cache_limiter'=>'private',
  // 设置为true后在读取完会话数据之后， 立即关闭会话存储文件，不做任何修改
  'read_and_close'=>true,
  // SessionID在客户端Cookie储存的时间，默认是0，代表浏览器一关闭SessionID就作废
  'cookie_lifetime'=>3600
]);