#선 그래프 - 시간에 따라 달라지는 데이터 표현하기
# 시계열 데이

library(ggplot2)

ggplot(data = economics, aes(x = date, y = unemploy)) + geom_line()


#08-5
#상자그림 - 집단 간 분포 차이 표현하기

ggplot(data = mpg, aes(x = drv, y = hwy)) + geom_boxplot()