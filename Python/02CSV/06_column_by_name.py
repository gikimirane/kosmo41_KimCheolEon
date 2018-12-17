# -*- coding: utf-8 -*-
"""
Created on Mon Dec 10 15:09:27 2018

@author: kosmo
"""

#!/usr/bin/env python3
import csv
import sys

#input_file = sys.argv[1]
#output_file = sys.argv[2]
input_file = "./Data/01_data.csv"
output_file = "./Output/out06.csv"

#내가 찾으려는 column
my_columns = ['Invoice Number', 'Purchase Date']
my_columns_index = []

with open(input_file, 'r', newline='') as csv_in_file:
    with open(output_file, 'w', newline='') as csv_out_file:
        #csv 내장모듈 사용하여 읽고 쓰기
        filereader = csv.reader(csv_in_file)
        filewriter = csv.writer(csv_out_file)
        #최상단 헤더 한줄 읽음
        header = next(filereader)
        
        #헤더의 길이만큼 반복문 시행
        for index_value in range(len(header)):
            # 찾으려는 컬럼 있을 시, index 에 append
            if header[index_value] in my_columns:
                my_columns_index.append(index_value)
        
        # 읽어 두었던 헤더를 파일에 write한다
        filewriter.writerow(my_columns)
        # 내용을 파일에 write 한다.
        for row_list in filereader:
            row_list_output = []
            for index_value in my_columns_index:
                row_list_output.append(row_list[index_value])
            filewriter.writerow(row_list_output)
        
    