# -*- coding: utf-8 -*-
"""
Created on Fri Dec  7 14:32:53 2018

@author: kosmo
"""

#리스트 만들기
#리스트를 만들기 위해 대괄호를 사용한다.
#len(), min(), max(), count()

list1 = [1, 2, 3, 3, 4, 5]
print(list1)
print(len(list1))
print(min(list1))
print(max(list1))
print(list1.count(3)) #3이 몇개인가?

print("=" * 35)

#인덱스 사용하기
print(list1[1])
print(list1[-1])    #역방향도 시작인덱스가 0일순 없으므로,
                    #역방향의 시작인덱스는 -1
print("=" * 35)
                    
#리스트 분할하기
list2 = list1[0:2]
print(list2)

print("=" * 35)

#리스트 복사하기
list2 = list1
list3 = list1[:]
list1[0] = 9
print(list2)    #바뀐 원소값 따라감 - 참조하기 때문
print(list3)    # [:] 을 통해 새 리스트 생성

print("=" * 35)

#리스트 병합하기
list4 = ["홍길동", "전우치", "손오공"]
list5 = list1 + list4
print(list5)

print("=" * 35)

#int 과 not in
a = 2 in list1
print(a)
if 2 in list1:
    print("2 is in list", list1)
    
b = 2 not in list1
print(b)
if 6 not in list1:
    print("6 is not in list", list1)
    
print("=" * 35)

#append, remove, pop 함수들
list1.append(6)
list1.append(7)
print(list1)

list1.pop()
print(list1)

list1.remove(3) #3의 값을 가진 원소 삭
print(list1)

print("=" * 35)

#[9, 2, 3, 4, 5, 6]
list1.insert(0, 1) #0번째 자리에 1추가
print(list1[1:2])   #1번째 자리의 값 출력

list1[1:2] = ['a', 'b', 'c'] #1번째 자리의 값 치환
print(list1)

list1[1:4] = []
print(list1) #인덱스 1,2,3 자리 값 제거)

del list1[5]
print(list1)

print("=" * 35)

#reverse 함수
#해당 리스트 내에서 변경이 일너난다. --> 인플레이스 변경
list6 = list1[:]
list6.reverse();
print("reverse :", list6)

#sort 함수 : 인플레이스 정렬
list7 = list1[:]
print("list7 :", list7)
list7.sort()
print("sort :", list7)

#sorted 함수 : 새 리스트 생성
my_list = [[1,2,3,4], [4,3,2,1], [2,4,1,3]]
list8 = sorted(my_list, key=lambda index_value: index_value[3])
print(list8)