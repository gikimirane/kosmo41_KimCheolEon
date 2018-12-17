# -*- coding: utf-8 -*-
"""
Created on Tue Dec 11 10:48:09 2018

@author: kosmo
"""

#!/usr/bin/env python3
import csv
import glob
import os
import sys

#input_path = sys.argv[1]
input_path = "./Data"
output_file = "./Output/out10.csv"

first_file = True
for input_file in glob.glob(os.path.join(input_path, '*sales*')):
    #입력받은 경로에서 파일명을 반환
    print(os.path.basename(input_file))
    
    with open(input_file, 'r', newline='') as csv_in_file:
        with open(output_file, 'a', newline='') as csv_out_file:
            #csv 내장모듈 사용하여 읽고 쓰기
            filereader = csv.reader(csv_in_file)
            filewriter = csv.writer(csv_out_file)
            
            if first_file:
                for row in filereader:
                    filewriter.writerow(row)
                first_file = False
            else:
                header = next(filereader)
                for row in filereader:
                    filewriter.writerow(row)