<?php
/**
 * Created by PhpStorm.
 * User: Yrh
 * Date: 2015/12/12
 * Time: 21:53
 */

$x = 0;
while ($x < 5) {
    echo "$x<br>";
    $x++;
}

$x = 0;
do {
    echo "$x<br>";
    $x++;
} while ($x < 5);

for ($x = 0; $x < 10; $x++) {
    echo "$x<br>";
}

$colors = array("red","green","blue","yellow");

foreach ($colors as $value) {
    echo "$value <br>";
}