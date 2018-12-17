# -*- coding: utf-8 -*-
"""
Created on Tue Dec 11 10:58:41 2018

@author: kosmo
"""

#!/usr/bin/env python3
import pandas as pd
import glob
import os
import sys

#input_path = sys.argv[1]
#output_file = sys.argv[2]
input_path = "./Data"
output_file = "./Output/pout10.csv"

all_files = glob.glob(os.path.join(input_path, '*sales*'))

all_data_frames = []

for file in all_files:
    data_frame = pd.read_csv(file, index_col=None)
    all_data_frames.append(data_frame)

#aixs=1 이면 열(오른쪽) 으로 붙이고, 0이면 위아래로 붙임
data_frame_concat = pd.concat(all_data_frames, axis=0, ignore_index=True)

data_frame_concat.to_csv(output_file, index=False)

#http://rfriend.tistory.com/257
#http://rfriend.tistory.com/250