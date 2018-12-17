#데이터 입력해 데이터 프레임 만들기
english <- c(90, 80, 60, 70)
english
math <- c(50, 60, 100, 20)
math

#데이터 프레임 만들기
df_midterm <- data.frame(english, math)
df_midterm

#데이터 프레임에 데이터 추가
class <- c(1, 1, 2, 2)
name <- c("홍길동", "전우치", "손오공", "해리포터")
df_midterm <- data.frame(english, math, class, name)
df_midterm

#데이터 분석하기
mean(df_midterm$english) #df_midterm의 english 로 평균 산출
max(df_midterm$math)

#데이터 프레임 한번에 만들기
df_midterm2 <- data.frame(english2 = c(90, 80, 60, 70),
                          math2 = c(50, 60, 100, 20),
                          class2 = c(1, 1, 2, 2),
                          name2 = c("베지터", "카카로트", "프리저", "크리링")
                          )
english2 
#위에서 한번에 만들면 지역변수 개념으로 사용되고 메모리에서 날아가는듯...
#별도의 변수 객체로 지정되지 않았다. 데이터 프레임에서 컬럼으로만 사용됨.
