<?
// fopen() 函数用于在 PHP 中打开文件。
$file = fopen("用到的代码/狐说.txt","r") or exit("打开文件失败");
var_dump($file);

/**
 * feof: 是否已经到末尾
 * fgets: 逐行读取文件
 */
while(!feof($file)){
  print_r(fgets($file));
}

// 关闭文件
fclose($file);