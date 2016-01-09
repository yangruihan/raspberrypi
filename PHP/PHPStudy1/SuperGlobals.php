<html>
<head>
    <meta charset="UTF-8">
</head>
<body>

<form method="post" action="<?php echo $_SERVER['PHP_SELF'];?>">
    Name: <input type="text" name="name">
    <input type="submit">
</form>

<?php
/**
 * Created by PhpStorm.
 * User: Yrh
 * Date: 2015/12/12
 * Time: 22:18
 */

// 超全局变量
// PHP 中的许多预定义变量都是“超全局的”，这意味着它们在一个脚本的全部作用域中都可用。在函数或方法中无需执行 global $variable; 就可以访问它们。
// 这些超全局变量是：
//      $GLOBALS
//      $_SERVER
//      $_REQUEST
//      $_POST
//      $_GET
//      $_FILES
//      $_ENV
//      $_COOKIE
//      $_SESSION


// $GLOBALS — 引用全局作用域中可用的全部变量
//      $GLOBALS 这种全局变量用于在 PHP 脚本中的任意位置访问全局变量（从函数或方法中均可）。
//      PHP 在名为 $GLOBALS[index] 的数组中存储了所有全局变量。变量的名字就是数组的键。

$x = 75;
$y = 25;

function add()
{
    echo "{$GLOBALS['x']} + {$GLOBALS['y']} = " . ($GLOBALS['x'] + $GLOBALS['y']) . '<br>';
}

add();


// $_SERVER
//      $_SERVER 这种超全局变量保存关于报头、路径和脚本位置的信息。
echo $_SERVER['PHP_SELF'];
echo "<br>";
echo $_SERVER['SERVER_NAME'];
echo "<br>";
echo $_SERVER['HTTP_HOST'];
echo "<br>";
echo $_SERVER['HTTP_USER_AGENT'];
echo "<br>";
echo $_SERVER['SCRIPT_NAME'];
echo "<br>";


//    $_SERVER['PHP_SELF']	                返回当前执行脚本的文件名。
//    $_SERVER['GATEWAY_INTERFACE']	        返回服务器使用的 CGI 规范的版本。
//    $_SERVER['SERVER_ADDR']	            返回当前运行脚本所在的服务器的 IP 地址。
//    $_SERVER['SERVER_NAME']	            返回当前运行脚本所在的服务器的主机名（比如 www.w3school.com.cn）。
//    $_SERVER['SERVER_SOFTWARE']	        返回服务器标识字符串（比如 Apache/2.2.24）。
//    $_SERVER['SERVER_PROTOCOL']	        返回请求页面时通信协议的名称和版本（例如，“HTTP/1.0”）。
//    $_SERVER['REQUEST_METHOD']	        返回访问页面使用的请求方法（例如 POST）。
//    $_SERVER['REQUEST_TIME']	            返回请求开始时的时间戳（例如 1577687494）。
//    $_SERVER['QUERY_STRING']	            返回查询字符串，如果是通过查询字符串访问此页面。
//    $_SERVER['HTTP_ACCEPT']	            返回来自当前请求的请求头。
//    $_SERVER['HTTP_ACCEPT_CHARSET']	    返回来自当前请求的 Accept_Charset 头（ 例如 utf-8,ISO-8859-1）
//    $_SERVER['HTTP_HOST']	                返回来自当前请求的 Host 头。
//    $_SERVER['HTTP_REFERER']	            返回当前页面的完整 URL（不可靠，因为不是所有用户代理都支持）。
//    $_SERVER['HTTPS']	                    是否通过安全 HTTP 协议查询脚本。
//    $_SERVER['REMOTE_ADDR']	            返回浏览当前页面的用户的 IP 地址。
//    $_SERVER['REMOTE_HOST']	            返回浏览当前页面的用户的主机名。
//    $_SERVER['REMOTE_PORT']	            返回用户机器上连接到 Web 服务器所使用的端口号。
//    $_SERVER['SCRIPT_FILENAME']	        返回当前执行脚本的绝对路径。
//    $_SERVER['SERVER_ADMIN']	            该值指明了 Apache 服务器配置文件中的 SERVER_ADMIN 参数。
//    $_SERVER['SERVER_PORT']	            Web 服务器使用的端口。默认值为 “80”。
//    $_SERVER['SERVER_SIGNATURE']	        返回服务器版本和虚拟主机名。
//    $_SERVER['PATH_TRANSLATED']	        当前脚本所在文件系统（非文档根目录）的基本路径。
//    $_SERVER['SCRIPT_NAME']	            返回当前脚本的路径。
//    $_SERVER['SCRIPT_URI']	            返回当前页面的 URI。



// $_REQUEST
//      $_REQUEST 用于收集 HTML 表单提交的数据。
$name = $_REQUEST['name'];
echo $name;



// $_POST
//      $_POST 广泛用于收集提交 method="post" 的 HTML 表单后的表单数据。$_POST 也常用于传递变量。
$name = $_POST['name'];
echo $name;

//$_GET
//      $_GET 也可用于收集提交 HTML 表单 (method="get") 之后的表单数据。
//      $_GET 也可以收集 URL 中的发送的数据。

?>

</body>
</html>


