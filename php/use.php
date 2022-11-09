<?
// PHP 7 可以使用一个 use 从同一个 namespace 中导入类、函数和常量：
// php7之前只能一个一个导入
// use const UseTest\A;
// use const UseTest\B;
// use UseTest\A;
// use UseTest\B;
// use function UseTest\A;
// use function UseTest\B;

//php7以后可以一次性导入
use const UseTest\{A,B};
use UseTest\{A,B};
use function UseTest\{A,B};
