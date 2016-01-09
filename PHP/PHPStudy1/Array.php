<?php
/**
 * Created by PhpStorm.
 * User: Yrh
 * Date: 2015/12/12
 * Time: 22:07
 */
$cars = array("Volvo", "BMW", "SAAB");
echo "I like " . $cars[0] . ", " . $cars[1] . " and " . $cars[2] . ".<br>";

//在 PHP 中，有三种数组类型：
//索引数组 - 带有数字索引的数组
//关联数组 - 带有指定键的数组
//多维数组 - 包含一个或多个数组的数组

// 创建索引数组
// 1.使用关键字创建，自动分配索引
$cars = array('Volvo', 'BMW', 'SAAB');

// 2.直接手动分配索引
$cars[0] = 'Volvo';
$cars[2] = 'BMW';
$cars[3] = 'SAAB';

// 获得数组长度
echo count($cars) . '<br>';

// 索引数组遍历
for ($x = 0; $x < count($cars); $x++) {
    echo $cars[$x] . '<br>';
}

foreach ($cars as $car) {
    echo $car . '<br>';
}



// 关联数组，即其他语言中的 map
$age = array("Peter" => "35", "Ben" => "37", "Joe" => "43");

// 遍历关联数组
foreach ($age as $key => $value) {
    echo "Key=" . $key . ", Value=" . $value;
    echo "<br>";
}



// PHP 中 对数组的排序
// sort() - 以升序对数组排序
// rsort() - 以降序对数组排序
// asort() - 根据值，以升序对关联数组进行排序
// ksort() - 根据键，以升序对关联数组进行排序
// arsort() - 根据值，以降序对关联数组进行排序
// krsort() - 根据键，以降序对关联数组进行排序

$cars=array("Volvo","BMW","SAAB");
print_r($cars);
echo '<br>';
sort($cars);
print_r($cars);
echo '<br>';

