# -*- coding: utf-8 -*-
"""
Created on Mon Dec 10 14:31:21 2018

@author: kosmo
"""

#!/usr/bin/env python3
import csv
import sys

#input_file = sys.argv[1]
#output_file = sys.argv[2]
input_file = "./Data/01_data.csv"
output_file = "./Output/out04.csv"

important_dates = ['1/20/14', '1/30/14']

with open(input_file, 'r', newline='') as csv_in_file:
    with open(output_file, 'w', newline='') as csv_out_file:
        #csv 내장모듈 사용하여 읽고 쓰기
        filereader = csv.reader(csv_in_file)
        filewriter = csv.writer(csv_out_file)
        header = next(filereader)       #헤더 읽기
        filewriter.writerow(header)    #헤더 쓰기
        for row_list in filereader:
            a_date = row_list[4]
            if a_date in important_dates:   #2개 날짜 필터링
                filewriter.writerow(row_list)