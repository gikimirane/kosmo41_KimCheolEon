# -*- coding: utf-8 -*-
"""
Created on Fri Dec  7 12:57:03 2018

@author: kosmo
"""

from datetime import date, time, datetime, timedelta

#날짜 다루기
today = date.today()
print(today)
print(today.year)
print(today.month)
print(today.day)

print("=" * 35)

date_time = datetime.today()
print(date_time)
print(date_time.year)
print(date_time.month)
print(date_time.day)
print(date_time.hour)
print(date_time.minute)
print(date_time.microsecond)

print("=" * 35)

#timedelta 함수를 사용하여 새로운 날짜 계산
# days = 1, hours = 8,  weeks = 2
one_day = timedelta(days=-1)
yesterday = today + one_day
print(yesterday)

#두 날짜 사이의 날짜 차이 계산하기
date_diff = today - yesterday
print(date_diff)

print("=" * 35)

#starttime 함수를 이용하여 date 객체를 특정 형식의 문자열로 만들기
print(today.strftime('%m/%d/%Y'))
print(today.strftime('%b/%d/%Y'))
print(today.strftime('%B/%d/%Y'))
print(today.strftime('%Y/%m/%d'))

print("=" * 35)

#문자열을 이용하여 date 객체를 만들기
date1 = "2018-11-27"
date2 = datetime.strptime(date1, '%Y-%m-%d')
print(date2)
date3 = datetime.date(datetime.strptime(date1, '%Y-%m-%d'))
print(date3)