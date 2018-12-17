# -*- coding: utf-8 -*-
"""
Created on Wed Dec 12 09:41:21 2018

@author: kosmo
"""

#!/usr/bin/env python3
from numpy.random import randn
import matplotlib.pyplot as plt
plt.style.use('ggplot')

#그래프에서 사용할 데이터 임의 생성
plot_data1 = randn(50).cumsum()
plot_data2 = randn(50).cumsum()
plot_data3 = randn(50).cumsum()
plot_data4 = randn(50).cumsum()

#그림 생성
fig = plt.figure()

#하위 그래프 추가
ax1 = fig.add_subplot(1,1,1)

#다른 모양의 선 그래프 4개 생성
ax1.plot(plot_data1, marker=r'o', color=u'blue', linestyle='-', label='Blue Solod')
ax1.plot(plot_data2, marker=r'+', color=u'red', linestyle='--', label='Red Dashed')
ax1.plot(plot_data3, marker=r'*', color=u'green', linestyle='-.', label='Green Dash Dot')
ax1.plot(plot_data4, marker=r's', color=u'orange', linestyle=':', label='Orange Dotted')

ax1.xaxis.set_ticks_position('bottom')
ax1.yaxis.set_ticks_position('left')

ax1.set_title('Line Plots: Markers, Colors, and LineStyles')
plt.xlabel('Draw')
plt.ylabel('Random Number')

#그래프의 범례를 만든다
plt.legend(loc='best')

#파일 생성
plt.savefig('./Output/03_line_plot.png', dpi=400, bbox_inches='tight')
plt.show()
