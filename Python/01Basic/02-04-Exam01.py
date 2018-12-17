# -*- coding: utf-8 -*-
"""
Created on Thu Dec  6 13:02:30 2018

@author: kosmo
"""

# 속으로 20초를 세어 맞히는 프로그램...?

import time

input("엔터를 누르고 20초를 셉니다.")

start = time.time()

input("20초 후에 엔터를 다시 누릅니다.")

end = time.time()

et = end - start

print("실제 시간 :", et, "초")
print("차이 :", abs(et-20), "초")