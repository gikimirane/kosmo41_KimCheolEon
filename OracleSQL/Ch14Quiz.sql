-- Chapter14 quiz

--01.IF 문을 사용하여 /KING 사원의 부서번호를 얻어 와서 부서번호에 따른 부서명을 출력하시오.
@D:\kchy12345\SourceTree\OracleSQL\PLSQLQuiz\Ch14Quiz01.sql;

select *from employee;
select *from department;

--02.BASIC LOOP 문으로 1부터 10 사이의 자연수의 합을 구하여 출력하시오.
@D:\kchy12345\SourceTree\OracleSQL\PLSQLQuiz\Ch14Quiz02.sql;

--03.FOR LOOP 문으로 1부터 10 사이의 자연수의 합을 구하여 출력하시오.
@D:\kchy12345\SourceTree\OracleSQL\PLSQLQuiz\Ch14Quiz03.sql;


--04.WHILE LOOP 문으로 1부터 10 사이의 자연수의 합을 구하여 출력하시오.
@D:\kchy12345\SourceTree\OracleSQL\PLSQLQuiz\Ch14Quiz04.sql;

--05.사원 테이블에서 커미션이 NULL이 아닌 상태의| 
--사원번호, 이름, 급여를 이름 기준 오름차순으로 정렬한 결과 를 출력하시오.
@D:\kchy12345\SourceTree\OracleSQL\PLSQLQuiz\Ch14Quiz05.sql;

select eno, ename, salary from employee where commission is not null;


--06.구구단을 출력하시오.
--실습시간에 꿈지럭 거렸던거
@D:\kchy12345\SourceTree\OracleSQL\PLSQL\ch14_6.sql
@D:\kchy12345\SourceTree\OracleSQL\PLSQL\ch14_7.sql
@D:\kchy12345\SourceTree\OracleSQL\PLSQL\ch14_8.sql



