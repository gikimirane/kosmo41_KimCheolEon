#산점도 만들기
library(ggplot2)

mpg <- as.data.frame(ggplot2::mpg)


# x축 displ, y축 hwy로 지정해 배경 생성
ggplot(data = mpg, aes(x = displ, y = hwy))


#배경에 산점도 추가
ggplot(data = mpg, aes(x = displ, y = hwy)) + geom_point()

#x축 범위 3~으로 지정
ggplot(data = mpg, aes(x = displ, y = hwy)) + geom_point() + xlim(3, 6)
#removed.... 105... 이거는 축을 변경해서 105개 행이 그래프에 표현되지 않았다는 의미


#y축 범위 10~30 dmfh wlwjd
ggplot(data = mpg, aes(x = displ, y = hwy)) +
    geom_point() + 
    xlim(3, 6) +
    ylim(10, 30)
