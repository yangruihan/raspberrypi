//
//  DiagnosedHappinessViewController.swift
//  Psychologist
//
//  Created by 杨睿涵 on 15/9/25.
//  Copyright © 2015年 杨睿涵. All rights reserved.
//

import UIKit

class DiagnosedHappinessViewController: HappinessViewController, UIPopoverPresentationControllerDelegate {
    
    override var happiness: Int {
        didSet {
            historyArr += [happiness]
        }
    }
    
    private struct History {
        static let showHistoryPopoverSegue = "showHistoryPopover"
        static let defaultsStoreKey = "happinessHistory"
    }
    
    private let defaults = NSUserDefaults.standardUserDefaults()
    
    var historyArr: [Int] {
        get {
            return defaults.objectForKey(History.defaultsStoreKey) as? [Int] ?? []
        }
        set {
            defaults.setObject(newValue, forKey: History.defaultsStoreKey)
        }
    }
    
    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
        if let identifier = segue.identifier {
            switch identifier {
            case History.showHistoryPopoverSegue:
                if let dvc = segue.destinationViewController as? TextViewController {
                    if let ppc = dvc.popoverPresentationController {
                        ppc.delegate = self
                    }
                    dvc.string = "\(historyArr)"
                }
            default: break
            }
        }
    }
    
    func adaptivePresentationStyleForPresentationController(controller: UIPresentationController) -> UIModalPresentationStyle {
        return UIModalPresentationStyle.None
    }
}
