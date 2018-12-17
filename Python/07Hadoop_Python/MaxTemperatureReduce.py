# -*- coding: utf-8 -*-
"""
Created on Wed Dec 12 13:00:11 2018

@author: kosmo
"""

#!/usr/bin/env python3
#파이썬 리듀서

import sys

(last_key, max_val) = (None, -sys.maxsize)
for line in sys.stdin:
    (key, val) = line.strip().split("\t")
    
    if last_key and last_key != key:
        print(last_key, "\t", max_val)
        (last_key, max_val) = (key, int(val))
    else:
        (last_key, max_val) = (key, max(max_val, int(val)))
        
if last_key:
    print(last_key, "\t", max_val)