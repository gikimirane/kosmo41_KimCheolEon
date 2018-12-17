# -*- coding: utf-8 -*-
"""
Created on Thu Dec  6 14:54:49 2018

@author: kosmo
"""

# 숫자 맞히기 게임

import random

q = random.randint(1, 30)

while True:
    a = int(input("you answer? : "))
    
    if q != a:
        if q > a:
            print("정답보다 작다")
        else:
            print("정답보다 크다")
    else:
        print("정답")            
        break;
