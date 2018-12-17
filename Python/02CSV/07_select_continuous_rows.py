# -*- coding: utf-8 -*-
"""
Created on Tue Dec 11 09:40:35 2018

@author: kosmo
"""

#!/usr/bin/env python3
import csv
import sys

#input_file = sys.argv[1]
#output_file = sys.argv[2]
input_file = "./Data/02_data_unnecessary_header_footer.csv"
output_file = "./Output/out07.csv"

row_counter = 0
with open(input_file, 'r', newline='') as csv_in_file:
    with open(output_file, 'w', newline='') as csv_out_file:
        #csv 내장모듈 사용하여 읽고 쓰기
        filereader = csv.reader(csv_in_file)
        filewriter = csv.writer(csv_out_file)
        for row in filereader:
            #위에 3줄, 아래의 3줄 무시해버림
            #unnecessary_header_footer.csv 보면 그렇게 지워야
            if row_counter >= 3 and row_counter <= 15:
                filewriter.writerow([value.strip() for value in row])
            row_counter += 1
