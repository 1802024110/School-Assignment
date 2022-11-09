<?
// 设置cooKie必须位于html前,此方法设置和取回cookie时会自动URL编码
setcookie("user","12345",time()+60);
// 此方法不会进行编码
setrawcookie("user2","12345",time()+60);
// 查看cookie
var_dump($_COOKIE);
// 删除cookie,设置时间过期就行
setcookie("user","",0000);