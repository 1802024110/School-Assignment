<?php
$arr = array('apple','orange','banana');
echo $arr;
echo "\n";
echo count($arr);
for ($i = 0; $i < count($arr);$i++) {
  echo $arr[$i]."\n";
}

$arr2 = array("name"=>"小王","age"=>"20");
echo $arr2["name"];

foreach($arr2 as $x=>$x_value){
  echo "Key是:".$x."Value是:".$x_value."\n";
}

// 数组排序
// 升序
sort($arr);
// 降序
rsort($arr);
// 根据Key升序
ksort($arr);
// 根据value升序
asort($arr);
// 根据Key降序
krsort($arr);
// 根据value降序
arsort($arr);