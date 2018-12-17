#변수명 바꾸기

#데이터 프레임 생성
df_var_change1 <- data.frame(var51 = c(1, 2, 3),
                             var52 = c(2, 3, 2))

df_var_change1


#패키지 설치 및 로드
install.packages("dplyr")
library(dplyr)

df_var_change2 <- df_var_change1
df_var_change2


#변수명 바꾸기
df_var_change2 <- rename(df_var_change2, v2 = var52)
df_var_change2


#변수명 바꾸면서 새 데이터프레임 만들기
df_var_change3 <- rename(df_var_change1, v2 = var52)  #원본 df_var_change1 은 여전히 v51, v52 그대로
df_var_change3


#112p 혼자 해보기
mpg <- as.data.frame(ggplot2::mpg)
mpg
View(mpg)

#바뀌어야 할 부분이 앞에 나옴  바뀔이름 = 원래이
mpg <- rename(mpg, city = cty, highway = hwy)

head(mpg)
tail(mpg)
summary(mpg)
str(mpg)
dim(mpg)
?mpg
