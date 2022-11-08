<?
// 析构函数
class A{
  function __construct(){
    sleep(5);
  }
  function __destruct()
  {
    echo "方法被销毁";
  }
}

new A();