/**
 * Created by Yrh on 2015/7/22.
 */

// 类A
function A() {

    this.sayBye = function() {
        console.log("Bye");
    };
}

// 类方法
A.prototype.sayHello = function() {
    console.log("Hello");
}

// 静态方法
A.sayHi = function() {
    console.log("Hi");
}

var a = new A();
a.sayHello();
A.sayHi();

// 继承
function B() {

}

B.prototype = new A();

var b = new B();
b.sayHello();
b.sayBye();


