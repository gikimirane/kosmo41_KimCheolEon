--Chater 05_그룹함수 사용하기

--01.모든 사원의 급여 최고액, 최저액, 총액 및 평균 급여를 출력하시오. 
--칼럼의 별칭은 결과 화면과 동일하게 지정 하고 평균에 대해서는 정수로 반올림하시오.
select max(salary) "Maximum",
    min(salary) "Min",
        sum(salary) "Sum",
        round(avg(salary)) "Average"
            from employee;
        

--02.각 담당 업무 유형별로 급여 최고액, 최저액, 총액 및 평균액을 출력하시오. 
--칼럼의 별칭은 결과 화면과 동일하게 지정하고 평균에 대해서는 정수로 반올림하시오.
select job,
        max(salary) "Maximum",
        min(salary) "Min",
        sum(salary) "Sum",
        round(avg(salary)) "Average"
            from employee
                group by job;


--03.count(*) 함수를 이용하여 담당 업무가 동일한 사원 수를 출력하시오.
select job, count(*) 
    from employee
--        where manager is not null --사장님은 사원이 아니므로 뺀다면~
            group by job;

--04.관리자에 해당하는 사람의 수를 나열하시오.
--나는 job 에서의 Manager 인줄 알았는데, 상관라인의 Manager 였다.
--해설 : 더군다나 사람이 겹치는 탓에, distinct를 걸어야한다. 책이 틀렸음
select *from employee;
select count(distinct manager) from employee;

--05.급여 최고액, 급여 최저액의 차액을 출력하시오. 칼럼의 별칭은 결과 화연과 동일하게 지정하시오.
--모르겠다
--해설 : 아니 이렇게 쉬운 방법이;;; 
select
--    max(salary) as Max,
--    min(salary) as Min,
    max(salary) - min(salary) as Difference
    from employee;


--06.직급별 사원의 최저 급여를 출력하시오. 관리자를 알 수 없는 사원 및 최저 급여가 2000 미만인 그룹은 
--제외시키고 결과를 급여에 대한 내림차순으로 정렬하여 출력하시오.
--내가 한 것
select distinct job, min(salary) as "MIN Salary"
    from employee 
        where manager is not null 
            group by job 
                having min(salary) >= 2000
                    order by "MIN Salary" desc;
        
select job, min(salary), max(salary)
    from employee
        where job != 'PRESIDENT'
            group by job
                having min(salary) >= 2000
                    order by job desc;
                    
select job, min(salary), max(salary)
    from employee
            group by job
                having min(salary) >= 2000 and job != 'PRESIDENT'
                    order by job desc;


--07.각 부서에 대해 부서번호, 사원수, 부서 내의 모든 사원의 평균 급여를 출력하시오. 
--칼럼의 별칭은 결과 화면과 동일하게 지정하고 평균 급여는 소수점 둘째 자리로 반올림하시오.
select dno, count(*), round(avg(salary), 2) 
    from employee
        group by dno;

--08.각 부서에 대해 부서번호 이름, 지역명, 사원수, 부서내의 모든 사원의 평균 급여를 출력하시오. 
--칼럼의 별칭은 결과 화면과 동일하게 지정하고 평균 급여는 정수로 반올림하시오.
--모르겠다
select department.dno
    from department;

--09.업무를 표시한 다음 해당 업무에 대해 부서번호별 급여 및 부서 10, 20, 30의 급여 총액을 각각 출력하시오.
--각 칼럼에 별칭은 각각 Job, 부서 10, 부서 20, 부서 30, 총액으로 지정하시오.
--모르겠음
select job, dno,
    sum(salary) as "부서 10",
    sum(salary) as "부서 20",
    sum(salary) as "부서 30",
    sum(salary) as "총액"
        from employee group by job, dno;
        
select job, dno from employee group by job, dno;