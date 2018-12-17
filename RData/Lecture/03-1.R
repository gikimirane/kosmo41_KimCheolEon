#변수

a <- 1
b <- 2

a + b


#여러 값으로 구성된 변수 선언
var1 <- c(1, 2, 3, 4, 6)    #c() 는 combine()
var2 <- c(1:5)
var3 <- seq(1, 5)
var4 <- seq(1, 10, by = 3)

#여러 값으로 구성된 변수 연
var1 + 2
var1 + var2
var1 + var4 #자릿수가 틀리면 에러 발생

#문자로 된 변수 만들기
str1 <- "a"
str2 <- "test"
str3 <- c("I", "am", "a", "young boy.")
str3

#문자로 된 변수는 연산 불가
str1 + 2m