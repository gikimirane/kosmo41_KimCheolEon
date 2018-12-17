# -*- coding: utf-8 -*-
"""
Created on Fri Dec  7 09:35:55 2018

@author: kosmo
"""

#결과값이 있는 함수
import math

#제곱 구하기
def getSquare(num):
    #result = num * num
    result = num**2
    return result

#삼각형의 넓이 구하기 : 밑변 a, 높이 h
def getTriangleArea(a, h):
    result = (a * h) / 2
    return result

#제곱근 구하기
def getSqrt(num):
    result = math.sqrt(num)
    return result

x1 = 4
x2 = getSquare(x1)

print(x1, x2)

print(getTriangleArea(3, 4))

print(getSqrt(4))
print(getSqrt(9))
    