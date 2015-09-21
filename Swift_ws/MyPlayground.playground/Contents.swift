//: Playground - noun: a place where people can play

import UIKit

var tutorialTeam: String = "55"
var editorialTeam = 23

var tutorialTeamNum: Int? = Int(tutorialTeam.toInt()!)

if let numTutorial = tutorialTeamNum  {
    if(numTutorial > editorialTeam)  {
        print("\(numTutorial) is greater than \(editorialTeam)")
    } else if (numTutorial < editorialTeam) {
        print("\(numTutorial) is less than \(editorialTeam)")
    } else  {
        print("\(numTutorial) is equal to \(editorialTeam)")
    }
} else  {
    print("Invalid entry")
}


