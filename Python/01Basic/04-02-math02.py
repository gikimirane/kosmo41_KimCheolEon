# -*- coding: utf-8 -*-
"""
Created on Fri Dec  7 11:35:29 2018

@author: kosmo
"""

# 소인수 분해
# 12를 소인수 분해하면 2 * 2 * 3
x = int(input("?? : "))

d = 2 #가장 작은 소수인 2부터 나눕니다.
while d <= x:
    if x % d == 0:
        print(d)
        x = x / d
    else:
        d = d + 1