//: Playground - noun: a place where people can play

import UIKit

class Person {
    var firstName = ""
    var lastName = ""
    var age = 0
    
    func input()->String {
        let keyboard = NSFileHandle.fileHandleWithStandardInput()
        let inputDate = keyboard.availableData
        let rawString = NSString(data: inputDate, encoding: NSUTF8StringEncoding)
        if let string = rawString {
            return string.stringByTrimmingCharactersInSet(NSCharacterSet.whitespaceAndNewlineCharacterSet())
        } else {
            return "Invalid input"
        }
    }
    
    func changeFirstName(newFirstName: String) {
        firstName = newFirstName
    }
    
    func enterInfo() {
        print("What is the first name?")
        firstName = input()
    }
    
    func printInfo() {
        print("First Name: \(firstName)")
    }
}

var newPerson = Person()

newPerson.firstName =  "Yang"
newPerson.lastName = "Ruihan"
newPerson.age = 20

newPerson.changeFirstName("Ya")

