//: Playground - noun: a place where people can play

import UIKit

var c = UInt16.min
var f = c &- 1

// 空合并运算符（a ?? b） 
// 将对可选类型a进行空判断，如果a包含一个值就进行解封
// 否则就返回默认值b的值
// 注意：
//     1.表达式a必须是可选类型
//     2.默认值b的类型必须要和a存储值的类型保持一致
var a: String?
let b = "hello"
var content = a ?? b
a = "abc"
content = a ?? b

// 闭区间运算符 a...b
// 半开区间运算符 a..<b (包括a但不包括b)
for i in 1...5 {
    print(i) // 结果为12345
}
for i in 1..<5 {
    print(i) // 结果为1234
}

func join (s1 s1: String, toString s2: String, joiner: String) -> String {
    return s1 + joiner + s2
}

print(join(s1: "Hello", toString: "World", joiner: ","))
