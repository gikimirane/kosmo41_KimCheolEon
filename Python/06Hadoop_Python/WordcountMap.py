# -*- coding: utf-8 -*-
"""
Created on Wed Dec 12 11:01:34 2018

@author: kosmo
"""

#!/usr/bin/env python3
#파이썬 매퍼

import sys

for line in sys.stdin:
    line = line.strip()
    words = line.split()
    for word in words:
        print('{0}\t{1}'.format(word, 1))