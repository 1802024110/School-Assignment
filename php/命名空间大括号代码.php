<?php
/**
 * 命名空间主要解决PHP代码内部的类、函数、常量或第三方的类、函数、常量之前名字冲突的问题。
 * 为很长的标识符创建以一个别名，提高阅读性
 * 默认情况下所有的类、函数名、常量都放在全局空间下
 */
// 当使用了{}的命名空间。在namespace外就不能写代码了
// 使用大括号定义命名空间,但是不能和不带{}的命名空间混合使用.
namespace 命名空间3{
  // 这里可以看作一个单独的php文件
  echo __NAMESPACE__;
}

namespace 命名空间4{
  // 这里可以看作一个单独的php文件
  echo __NAMESPACE__;
}

// 要想在全局命名空间添加代码可以使用如下代码
namespace {
  session_start();
}

