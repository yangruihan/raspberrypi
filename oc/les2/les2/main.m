//
//  main.m
//  les2
//
//  Created by 杨睿涵 on 15/5/24.
//  Copyright (c) 2015年 杨睿涵. All rights reserved.
//

#import <Foundation/Foundation.h>

int main(int argc, const char * argv[]) {
    @autoreleasepool {
        int i = 0;
    a:
        i++;
        NSLog(@"i的值为:%d", i);
        if (i % 2 == 0) {
            goto b;
        } else {
            goto a;
        }
        
    b:
        NSLog(@"i是一个偶数");
        if (i <= 10) {
            goto a;
        }
    }
    return 0;
}
