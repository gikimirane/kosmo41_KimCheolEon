## 집단별로 요약하기

#데이터 프레임 만들기
exam <- read.csv("../Doit_R-master/Data/csv_exam.csv")
exam

#math 평균 산출 (--> 요약)
exam %>% summarise(mean_math = mean(math))

#집단별로 요약하기
exam %>% 
    group_by(class) %>%               # class 별로 분리
    summarise(mean_math = mean(math)) # math 평균 산출 및 새변수 할당

#여러 요약 통계량 한번에 산출하기
exam %>% 
    group_by(class) %>%                    # class 별로 분리 
    summarise(mean_math = mean(math),      # math 평균
              sum_math = sum(math),        # math 합계
              median_math = median(math),  # math 중앙값
              n =n())                      # 빈도 : 여기서는 학생 수

##-----------------------------------------------------------------------##

#회사별로 "suv" 자동차의 도시 및 고속도로를 통합 연비 평균을 구해
#내림차순으로 정하고, 1~5위까지 출력하시오
mpg = as.data.frame(ggplot2::mpg)
head(mpg)

mpg %>% 
    group_by(manufacturer) %>%            #회사별로 분리
    filter(class == "suv") %>%            #suv 추
    mutate(tot = (cty + hwy) / 2) %>%     #통합 연비 변수 생성 후 추가
    summarise(mean_tot = mean(tot)) %>%   #통합 연비 평균 산출
    arrange(desc(mean_tot)) %>%           #내림차순 정렬
    head(10)                              #10위까지 출력 
    