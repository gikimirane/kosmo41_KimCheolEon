# -*- coding: utf-8 -*-
"""
Created on Tue Dec 11 14:31:03 2018

@author: kosmo
"""

#!/usr/bin/env python3
import matplotlib.pyplot as plt
plt.style.use('ggplot')

#그래프에서 사용할 데이터
customers = ['ABC', 'DEF', 'GHI', 'JKL', 'MNO']
customers_index = range(len(customers))
sale_amounts = [127, 90, 201,111, 232]

#그림 생성
fig = plt.figure()

#하위 그래프 추가
#ax1 이 유일한 (1행, 1열, 1개) 하위그래프임을 의미
ax1 = fig.add_subplot(1,1,1)

#막대그래프 만듬
ax1.bar(customers_index, sale_amounts, align='center', color='darkblue')
ax1.xaxis.set_ticks_position('bottom')
ax1.yaxis.set_ticks_position('left')

#막대의 눈금 레이블을 인덱스에서 실제 이름으로 변경
#rotation=0 은 눈금 레이블을 수평으로 지정
plt.xticks(customers_index, customers, rotation=0, fontsize='small')

plt.xlabel('Customer Name')
plt.ylabel('Sale Amount')
plt.title('Sale Amount per Customer')

plt.savefig('./Output/01_bar_plot.png', dpi=400, bbox_inches='tight')
plt.show()

#하위 그래프 추가
#둘 이상의 하위 그래프를 추가하는 것이 가능
#하위 그래프의 행과 열을 지정하고 어떤 하위 그래프를 사용할지를 지정해야 한다.

#bbox_inches='tight' 는 그림을 둘러싼 여백을 제거한다.