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

// 与目录和文件的关系很像，PHP 命名空间也允许指定层次化的命名空间的名称。
namespace 命名空间3\SPACE;