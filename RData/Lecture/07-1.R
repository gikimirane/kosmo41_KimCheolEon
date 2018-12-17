## 결측치 정제하기 ##

#결측치 찾기

#결측치가 포함된 데이터 프레임 생성
df <- data.frame(sex = c("M", "F", NA, "M", "F"),
                 score = c(5, 4, 3, 4, NA))
df

#결측치 확인
is.na(df)

#결측치 빈도 출력
table(is.na(df))

table(is.na(df$sex))
table(is.na(df$score))

#평균산출 - 결측치때문에 에러가 발생(NA)
mean(df$score)
sum(df$score)

#---------------------------------------------------#
#결측치 제거
#dplyr 패키지 로드
library(dplyr)

#score 가 NA인 데이터만 출력
df %>% filter(is.na(score))
#score 결측치를 제거
df_nomiss <- df %>% filter(!is.na(score))
#score 평균 산출
mean(df_nomiss$score)


#score, sex 결측치 제거
df_nomiss <- df %>% filter(!is.na(score) & !is.na(sex))
df_nomiss

#모든 변수에 결측치 없는 데이터 추출
# - 결측치가 하나라도 있으면 제거된다.
# - 간편하지만 분석에 필요한 행까지 손실될 수 있다. (단점)

#위와 같은 방식. 한번에. 물론 단점도 동일함.
df_nomiss2 <- na.omit(df)
df_nomiss2


##------------------------------------------------------------------##
#함수의 결측치 제외 기능 이용하기
mean(df$score)   # X
mean(df$score, na.rm = T)
sum(df$score, na.rm = T)


exam <- read.csv("../Doit_R-master/Data/df_csv_exam2_re.csv", fileEncoding = "UTF-8")
#결측치 삽입
exam[c(3,8,15), "math"] <- NA
exam

#math 평균 산출
exam %>% summarise(mean_math = mean(math))

#math 결측치 제외하고 평균 산출 (계산해보니, 결측치는 아예 인원에서도 제외됨. 20명에 결측치 3명 제외 17명으로 평균)
exam %>% summarise(mean_math = mean(math, na.rm = T))

exam %>% summarise(mean_math = mean(math, na.rm = T),
                    sum_math = sum(math, na.rm = T),
                    median_math = median(math, na.rm = T))


## 결측치 대체법 ##
## - 결측치를 제거하는 대신 다른 값을 채워넣는 방법

#결측치를 제외하고 math 평균 산출
exam %>% summarise(mean_math = mean(math, na.rm = T))

#math 가 NA면 평균값으로 결측치를 대체
exam$math <- ifelse(is.na(exam$math), exam %>% summarise(mean_math = mean(math, na.rm = T)), exam$math)
#결측치 빈도표 생성
table(is.na(exam$math))

exam

#math 평균 산출
mean(exam$math)
