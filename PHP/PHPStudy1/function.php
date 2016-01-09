<?php
/**
 * Created by PhpStorm.
 * User: Yrh
 * Date: 2015/12/12
 * Time: 22:00
 */

// 函数名对大小写不敏感
function sayHelloWorld()
{
    echo "Hello World!<br>";
}

sayHelloWorld();
SayHelloWorld();
SAYHELLOWORLD();

// 在函数上面写上形如下面的注释在调用函数的时候IDE会提示参数的类型
/**
 * @param $name String
 */
function sayHello($name)
{
    echo "Hello $name <br>";
}

sayHello("Mark");


// 参数默认值
function sayBye($name = "Mark")
{
    echo "Good Bye $name<br>";
}

sayBye();
sayBye("June");

// 返回值
function sum($a, $b)
{
    return $a + $b;
}

echo sum(2, 3).'<br>';