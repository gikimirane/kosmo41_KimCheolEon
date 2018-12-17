# -*- coding: utf-8 -*-
"""
Created on Mon Dec 10 11:00:02 2018

@author: kosmo
"""

import sys

#파일 작성하기 2
my_numbers = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
max_index = len(my_numbers)

#output_file = sys.argv[1]
output_file = input("File Name :")
filewriter = open(output_file, 'a')

for index_value in range(len(my_numbers)):
    if index_value < (max_index-1):
        filewriter.write(str(my_numbers[index_value])+',')
    else:
        filewriter.write(str(my_numbers[index_value])+'\n')
filewriter.close()

print("Output written to file")


#파일 작성하기3 : CSV
#숫자일 경우 join이 안된다.

#my_numbers = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
my_numbers = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"]
max_index = len(my_numbers)
my_string = ",".join(my_numbers)
print(my_string, type(my_string))

#output_file = sys.argv[1]
#output_file = input("File Name :")
filewriter = open(output_file, 'a')
#filewriter.write(my_string + '\n')      #writelines와 별다른 차이 없음
filewriter.writelines(my_string)        #문장의 끝에 엔터가 없음
#filewriter.writelines(my_string + '\n')
filewriter.close()

print("Output appended to file")