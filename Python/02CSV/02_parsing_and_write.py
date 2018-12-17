# -*- coding: utf-8 -*-
"""
Created on Mon Dec 10 12:38:06 2018

@author: kosmo
"""


#!/usr/bin/env python3
import csv
import sys

#input_file = sys.argv[1]
#output_file = sys.argv[2]
input_file = "./Data/01_data.csv"
output_file = "./Output/out02.csv"

with open(input_file, 'r', newline='') as csv_in_file:
    with open(output_file, 'w', newline='') as csv_out_file:
        #csv 내장모듈 사용하여 읽고 쓰기
        filereader = csv.reader(csv_in_file, delimiter=',')
        filewriter = csv.writer(csv_out_file, delimiter=',')
        for row_list in filereader:
            filewriter.writerow(row_list)