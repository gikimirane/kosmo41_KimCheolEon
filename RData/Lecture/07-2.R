library(dplyr)

# 이상치 제거하기

#이상치가 포함된 데이터를 생성

outlier <- data.frame(sex = c(1, 2, 1, 3, 2, 1),
                      score = c(5, 4, 3, 4, 2, 6))
outlier


#이상치 확인하기
table(outlier$sex)
table(outlier$score)


#이상치 값을 결측처리하기 : sex 가 3이면 NA 할당
outlier$sex <- ifelse(outlier$sex == 3, NA, outlier$sex)
outlier

#이상치 값을 결측처리하기 : score가 5보다 크면 NA할당
outlier$score <- ifelse(outlier$score > 5, NA, outlier$score)
outlier

#결측치 제거하여 최종적으러 이상치 정제하기
outlier %>% 
    filter(!is.na(sex) & !is.na(score)) %>% 
               group_by(sex) %>% 
               summarise(mean_score = mean(score))


#극단치 - boxplot 을 살펴보면 확인할 수 있음.
boxplot(outlier)
#극단치경계를 넘어서 . . 은 극단치들.
#이들을 ifelse 및 필터로 제외시켜야
