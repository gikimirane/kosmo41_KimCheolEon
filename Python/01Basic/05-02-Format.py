# -*- coding: utf-8 -*-
"""
Created on Fri Dec  7 12:07:36 2018

@author: kosmo
"""

# Format 문자
print("{0}+{1}".format("Hello", "홍길동"))

# 좌측정렬
x1 = "{0:10}".format("hi")
print("[", x1, "]")

# 우측정렬
x2 = "{0:>10}".format("hi")
print("[", x2, "]")

#중앙정렬
x3= "{0:^10}".format("hi")
print("[", x3, "]")

#채우기
x4= "{0:*^10}".format("hi")
print("[", x4, "]")

#소수점 표현하기
y1 = 3.14159
y2 = "{0:0.2f}".format(y1)
print("[", y2, "]")