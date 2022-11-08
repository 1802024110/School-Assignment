<form method="post" enctype="multipart/form-data">
  <label for="file">文件名:</label>
  <input type="file" name="file" id="file"/><br/>
  <button type="submit">提交</button>
</form>
<?
// 允许上传的文件列表
$allFileType = array("audio/mpeg");
// 裁剪文件名
$temp = explode(".",$_FILES["file"]["name"]);
// 获得最后的值
$extension = end($temp);
// 上传的文件的后缀名是否在列表
if(!in_array($_FILES["file"]["type"],$allFileType)){
  echo "文件不允许上传";
  exit;
}

if($_FILES["file"]["error"] > 0){
  echo "错误:".$_FILES["file"]["error"]."<br/>";
  exit;
}else echo <<<EOD
"上传文件名: " {$_FILES["file"]["name"]}"<br>";
"文件类型: " {$_FILES["file"]["type"]} "<br>";
"文件大小: " {$_FILES["file"]["size"]}"kB<br>";
"文件临时存储的位置: " {$_FILES["file"]["tmp_name"]};
<br/>
EOD;
// 判断文件是否存在
if(file_exists("upload/".$_FILES["file"]["name"])) echo "文件已经保存";
else{
  // 移动文件
  move_uploaded_file($_FILES["file"]["tmp_name"], "upload/" . $_FILES["file"]["name"]);
  echo "文件存储在: " . "upload/" . $_FILES["file"]["name"];
}
?>