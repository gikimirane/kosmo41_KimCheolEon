# -*- coding: utf-8 -*-
"""
Created on Mon Dec 10 10:33:49 2018

@author: kosmo
"""

import sys

import glob
import os

#하나의 텍스트 파일 읽기 (Old Version)
#input_file = sys.argv[1]
#input_file = input("File name :")

#filereader = open(input_file, 'r')
#for row in filereader:
#    print(row.strip())
#filereader.close()
#
#print("=" * 30)

#D:\kchy12345\SourceTree\Python\test.txt

print("="*30)

#with 문이 끝날 때 자동으로 파일 객체를 닫는다.
input_file = input("File name :")
with open(input_file, 'r', newline='') as filereader:
    for row in filereader:
        print(row.strip())

print("="*30)


#glob 을 이용해 다수의 텍스트 파일 읽기
#inputPath = sys.argv[1]
#inputPath = input("input Path :")
#
#for input_file in glob.glob(os.path.join(inputPath, '*.txt')):
#    with open(input_file, 'r', newline='') as filereader:
#        for row in filereader:
#            print(row.strip())
#        print("*"*30)

#D:\kchy12345\SourceTree\Python\