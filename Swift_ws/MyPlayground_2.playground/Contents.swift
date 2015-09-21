//: Playground - noun: a place where people can play

import UIKit

func randomIntBetween(low:Int, high:Int)->Int{
    let range = high - (low - 1)
    return (Int(arc4random()) % range) + (low - 1)
}

let answer = randomIntBetween(1, 100)

print("Enter a number between 1 and 100.")

var guess = 10
var times = 0

while (guess != answer) {
    if (guess > answer) {
        println("higher")
        guess -= 1
    } else {
        println("lower")
        guess += 1
    }
    times += 1
}
print("Correct! The answer was \(guess)!")
print("You guess \(times) times")













