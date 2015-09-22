//
//  ViewController.swift
//  Tap Me
//
//  Created by 杨睿涵 on 15/9/22.
//  Copyright (c) 2015年 杨睿涵. All rights reserved.
//

import UIKit
import AVFoundation

class ViewController: UIViewController {
    
    @IBOutlet var scoreLabel: UILabel!
    @IBOutlet var timerLabel: UILabel!
    var count = 0
    var seconds = 0
    var timer = NSTimer()
    var buttonBeep: AVAudioPlayer?
    var secondBeep: AVAudioPlayer?
    var backgroundMusic: AVAudioPlayer?

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        if let buttonBeep = self.setupAudioPlayerWithFile("ButtonTap", type: "wav") {
            self.buttonBeep = buttonBeep
        }
        if let secondBeep = self.setupAudioPlayerWithFile("SecondBeep", type: "wav") {
            self.secondBeep = secondBeep
        }
        if let backgroundMusic = self.setupAudioPlayerWithFile("HallOfTheMountainKing", type: "mp3") {
            self.backgroundMusic = backgroundMusic
        }
        setupGame()
        view.backgroundColor = UIColor(patternImage: UIImage(named: "bg_tile.png")!)
        scoreLabel.backgroundColor = UIColor(patternImage: UIImage(named: "field_score.png")!)
        timerLabel.backgroundColor = UIColor(patternImage: UIImage(named: "field_time.png")!)
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    @IBAction func buttonPressed() {
        count++
        scoreLabel.text = "Score \n\(count)"
        buttonBeep?.play()
    }
    
    func setupGame() {
        seconds = 30
        count = 0
        
        timerLabel.text = "Time: \(seconds)"
        scoreLabel.text = "Score: \(count)"
        
        timer = NSTimer.scheduledTimerWithTimeInterval(1.0, target: self,
            selector: Selector("subtractTime"), userInfo: nil, repeats: true)
        
        backgroundMusic?.volume = 0.3
        backgroundMusic?.play()
    }
    
    func subtractTime() {
        secondBeep?.play()
        seconds--
        timerLabel.text = "Time: \(seconds)"
        
        if (seconds == 0) {
            timer.invalidate()
            
            let alert = UIAlertController(title: "Time is up!", message: "You scored \(count) points", preferredStyle: UIAlertControllerStyle.Alert)
            alert.addAction(UIAlertAction(title: "Play Again", style: UIAlertActionStyle.Default, handler: {
                action in self.setupGame()
            }))
            
            presentViewController(alert, animated: true, completion: nil)
        }
    }
    
    func setupAudioPlayerWithFile(file: NSString, type: NSString) -> AVAudioPlayer? {
        //1
        let path = NSBundle.mainBundle().pathForResource(file as String, ofType: type as String)
        let url = NSURL.fileURLWithPath(path!)
        
        //2
        var audioPlayer:AVAudioPlayer?
        
        //3
        do {
            try audioPlayer = AVAudioPlayer(contentsOfURL: url)
        } catch {
            print("Player not available")
        }
        
        return audioPlayer
    }
}

