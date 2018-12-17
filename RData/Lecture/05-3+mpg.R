#데이터 프레임 만들기
df_var_derived <- data.frame(var51 = c(4, 3, 8),
                             var52 = c(2, 6, 1))
df_var_derived


#합계 파생 변수 추가
df_var_derived$var_sum <- df_var_derived$var51 + df_var_derived$var52
df_var_derived

df_var_derived$var_avg <- (df_var_derived$var51 + df_var_derived$var52) / 2
df_var_derived


#행, 열 지우기 참고 : http://lightblog.tistory.com/7
df_var_derived <- df_var_derived[, -4]


#직접해보기 mpg 통합 연비 변수...
mpg <- as.data.frame(ggplot2::mpg)
#통합 연비 변수 생성
mpg$total <- (mpg$cty + mpg$hwy) / 2
head(mpg)

#통합연비 평균
mean(mpg$total)



#조건문을 활용한 파생변수
#기준값 정하기
summary(mpg$total)
hist(mpg$total)

#합격 판정 변수 만들기
mpg$test <- ifelse(mpg$total >= 20, "pass", "fail")
View(mpg)


#빈도표로 합격 자동차 수 확인하기
table(mpg$test)

#막대그래프로 빈도 표현하기
library(ggplot2)
qplot(mpg$test)


# 중첩 조건문 사용하기
# total을 기준으로 A,B,C 등급부여
mpg$grade <- ifelse(mpg$total >= 30, "A",
                    ifelse(mpg$total >= 20, "B", "C"))

# 데이터 확인
head(mpg, 20)
View(mpg)

# 등급 빈도표 생성
table(mpg$grade)

# 등급빈도 막대 그래프 생성
qplot(mpg$grade)

#원하는 만큼 범주 만들기
mpg$grade2 <- ifelse(mpg$total >= 30, "30",
                    ifelse(mpg$total >= 25, "B",
                           ifelse(mpg$total >= 20, "C", "D")))
View(mpg)
