<?php
/**
 * Created by PhpStorm.
 * User: Yrh
 * Date: 2015/12/12
 * Time: 14:44
 */

// '' "" 都可以
$x = 'Hello PHP';
$x = "Hello PHP";

$x = 5985;
echo var_dump($x); // var_dump 函数返回变量的类型和值

echo "<br>";

$x = -345;
echo var_dump($x);

echo "<br>";

$x = 0x8c;
echo var_dump($x);

echo "<br>";

$x = 047;
echo var_dump($x);

echo "<br>";

// 创建数组
$cars = array("Volvo", "BMW", "SAAB");
echo var_dump($cars);
echo "<br>";
print_r($cars);

echo "<br>";

// 定义一个对象
class Car
{
    var $color;

    function Car($color = "green")
    {
        $this->color = $color;
    }

    function what_color()
    {
        return $this->color;
    }
}

$car = new Car("Yellow");
echo $car->what_color();

echo "<br>";

// 空值 null
$x = null;
echo var_dump($x);
