# -*- coding: utf-8 -*-
"""
Created on Mon Dec 10 12:52:54 2018

@author: kosmo
"""

#!/usr/bin/env python3

import sys
import pandas as pd

#input_file = sys.argv[1]
#output_file = sys.argv[2]
input_file = "./Data/01_data.csv"
output_file = "./Output/pout02.csv"

data_frame = pd.read_csv(input_file)
print(data_frame)
data_frame.to_csv(output_file, index=False)