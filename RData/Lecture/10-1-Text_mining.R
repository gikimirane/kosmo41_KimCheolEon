#힙합가사 텍스트 마이닝
#KoNLP - java 필요

Sys.getlocale()
Sys.getenv("JAVA_HOME")


#패키지 설치
install.packages("rJava")
install.packages("memoise")
install.packages("KoNLP")
install.packages("dplyr")


#패키지 로드
library(rJava)
library(KoNLP)
library(dplyr)

useNIADic()

#데이터 불러오기
#글로벌 옵션의 워크스페이스 따라가기때문에, 설정 바꿨다면 알아서 조정해야한다
txtData <- readLines("Doit_R-master/Data/hiphop.txt")
head(txtData)
tail(txtData)

install.packages("stringr")
library(stringr)

#특수문자 제거
txtData <- str_replace_all(txtData, "\\W", " ")

#명사 추출 테스트
extractNoun("동해물과 백두산이 마르고 닳도록 하느님이 보우하사")

#가사에서 명사 추출
nouns <- extractNoun(txtData)

#추출한 명사 List를 문자열 벡터로 변환, 단어별 빈도표 생성
wordcount <- table(unlist(nouns))

#데이터프레임으로 변환
df_word <- as.data.frame(wordcount, stringsAsFactors = F)

#변수명 설정
df_word <- rename(df_word,
                  word = Var1,
                  freq = Freq)
df_word

#두 글자 이상 단어 추출
df_word <- filter(df_word, nchar(word) >= 2)

#상위 20개 단어 추출
top_20 <- df_word %>% 
    arrange(desc(freq)) %>% 
    head(20)

top_20

#--------------------------------------------------------------#
#워드 클라우드 만들기
install.packages("wordcloud")

#패키지 로드
library(wordcloud)
library(RColorBrewer)


#Dark2 색상 목록에서 8개 색상 추출
pal <- brewer.pal(8, "Dark2")

#난수 고정하기
set.seed(1234)

#워드클라우드 생성
wordcloud(words = df_word$word,     # 단어
          freq = df_word$freq,      # 빈도
          min.freq = 2,             # 최소 단어 빈도
          max.words = 200,          # 표현 단어 수
          random.order = F,         # 고빈도 단어 중앙 배치
          rot.per = .1,             # 회전 단어 비율
          scale = c(4, 0.3),        # 단어 크기 범위
          colors = pal)             # 색상 목록
