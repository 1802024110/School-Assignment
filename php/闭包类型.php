<?
// Closure::call() 将一个函数绑定到另一个对象
class A {
  private $x = 1;
}

// PHP 7 之前版本定义闭包函数代码
$funB = function() {
  return $this->x;
};

// 闭包函数绑定到类 A 上
$funX = $funB->bindTo(new A, 'A'); 

echo $funX();
print(PHP_EOL);

// PHP 7+ 代码
$funX = function() {
  return $this->x;
};
echo $funX->call(new A);