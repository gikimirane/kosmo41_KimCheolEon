#파생변수 추가하기 (이전에 썼던 $ 안쓰고 추가함)
head(exam) %>% 
    mutate(total = math + english + science)

exam %>%
    mutate(total = math + english + science,
           mean = (math + english + science) / 3) %>% 
    head(10)

#mutate() 에 ifelse() 적용하기
exam %>%
    mutate(test = ifelse(science >= 60, "pass", "fail")) %>% 
    head

#추가한 변수를 dplyr 코드에 바로 활용하기
exam %>%
    mutate(total = math + english + science) %>% #총합 변수 추가
    arrange(total) %>%                           #총합 변수 기준 오름차순 정렬
    head                                         #일부만 출
