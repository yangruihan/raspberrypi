//
//  main.swift
//  My First Project
//
//  Created by 杨睿涵 on 15/9/21.
//  Copyright (c) 2015年 杨睿涵. All rights reserved.
//

import Foundation

let answer = randomIntBetween(0, 100)

var turn = 1

while (true) {
    println("Guess #\(turn): Enter a number between 1 and 100.")
    let userInput = input()
    let userInputNumber:Int? = Int(userInput.toInt()!)
    
    if let num = userInputNumber {
        if (num > answer) {
            println("Lower!")
        } else if (num < answer) {
            println("Higher!")
        } else {
            println("Correct! The answer was \(answer).")
            break
        }
    } else {
        println("Invalid input! Please enter a number.")
        continue
    }
    turn += 1
}

println("It took you \(turn) tries.")

