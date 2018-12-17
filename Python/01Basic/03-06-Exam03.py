# -*- coding: utf-8 -*-
"""
Created on Fri Dec  7 10:00:12 2018

@author: kosmo
"""

# 계산문제를 맞히고 카운팅

import random

def make_question():
    a = random.randint(1, 40)
    b = random.randint(1, 20)
    op = random.randint(1, 3)
    
    #문자열 변수 q에 문제를 만든다.
    #첫번째 수를 q에 저장한다.
    
    
    #a값(정수)을 문자열로 바꾸어 저장한다.
    q = str(a) 
    
    #연산자를 추가한다.
    if op == 1:
        q = q + " + "
    if op == 2:
        q = q + " - "
    if op == 3:
        q = q + " * "
        
    #두번째 숫자를 q에 저장한다.
    q = q + str(b)
    
    #만들어진 문제를 반환
    return q

#정답 / 오답 횟수 카운팅
sc1 = 0
sc2 = 0

for x in range(5):
    q = make_question()
    print(q)
    ans = input(" = ")
    r = int(ans)
    
    #컴퓨터가 계산한 결과인 eval(q)의 값과 사용자가 입력한 값 비교
    if eval(q) == r:
        print("정답입니다")
        sc1 = sc1 + 1
    else:
        print("오답입니다")
        sc2 = sc2 + 1
    
print("정답 : ", sc1, "오답 : ", sc2)
if(sc2 == 0):
    print("모든 문제를 맞췄습니다.")
    
    