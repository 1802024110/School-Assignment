<?php
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

/** traits(__TRAIT__)
 *  
 */

Class Base{
  public function sayHello(){
    var_dump("Hello World");
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

https://www.runoob.com/php/php-magic-constant.html