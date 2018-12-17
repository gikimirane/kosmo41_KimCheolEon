# 순서대로 정렬하기
# 여전히 dplyr 라이브러리.

#math 오름차순 정렬 asc 생략
head(exam %>% arrange(math), 10)

#math 내림차순 정렬
head(exam %>% arrange(desc(math)), 10)

#class 오름차순 및 math 내림차순 정렬
exam %>% arrange(class, desc(math))
