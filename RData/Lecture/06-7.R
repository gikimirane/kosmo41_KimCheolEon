## 가로로 데이터 합치기

exam <- read.csv("../Doit_R-master/Data/csv_exam.csv")
exam

#중간고사 데이터 생성
test1 <- data.frame(id = c(1, 2, 3, 4, 5),
                    midterm = c(60, 80, 70, 90, 85))

#기말고사 데이터 생성
test2 <- data.frame(id = c(1, 2, 3, 4, 5),
                    finalterm = c(70, 83, 65, 95, 80))

test1
test2

#id 기준으로 합쳐서 total에 할
total <- left_join(test1, test2, by = "id")
total

#기준이 되는 id는 동일해야 한다. id가 틀리면... 결과 확인? - NA

## 기존데이터에 선생님 데이터 추가하기

name <- data.frame(class = c(1, 2, 3, 4, 5),
                    teacher = c("kim", "lee", "park", "choi", "jung"))

exam_new <- left_join(exam, name, by = "class")
View(exam_new)



## 세로로 데이터 합치기
#학생 1~5번 시험 데이터 생성
group_a <- data.frame(id = c(1, 2, 3, 4, 5),
                      test = c(60, 80, 70, 90, 85))

#학생 6~10번 시험 데이터 생성
group_b <- data.frame(id = c(6, 7, 8, 9, 10),
                      test = c(70, 83, 65, 95, 80))
group_a
group_b

#데이터 합쳐서 group_all 에 할당
group_all <- bind_rows(group_a, group_b)
group_all

#데이터를 세로로 합칠 때는 두 데이터의 변수명이 같아야한다
#변수명이 다르면 rename()을 이용해서 동일하게 맞춘 후 합친다.
#변수명이 틀린 경우 결과 확인...NA....
