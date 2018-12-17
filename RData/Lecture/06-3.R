## 필요한 변수만 추출하기

#데이터 프레임 만들기
exam <- read.csv("../Doit_R-master/Data/csv_exam.csv")
exam

library(dplyr)

#변수 추출하기
exam %>% select(math)
exam %>% select(english)

#여러개의 변수 추출하기
exam %>% select(class, math, english)

#변수 제거하기(실제 exam 에 지우는건 아닌듯)
exam %>% select(-math)
#여러개 변수 제거
exam %>% select(-math, -english)
#head(exam %>% select(-math, -english))

##----------------------------------------------------------##
## dplyr 패키지 함수 조합하기

#class 가 1인 행만 추출한 다음에 english 만 추출
exam %>% filter(class==1) %>% select(class, english)

#가독성 있게 줄바꾸기 (뒤)
exam %>% filter(class ==1) %>% 
    select(class, english)

#일부만 출력하기
exam %>% 
    select(class, english) %>% 
    head(10)
