# -*- coding: utf-8 -*-
"""
Created on Fri Dec  7 10:31:57 2018

@author: kosmo
"""

#타자연습 게임 시키기

import random
import time
list = ["wolf", "fox", "snake", "light", "sleep", "box", "spring"]

trueCount = 0
falseCount = 0

for x in range(1, 5 + 1):
    qString = random.choice(list)
    print("Q", x, " : ", qString)
    startTime = time.time()
    
    str = input("타이핑 : ")
    endTime = time.time()
    
    gameTime = abs(startTime-endTime)
    if(qString == str):
        print("통과")
        trueCount += 1
    else:
        print("오답")
        falseCount += 1
    print("걸린시간 :", format(gameTime, ".2f"))
        
print("[최종결과]")
print("정답 :", trueCount, " 오답 :", falseCount)
            
    