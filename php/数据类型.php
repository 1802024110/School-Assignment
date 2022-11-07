<?php
class Car {
  private $color;
  function __construct($color){
    $this->color = $color;
  }
  function what_color(){
    return $this->color;
  }
}

$a = new Car('黑色');
echo $a->what_color();

$fp = fopen("foo","w");
echo get_resource_type($fp)."\n";
// 打印：file

echo "\n";
var_dump("132");