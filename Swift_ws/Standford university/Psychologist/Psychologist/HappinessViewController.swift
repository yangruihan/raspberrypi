//
//  HappinessViewController.swift
//  Happiness
//
//  Created by 杨睿涵 on 15/9/24.
//  Copyright © 2015年 杨睿涵. All rights reserved.
//

import UIKit

class HappinessViewController: UIViewController, FaceViewDataSource {

    @IBOutlet weak var faceView: FaceView! {
        didSet {
            faceView.dataSource = self
            faceView.addGestureRecognizer(UIPinchGestureRecognizer(target: faceView, action: "viewScaleChange:"))
        }
    }
    
    var happiness: Int = 75 { // range 0...100
        didSet{
            happiness = min(max(happiness, 0), 100)
            print("Happiness: \(happiness)")
            updateUI()
        }
    }
    
    private struct Constants {
        static let HappinessTranslationScale: CGFloat = 4.0
    }
    
    @IBAction func happinessChange(gesture: UIPanGestureRecognizer) {
        switch gesture.state {
        case .Ended: fallthrough
        case .Changed:
            let translation = gesture.translationInView(faceView)
            let happinessChange = -Int(translation.y / Constants.HappinessTranslationScale)
            if happinessChange != 0 {
                happiness += happinessChange
                gesture.setTranslation(CGPointZero, inView: faceView)
            }
        default: break
        }
    }
    
    // 更新UI
    func updateUI() {
        if faceView != nil {
            print("更新UI")
            faceView.setNeedsDisplay()
        }
        title = "你当前的快乐值为：\(happiness)"
    }
    
    func smilinessForFaceView(sender: FaceView) -> Double? {
        return Double(happiness - 50) / 50.0
    }
}
