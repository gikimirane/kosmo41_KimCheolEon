#ggplot2 패키지 설치하기
#패키지는 우측 하단의 파일익스플로러 탭에 Packages 가 있다
install.packages("ggplot2")

#패키지 로드
library(ggplot2)

#변수 생성
x2 <- c("a", "a", "a", "b", "b", "c")
x2

#빈도 막대 그래프 출력
qplot(x2)

#함수의 기능이 궁금하다면 : 메뉴얼 출력
?qplot
