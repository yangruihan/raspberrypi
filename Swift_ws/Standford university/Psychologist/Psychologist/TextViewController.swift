//
//  TextViewController.swift
//  Psychologist
//
//  Created by 杨睿涵 on 15/9/25.
//  Copyright © 2015年 杨睿涵. All rights reserved.
//

import UIKit

class TextViewController: UIViewController {

    @IBOutlet weak var textView: UITextView! {
        didSet {
            textView.text = string
        }
    }
    
    // model
    var string = "" {
        didSet {
            textView?.text = string
        }
    }
    
    override var preferredContentSize: CGSize {
        get {
            if textView != nil && presentingViewController != nil {
                return textView.sizeThatFits(presentingViewController!.view.bounds.size)
            } else {
                return super.preferredContentSize
            }
        }
        set {
            super.preferredContentSize = newValue
        }
    }
}
