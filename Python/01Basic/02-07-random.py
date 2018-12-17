# -*- coding: utf-8 -*-
"""
Created on Thu Dec  6 14:39:00 2018

@author: kosmo
"""

# random 덧셈문제 만들어서 맞히

import random

a = random.randint(1, 30)
b = random.randint(1, 30)

print(a, " + ", b, " = ")
x = input()
c = int(x)

if a + b == c:
    print("정답입니다.")
else:
    print("틀렸습니다")
