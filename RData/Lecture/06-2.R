## 조건에 맞는 데이터만 추출하기

#데이터 프레임 만들기
exam <- read.csv("../Doit_R-master/Data/csv_exam.csv")
exam

# %>% 단축키 : ctrl + shift + m (파이프연산자 라고 부른다 127p)

# exam 에서 class가 1인 경우만 추출하여 출력
exam %>% filter(class == 1)

# 2반인 경우만 추출
exam %>% filter(class == 2)

#1반이 아닌 경우만 추출
exam %>% filter(class != 1)

#3반이 아닌 경우만 추출
exam %>% filter(class != 3)


#초과, 미만, 이상, 이하
# >     <     >=    <=

#수학점수가 50점 초과
exam %>%  filter(math > 50)
#수학점수가 50점 미만
exam %>%  filter(math < 50)
#영어점수가 80점 이상
exam %>%  filter(english >= 80)
#영어점수가 80점 이하
exam %>%  filter(english <= 80)


#and - 여러 조건을 충족하는 행 추출하기, 1반 & 수학점수 50 이상
exam %>% filter (class == 1 & math >= 50)
exam %>% filter (class == 2 & english >= 80)

#or - 하나 이상 충족하는 행 추출하기 (버티컬 바 라고 부른다)
exam %>%  filter (math >= 90 | english >= 90)
exam %>%  filter (class == 3 & (math < 90 | english < 90))

#목록에 해당하는 행 추출하기
exam %>% filter(class == 1 | class == 3 | class == 5)
exam %>% filter(class %in% c(1, 3, 5))

#추출한 행으로 데이터 만들기 (데이터프레임으로 생성)
class1 = exam %>% filter(class==1)
class2 = exam %>% filter(class==2)

#1반 수학점수의 평균
mean(class1$math)
#2반 수학점수 평균
mean(class2$math)
