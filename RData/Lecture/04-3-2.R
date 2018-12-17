#외부 데이터 이용하기 #2 (CSV)
# CSV는별도의 패키지를 설치하지 않고 내장된 함수를 이용한다.

df_csv_exam1 <- read.csv("../Doit_R-master/Data/csv_exam.csv")
df_csv_exam1

#문자가 들어 있는 파일을 읽어올 때는 stringAsFactor = F
#그래야 변수를 factor타입이 아닌 문자타입으로 불러오기때문에 에러가 발생하지 않음
df_csv_exam2 <- read.csv("../Doit_R-master/Data/csv_exam.csv", stringsAsFactors = F)
df_csv_exam2

#Data Type 열어보면 Factor 랑, chr 차이가 보임
df_csv_exam3 <- read.csv("../Doit_R-master/Data/csv_exam_name.csv", stringsAsFactors = F)
df_csv_exam3

#데이터 프레임을 csv로 저장하
#df_midterm
write.csv(df_csv_exam3, file = "../df_csv_exam3_re.csv")

#데이터 프레임을 R전용 데이터인 RData 파일로 저장하기
save(df_csv_exam3, file = "df_csv_exam3_re.rda")

#데이터 지우기
rm(df_csv_exam3)
df_csv_exam3
load("df_csv_exam3_re.rda")
