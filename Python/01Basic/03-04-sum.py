# -*- coding: utf-8 -*-
"""
Created on Fri Dec  7 09:42:43 2018

@author: kosmo
"""

#1부터 n까지의 합을 구하는 함수
def sums(number):
    result = 0
    for x in range(1, number + 1):
        result += x
        
    return result

number = int(input("1부터 n까지... n 은? :" ))
print(sums(number))