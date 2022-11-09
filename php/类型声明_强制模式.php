<?
// 强制模式声明(默认)
// 1表示严格模式，作用于函数和返回语句；0表示弱校验模式
declare(strict_types=0); // 必须在php文件第一行
// 强制模式实例
function sum(int ...$ints){
  return array_sum($ints);
}
echo sum(32,32,32);

// 返回类型声明
/**
 可以声明的返回类型有：

int

float

bool

string

interfaces

array

callable
 */
function add(int ...$ints):int{
  return array_sum($ints);
}
// 返回值可以是void