#install.packages("ggplot2")

#ggplot2 에 있는 mpg 데이터를, 데이터프레임 형태로 바꿔서 저장
mpg <- as.data.frame(ggplot2::mpg)

head(mpg)

tail(mpg)

# 자동차 234종에 대한 11개 변수로 구성되어있다
dim(mpg)

str(mpg)

summary(mpg)

View(mpg)

?mpg
