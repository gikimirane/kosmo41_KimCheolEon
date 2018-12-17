# -*- coding: utf-8 -*-
"""
Created on Fri Dec  7 09:52:44 2018

@author: kosmo
"""

#유사 팩토리얼 (for)

def factorial(num):
    fact = 1
    for x in range(1, num + 1):
        fact = fact * x
        
    return fact


number = int(input("숫자 입력 : "))
print(factorial(number))

#range 역순도 가능한듯
#range(10, 0, -1) : 10에서 1까지 역순
