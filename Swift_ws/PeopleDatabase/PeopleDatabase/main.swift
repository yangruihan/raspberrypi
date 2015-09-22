//
//  main.swift
//  PeopleDatabase
//
//  Created by 杨睿涵 on 15/9/22.
//  Copyright (c) 2015年 杨睿涵. All rights reserved.
//

import Foundation

// Swift2.0 do...while 更名为 repeat...while

var response: String

// 定义一个数组(Arrays)
var people: [Person] = []

do {
    var newPerson = Person()
    newPerson.enterInfo()
    people.append(newPerson)
    newPerson.printInfo()
    
    print("Do you want to enter another name? (y/n)")
    response = input()
} while(response == "y")

println("Number of people in the database: \(people.count)")
println("-----------Database----------")

for eachPerson in people {
    eachPerson.printInfo()
}