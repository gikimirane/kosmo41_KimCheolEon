#데이터를 파악할때 사용하는 함수들

df_csv_exam1 <- read.csv("../Doit_R-master/Data/csv_exam.csv")

#앞에서부터 6행까지 출력, default
head(df_csv_exam1)

#앞에서부터 10행까지 출력
head(df_csv_exam1, 10)

#뒤에서부터 6행까지 출력, default
tail(df_csv_exam1)

#뒤에서부터 10행까지 출력
tail(df_csv_exam1, 10)

#데이터 뷰어창에서 확인하기 (대문자 유의하기)
View(df_csv_exam1)

#데이터의 행 / 열 확인하기
dim(df_csv_exam1)

#데이터에 들어있는 변수의 속성을 보여줌
str(df_csv_exam1)

#요약 통계량 산출하기
summary(df_csv_exam1)
# Min - 최솟값
# 1st Qu - 1사분위 수 (하위 25%, 1/4 지점에 위치하는 값)
# Median - 중앙에 위치하는 값
# Mean - 평균값
# 3rd Qu - 3사분위 수 (하위 75%, 3/4 지점에 위치하는 값)
# Max - 최댓값