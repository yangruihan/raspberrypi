<?php
/**
 * Created by PhpStorm.
 * User: Yrh
 * Date: 2015/12/12
 * Time: 21:18
 */

// 有效的常量名以字符或下划线开头，常量名称前面没有 $ 符号
// 与变量不同，常量贯穿整个脚本是自动全局的

// 使用 define() 函数设置常量
// 它使用三个参数：
// 首个参数定义常量的名称
// 第二个参数定义常量的值
// 可选的第三个参数规定常量名是否对大小写敏感。默认是 false （false 为敏感 true 为不敏感）

// 创建一个大小写敏感的常量
define("GREETING", "Welcome to school!");

echo GREETING;
// echo greeting; // 出错

echo "<br>";

// 创建一个大小写不敏感的常量
define("HELLO", "Hello World!", true);

// 下面三个输出相同
echo hello;
echo "<br>";

echo Hello;
echo "<br>";

echo HELLO;
echo "<br>";
