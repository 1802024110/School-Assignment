<?
// 可以防止非法数据进行代码注入，提供了更安全的反序列化数据。可以压缩对象
class A{
  private $name = "小明";
  function rap(){
    echo "我是两年练习生";
  }
}
$a = new A;
// 序列化对象
$serializeA = serialize(new A);
var_dump($serializeA);
// 解序列化
$unserializeA = unserialize($serializeA,["allowed_classes" => true]);
var_dump($unserializeA);