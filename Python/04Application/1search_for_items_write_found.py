# -*- coding: utf-8 -*-
"""
Created on Thu Dec 13 09:33:46 2018

@author: kosmo
"""

#!/usr/bin/env python3
import csv
import glob
import os
import sys

#item_numbers_file = sys.argv[1]
#path_to_folder = sys.argv[2]
#output_file = sys.argv[3]
item_numbers_file = "./Data/item_numbers_to_find.csv"
path_to_folder = "./Data"
output_file = "./Output/out.csv"

#찾을 아이템 번호를 파일로부터 구하여 리스트에 저장하기
item_numbers_to_find = []
with open(item_numbers_file, 'r', newline='') as item_numbers_csv_file:
    filereader = csv.reader(item_numbers_csv_file)
    for row in filereader:
        item_numbers_to_find.append(row[0])

print(item_numbers_to_find)

file_counter = 0
line_counter = 0
count_of_item_numbers = 0

#저장할 파일 생성
with open(output_file, 'w', newline='') as csv_out_file:
    filewriter = csv.writer(csv_out_file)
    for input_file in glob.glob(os.path.join(path_to_folder, 's*.csv')):
        file_counter += 1
        with open(input_file, 'r', newline='') as csv_in_file:
            filereader = csv.reader(csv_in_file)
            header = next(filereader)
            
            for row in filereader:
                row_of_output = []
                #1234, Widget 1, Supplier A, "$1,100.00", 6/2/2012
                for column in range(len(header)):
                    if column in range(len(header)):
                        if column == 3:
                            cell_value = str(row[column])\
                                .lstrip('$').replace(',','').split('.')[0].strip()
                            row_of_output.append(cell_value)    
                        else:
                            cell_value = str(row[column]).strip()
                            row_of_output.append(cell_value)
                
                row_of_output.append(os.path.basename(input_file))
                
                #구매 아이템 번호 비교
                if row[0] in item_numbers_to_find:
                    filewriter.writerow(row_of_output)
                    count_of_item_numbers += 1
                line_counter += 1
                
print('Number of files: {0}'.format(file_counter))
print('Number of lines: {0}'.format(line_counter))
print('Number of item numbers: {0}'.format(count_of_item_numbers))