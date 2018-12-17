# -*- coding: utf-8 -*-
"""
Created on Fri Dec  7 11:41:04 2018

@author: kosmo
"""

# 평균, 분산, 표준편차 구하
import math

#자료값 리스트
data = [1, 2, 3, 4, 5, 6, 7]
print(data)

#평균 구하기
avg = sum(data) / len(data)
print(avg)

#분산 구하기
vsum = 0
for x in data:
    vsum = vsum + (x - avg)**2
var = vsum / len(data)
print(var)

#표준편차 구하기
std = math.sqrt(var)
print(std)
