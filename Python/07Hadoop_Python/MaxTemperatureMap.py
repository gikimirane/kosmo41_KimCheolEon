# -*- coding: utf-8 -*-
"""
Created on Wed Dec 12 12:51:07 2018

@author: kosmo
"""

#!/usr/bin/env python3
#파이썬 매퍼

import re
import sys

for line in sys.stdin:
    val = line.strip()
    # 연도, 온도, 특성코드
    (year, temp, q) = (val[15:19], val[87:92], val[92:93])
    
    if (temp != "+9999" and re.match("[01459]", q)):
        print(year, "\t", temp)