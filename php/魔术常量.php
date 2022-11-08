<?php
namespace 魔术常量;

// 魔术常量是随着在代码中的位置改变而改变

// __LINE__当前行号
echo "这是第".__LINE__."行\n";

// __FILE__
echo "文件位于:".__FILE__."\n";

// __DIR__
echo "文件所在目录为:".__DIR__."\n";

// __FUNCTION__
function myIsFun(){
  echo "我所在的方法名字为:".__FUNCTION__."\n";
}
myIsFun();

// __CLASS__
class MyIsClass{
  function __construct(){
    echo "我所在的类的名字为:".__CLASS__."\n";
  }
}
new MyIsClass();

/** traits(__TRAIT__)代码复用
 * 是一种另类的组合式方法，他将Java中实现多个接口或继承可能的重复代码给进行组合
 * 在编译时会将trait的部分代码复制粘贴到类的定义体中，但是不会处理引入导致的不兼容问题。
 * 参考文章: https://zhuanlan.zhihu.com/p/31362082
 */

Class Base{
  public function sayHello(){
    var_dump("Hello World\n");
  }
}

trait SayHello{
  public function sayHello(){
    parent::sayHello();
  }
}

class MyHelloWorld extends Base{
  use SayHello;
}
(new MyHelloWorld())->sayHello();

// __METHOD__
function myIsFun2(){
  var_dump("我所在的方法名字为:".__METHOD__."\n");
}
myIsFun2();

// __NAMESPACE__
var_dump("当前命名空间是".__NAMESPACE__."\n");