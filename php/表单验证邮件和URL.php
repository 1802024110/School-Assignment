<?
$res = $_REQUEST;
$value = $res["text"];
if(empty($value) || !preg_match("/([\w\-]+\@[\w\-]+\.[\w\-]+)/",$value)){
  echo "错误";
}else{
  var_dump("格式正确");
}
?>
<form id="from" method="post">
  <input type="text" id='input' name='text'>
</form>
<script>
  document.getElementById("input").onchange = ()=>{document.getElementById("from").submit()}
</script>