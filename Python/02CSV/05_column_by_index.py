# -*- coding: utf-8 -*-
"""
Created on Mon Dec 10 14:53:36 2018

@author: kosmo
"""

#!/usr/bin/env python3
import csv
import sys

#input_file = sys.argv[1]
#output_file = sys.argv[2]
input_file = "./Data/01_data.csv"
output_file = "./Output/out05.csv"

my_columns = [0, 3]     #0번과 3번 컬럼의 데이터 등장

with open(input_file, 'r', newline='') as csv_in_file:
    with open(output_file, 'w', newline='') as csv_out_file:
        #csv 내장모듈 사용하여 읽고 쓰기
        filereader = csv.reader(csv_in_file)
        filewriter = csv.writer(csv_out_file)
        for row_list in filereader:
            row_list_output = [ ]
            for index_value in my_columns:
                row_list_output.append(row_list[index_value])
            filewriter.writerow(row_list_output)