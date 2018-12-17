#Mile Per Gallon, 미 환경 보호국 공개 자 1999~2008 사이 미국 출시 자동차 234종의 연비관련 정보
summary(mpg)
?mpg

#data에 mpg, x축에 hwy 변수 지정해 그래프생성
qplot(data = mpg, x = hwy)


# x축 cty
qplot(data = mpg, x = cty)

#x축 drv, y축 hwy
qplot(data = mpg, x = drv, y = hwy)

#x축 drv, y축 hwy, 선 그래프 형태
qplot(data = mpg, x = drv, y = hwy, geom = "line")

#x축 drv, y축 hwy, 상자 그림 형태
qplot(data = mpg, x = drv, y = hwy, geom = "boxplot")

#x축 drv, y축 hwy, 상자 그림 형태, drv별 색 표현
qplot(data = mpg, x = drv, y = hwy, geom = "boxplot", colour = drv)
