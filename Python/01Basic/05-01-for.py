# -*- coding: utf-8 -*-
"""
Created on Fri Dec  7 11:51:31 2018

@author: kosmo
"""

# For
# +2 씩 증가
for x in range(1, 10 + 1, 2):
    print(x)
    
print("=" * 35)

#줄어들게
for x2 in range(5, 0, -1):
    print(x2)
    
print("=" * 35)

#한줄로 이어서 출력하기
for x3 in range(5):
    print(x3, end=" ")

print()
print("=" * 35)
    
#구구단 출력하기

for x in range(2, 9 + 1):
    for y in range(1, 9 + 1):
        print(x, "x", y, end="   ")
    print()

print("=" * 35)

    