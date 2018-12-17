# -*- coding: utf-8 -*-
"""
Created on Mon Dec 10 15:16:55 2018

@author: kosmo
"""

#!/usr/bin/env python3
import pandas as pd
import sys

#input_file = sys.argv[1]
#output_file = sys.argv[2]
input_file = "./Data/01_data.csv"
output_file = "./Output/pout06.csv"

data_frame = pd.read_csv(input_file)

data_frame_column_by_name = data_frame.loc[:, ['Invoice Number', 'Purchase Date']]

data_frame_column_by_name.to_csv(output_file, index=False)