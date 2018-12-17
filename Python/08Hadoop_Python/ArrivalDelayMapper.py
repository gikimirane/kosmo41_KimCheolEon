# -*- coding: utf-8 -*-
"""
Created on Wed Dec 12 14:31:53 2018

@author: kosmo
"""

#!/usr/bin/env python3

import sys
output_value = 1

for line in sys.stdin:
    line = line.strip()
    columns = line.split(",")
    output_key = columns[0] + ',' + columns[1]
    
    if len(columns) > 14 and columns [14].isdigit() and int (columns[14]) > 0:
        print('{0}\t{1}'.format(output_key, output_value))
