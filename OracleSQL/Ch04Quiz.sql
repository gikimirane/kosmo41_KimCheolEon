--Chaper04 Quiz
--교재 137p

--01.SUBSTR 함수를 사용하여 사원들의 입사한 년도와 입사한 달만 출력하시오.
--교재에서는 substr 로 잘라서 표시함
-- substr(hiredate, 1, 2) 년도 이런식
select hiredate,
        to_char(hiredate, 'YY')||'년' as 입사년도,
        to_char(hiredate, 'mm')||'월' as 입사달 from employee;
        
--02.SUBSTR 함수를 사용하여 4월에 입사한 사원을 출력하시오.
select ename, hiredate from employee where  (case when substr(hiredate, 4, 2)=04 then '04월' end) is not null;

--03.MOD 함수를 사용하여 사원번호가 짝수인 사람만 출력하시오.
select ename, eno from employee where mod(eno, 2)=0;


--04.입사일을 연도는 2자리(YY), 월은 숫자(MON)로 표시하고 요일은 약어(DY)로 지정하여 출력하시오.
select ename, to_char(hiredate, 'yy-mon dy') from employee;


--05.올해 며칠이 지났는지 출력하시오. 현재 날짜에서 올해 1월 1일을 뺀 결과를 출력하고 TO_DATE 함수를 사용 하여 데이터 형을 일치 시키시오.
select to_date(sysdate), to_date(180101), trunc(to_date(sysdate) - to_date(180101)) as Result from dual;

--06.사원들의 상관 사번을 출력하되 상관이 없는 사원에 대해서는 NULL 값 대신 0으로 출력하시오.
select ename, nvl(manager, 0) as 상관 from employee;

--07.DECODE 함수로 직급에 따라 급여를 인상하도록 하시오. 
--직급이 ‘ANALYST’인 사원은 200, ‘SALESMAN’ 인 사원은 180, 
--‘MANAGER’인 사원은 150, ‘CLERK’인 사원은 100을 인상하시오.
--교재에서는 decode 사용함 decode(job, 'ANALYSY', salary+200~ 이런 식
select ename, job, salary,
    case when job='ANALYST' then salary+200
    when job='SALESMAN' then salary+180
    when job='MANAGER' then salary+150
    when job='CLERK' then salary+100
    end
    as UpSalary
    from employee;
    
--Special. 서울 종로구 모든 중학교의 주소를 구하시오
select * from zipcode where sigunguk='종로구';

--아 씁;;; multi_name 인줄 알고 핵삽질함
select * from zipcode where sigunguk='종로구' and substr(bd_name, -3, 3)='중학교';

select substr('종로중학교', -3, 3) from dual;

