<form method='post'>
  <input type="text" name="email"/>
  <button type="submit">提交</button>
</form>
<?
$email = $_POST["email"];
var_dump("输入的原内容是:".$email);
echo "<br>";
// 前面的简单邮件存在被恶意注入的风险

// 为了防止恶意代码，可以使用PHP FILTER过滤
$filter_email = filter_var("$email", FILTER_SANITIZE_EMAIL); // 过滤器从字符串中删除电子邮件的非法字符
var_dump("过滤后内容方式一:".$filter_email);
echo "<br>";

$filter_email = filter_var($email, FILTER_VALIDATE_EMAIL); // 过滤器验证电子邮件地址的值
var_dump("过滤后内容方式二:".$filter_email);
echo "<br>";
?>