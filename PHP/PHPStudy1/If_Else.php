<?php
/**
 * Created by PhpStorm.
 * User: Yrh
 * Date: 2015/12/12
 * Time: 21:40
 */

$t = date("H");

if ($t < '20') {
    echo "Have a good day!<br>";
} else {
    echo "Good evening!<br>";
}