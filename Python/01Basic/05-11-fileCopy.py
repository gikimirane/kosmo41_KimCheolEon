# -*- coding: utf-8 -*-
"""
Created on Mon Dec 10 11:42:00 2018

@author: kosmo
"""

import sys

#파일 복사
#inputfile = sys.argv[1]
#outputfile = sys.argv[2]

inputfile = input("Input File Name :")
outputfile = input("Output File Name:")

#맥에서는 안그런다는데, 윈도우에서는 현재 'r', 과 newline 등
#옵션을 꼭 써줘야하는
with open(inputfile, 'r', newline='') as infile:
    with open(outputfile, 'w') as outputfile:
        for line in infile:
            outputfile.write(line)