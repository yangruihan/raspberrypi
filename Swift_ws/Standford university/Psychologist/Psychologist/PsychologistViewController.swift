//
//  ViewController.swift
//  Psychologist
//
//  Created by 杨睿涵 on 15/9/24.
//  Copyright © 2015年 杨睿涵. All rights reserved.
//

import UIKit

class PsychologistViewController: UIViewController {

    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
        var destination = segue.destinationViewController as? UIViewController
        if let navigationController = destination as? UINavigationController {
            destination = navigationController.visibleViewController!
        }
        if let hvc = destination as? HappinessViewController {
            if let identifier = segue.identifier {
                switch identifier {
                case "showSadDetail": hvc.happiness = 0
                case "showHappyDetail": hvc.happiness = 100
                default: hvc.happiness = 50
                }
            }
        }
    }
}

