<?php
/**
 * 命名空间主要解决PHP代码内部的类、函数、常量或第三方的类、函数、常量之前名字冲突的问题。
 * 为很长的标识符创建以一个别名，提高阅读性
 * 默认情况下所有的类、函数名、常量都放在全局空间下
 */

// 定义命名空间，声明命名空间必须在当前文件代码最前面声明
namespace 命名空间;
echo __NAMESPACE__;

// 但是也可以在同文件定义不同命名空间名称
namespace 命名空间1;
echo __NAMESPACE__;
namespace 命名空间2;
echo __NAMESPACE__;

// PHP 命名空间也允许指定层次化的命名空间的名称，这称为子命名空间
namespace 命名空间3\SPACE;

// 命名空间可以通过三种方式引用
// 非限定名称，不包括前缀的引用
include '用到的代码/命名空间.php'; // 导入文件
use \App\Test\Test; // 因为文件里定义了\App命名空间，所以直接导入到类
new Test();
// 限定名称,或包含前缀的名称
use \App\Test as Test1; //  导入到子命名空间
new Test1\Test(); // 命名空间加上类名
// 完全限定名称，或包含了全局前缀操作符的名称
new \App\Test\Test(); // 全命名空间加类名

// 动态类名
namespace 命名空间4;
class classname{
  function __construct(){
    echo "\n".__NAMESPACE__;
  }
}
$a = "命名空间4\classname"; // 使用动态类名时，必须使用完全限定名称,可忽略最前的\
new $a;

// 动态函数
namespace 命名空间5;
function funcname(){
  echo "\n".__NAMESPACE__;
}
$a = "命名空间5\\funcname"; //方式和上面类型
$a();

// 全局命名空间
namespace 命名空间6;
// fopen(); 使用该方法会报错
$a = \fopen("测试.php","r"); //使用\返回到全局命名空间找

// 命名空间顺序
/**
<?php
namespace A;
use B\D, C\E as F;

// 函数调用

foo();      // 首先尝试调用定义在命名空间"A"中的函数foo()
            // 再尝试调用全局函数 "foo"

\foo();     // 调用全局空间函数 "foo" 

my\foo();   // 调用定义在命名空间"A\my"中函数 "foo" 

F();        // 首先尝试调用定义在命名空间"A"中的函数 "F" 
            // 再尝试调用全局函数 "F"

// 类引用

new B();    // 创建命名空间 "A" 中定义的类 "B" 的一个对象
            // 如果未找到，则尝试自动装载类 "A\B"

new D();    // 使用导入规则，创建命名空间 "B" 中定义的类 "D" 的一个对象
            // 如果未找到，则尝试自动装载类 "B\D"

new F();    // 使用导入规则，创建命名空间 "C" 中定义的类 "E" 的一个对象
            // 如果未找到，则尝试自动装载类 "C\E"

new \B();   // 创建定义在全局空间中的类 "B" 的一个对象
            // 如果未发现，则尝试自动装载类 "B"

new \D();   // 创建定义在全局空间中的类 "D" 的一个对象
            // 如果未发现，则尝试自动装载类 "D"

new \F();   // 创建定义在全局空间中的类 "F" 的一个对象
            // 如果未发现，则尝试自动装载类 "F"

// 调用另一个命名空间中的静态方法或命名空间函数

B\foo();    // 调用命名空间 "A\B" 中函数 "foo"

B::foo();   // 调用命名空间 "A" 中定义的类 "B" 的 "foo" 方法
            // 如果未找到类 "A\B" ，则尝试自动装载类 "A\B"

D::foo();   // 使用导入规则，调用命名空间 "B" 中定义的类 "D" 的 "foo" 方法
            // 如果类 "B\D" 未找到，则尝试自动装载类 "B\D"

\B\foo();   // 调用命名空间 "B" 中的函数 "foo" 

\B::foo();  // 调用全局空间中的类 "B" 的 "foo" 方法
            // 如果类 "B" 未找到，则尝试自动装载类 "B"

// 当前命名空间中的静态方法或函数

A\B::foo();   // 调用命名空间 "A\A" 中定义的类 "B" 的 "foo" 方法
              // 如果类 "A\A\B" 未找到，则尝试自动装载类 "A\A\B"

\A\B::foo();  // 调用命名空间 "A" 中定义的类 "B" 的 "foo" 方法
              // 如果类 "A\B" 未找到，则尝试自动装载类 "A\B"
?>
 */