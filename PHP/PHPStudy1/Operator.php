<?php
/**
 * Created by PhpStorm.
 * User: Yrh
 * Date: 2015/12/12
 * Time: 21:25
 */

// 算术运算符 ： + - * / % 同其他语言

$x = 10;
$y = 6;

echo($x + $y); // 16
echo '<br>';

echo($x - $y); // 4
echo '<br>';

echo($x * $y); // 60
echo '<br>';

echo($x / $y); // 1.6666666666667
echo '<br>';

echo($x % $y); // 4
echo '<br>';


// 赋值运算符： = += -= *= /= %= 同其他语言
$x = 10;
echo $x; // 输出 10
echo '<br>';

$y = 20;
$y += 100;
echo $y; // 输出 120
echo '<br>';

$z = 50;
$z -= 25;
echo $z; // 输出 25
echo '<br>';

$i = 5;
$i *= 6;
echo $i; // 输出 30
echo '<br>';

$j = 10;
$j /= 5;
echo $j; // 输出 2
echo '<br>';

$k = 15;
$k %= 4;
echo $k; // 输出 3
echo '<br>';


// 字符串运算符： .(串接)  .=(串接赋值)
$a = "Hello";
$b = $a . " World!";
echo $b;    // 输出 Hello World!
echo '<br>';

$x = "Hello";
$x .= " World!";
echo $x;    // 输出 Hello World!
echo '<br>';


// 递增/递减运算符 ++ -- 同其他语言
$x=10;
echo ++$x; // 输出 11
echo '<br>';

$y=10;
echo $y++; // 输出 10
echo '<br>';

$z=5;
echo --$z; // 输出 4
echo '<br>';

$i=5;
echo $i--; // 输出 5
echo '<br>';


// 比较运算符：
// == 等于
// === 全等（完全相同）如果 $x 等于 $y，且它们的类型相同，才返回 true
// != <> 都是不等于
// > < >= <=
$x = 100;
$y = 100;
echo var_dump($x === $y); // 为真
echo '<br>';

$x = 100;
$y = '100';
echo var_dump($x == $y);  // 为真
echo '<br>';


// 逻辑运算符： and or xor(异或) && || !


// 数组运算符
// + 联合： $x + $y    ->   $x 和 $y 的联合（但不覆盖重复的键）
// == 相等：$x == $y   ->   如果 $x 和 $y 拥有相同的键/值对，则返回 true
// === 全等：$x === $y ->   如果 $x 和 $y 拥有相同的键/值对，且顺序相同类型相同，则返回 true
// != 不相等：$x != $y ->   如果 $x 不等于 $y，则返回 true
// <> 不相等：$x <> $y ->   如果 $x 不等于 $y，则返回 true
// !== 不全等：$x !== $y -> 如果 $x 与 $y 完全不同，则返回 true
$x = array("a" => "red", "b" => "green");
$y = array("c" => "blue", "d" => "yellow");
$z = $x + $y; // $x 与 $y 的联合
echo var_dump($z);
echo '<br>';

echo var_dump($x == $y);
echo '<br>';

echo var_dump($x === $y);
echo '<br>';

echo var_dump($x != $y);
echo '<br>';

echo var_dump($x <> $y);
echo '<br>';

echo var_dump($x !== $y);
echo '<br>';