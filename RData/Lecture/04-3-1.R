#외부 데이터 이용하기 #1

#엑셀 데이터 : readxl 패키지 설치하고 로드하기
install.packages("readxl")
library(readxl)

#액셀 파일 불러오기
df_excel <- read_excel("D:\\kchy12345\\SourceTree\\RData\\Doit_R-master\\Data\\excel_exam.xlsx")
df_excel

#Linux 스타일, 파일 인식 잘 된다.
df_excel2 <- read_excel("D:/kchy12345/SourceTree/RData/Doit_R-master/Data/excel_exam.xlsx")
df_excel2

#오 상대경로 되네 ㅋㅋ
df_excel3 <- read_excel("../Doit_R-master/Data/excel_exam.xlsx")
df_excel3


#첫번째 행이 변수명이 아닐 때
df_excel_novar <- read_excel("../Doit_R-master/Data/excel_exam_novar.xlsx")
df_excel_novar #첫 행 데이터 손상

df_excel_novar2 <- read_excel("../Doit_R-master/Data/excel_exam_novar.xlsx", col_names = F)
df_excel_novar2


#액셀 파일에 시트가 여러개 있을 때
df_excel_sheet <- read_excel("../Doit_R-master/Data/excel_exam_sheet.xlsx", sheet = 3)
df_excel_sheet


#섞어서 쓸 때
df_exam <- read_excel("../Doit_R-master/Data/excel_exam_sheet.xlsx", col_names = F, sheet = 3)
df_exam
