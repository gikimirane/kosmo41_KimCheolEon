# -*- coding: utf-8 -*-
"""
Created on Fri Dec  7 12:32:23 2018

@author: kosmo
"""

#문자 개수 세기 : 문자열의 개수를 반환
str1 = "apple"
str2 = len(str1)
print(str1)

print("=" * 35)

# 문자 개수 세기 : 문자열 안의 문자의 개수를 반환
cnt2 = str1.count('p')
print(cnt2)

print("=" * 35)

# 위치 알려주기 1
# - 못찾으면 -1 반
str2 = "I am a bot. You are a girl."
pos1 = str2.find("boy")
print(pos1)

print("=" * 35)

# 위치 알려주기 2
# -못찾으면 에러 발생
#pos2 = str2.index("boy")
print(pos1)

print("=" * 35)

#문자열 바꾸기
str3 = "Life is too short."
str3 = str3.replace("Life", "인생은")
print("str3 :", str3)

#문자열 자르기
str41 = "Life is too short. You need Python."
str42 = str41[0:4]
print("str42 :", str42);

str43 = str41[5:7]
print("str43 :", str43)

str44 = str41[:18]
print("str44 :", str44)

str45 = str41[19:]
print("str45 :", str45)

print("=" * 35)

#문자열 나누기
#값을 지정하지 않아도 스페이스, 탭, 엔터 등은 디폴트 적용
str51 = "Life is too short."
str52 = str51.split()
print("str52 :", str52)

str61 = "a:b:c:d"
str62 = str61.split(':')
print("str62 :", str62)

str63 = str61.split(':', 2)
print("str63 :", str63)

print("=" * 35)

#Join : csv 파일을 만들 때 유용하다
str_list = ["1", "2", "3", "4", "5"]
str7 = ",".join(str_list)
print("str7 :", str7, type(str7))

print("=" * 35)

#strip : 공백 문자 제거하기
str81 = " Remove unwanted characters    from this string.\t\t   \n"
print("str81 :", str81)
print("str81 :------------------")

str82 = str81.lstrip()
print("str82 :", str82)
print("str82 :------------------")

str83 = str81.rstrip()
print("str83 :", str83)
print("str83 :------------------")

str84 = str81.strip()
print("str84 :", str84)
print("str84 :------------------")

#문자열의 양 끝에서 사용자가 지정한 문자 제거
str85 = "+-!We are students.-+/"
str86 = str85.strip("+-!/")
print("str86 :", str86)
print("str86 :------------------")