# -*- coding: utf-8 -*-
"""
Created on Tue Dec 11 10:00:57 2018

@author: kosmo
"""

#!/usr/bin/env python3
import csv
import sys

#input_file = sys.argv[1]
#output_file = sys.argv[2]
input_file = "./Data/03_data_no_header_row.csv"
output_file = "./Output/out08.csv"

with open(input_file, 'r', newline='') as csv_in_file:
    with open(output_file, 'w', newline='') as csv_out_file:
        #csv 내장모듈 사용하여 읽고 쓰기
        filereader = csv.reader(csv_in_file)
        filewriter = csv.writer(csv_out_file)
        
        header_list = ['Supplier Name', 'Invoice Number', \
                       'Part Number', 'Cost', 'Purchase Date']
        filewriter.writerow(header_list)
        for row in filereader:
            filewriter.writerow(row)