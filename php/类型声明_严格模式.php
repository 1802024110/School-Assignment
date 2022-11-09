<?
// 强制模式声明(默认)
// 0表示严格模式，作用于函数和返回语句；0表示弱校验模式
declare(strict_types=1); // 必须在php文件第一行
function sum(int ...$ints){
  return array_sum($ints);
}
// 严格模式下会报错
// echo sum(2, '3', 4.1); 