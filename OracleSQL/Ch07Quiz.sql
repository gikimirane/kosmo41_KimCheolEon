--Chater 07_서브 쿼리

--01.사원번호가 7788인 사원과 담당 업무가 같은 사원을 표시(사원이름과 담당 업무)하시오.
--7788사원을 구하고, 담당업무가 같은놈을 표시해야함
select job from employee where eno='7788';
--SCOTT의 job 을 구해버렸다
select ename, job 
from employee a
where job = (
    select job 
    from employee 
    where eno='7788'
);


--02.사원번호가 7499인 사원보다 급여가 많은 사원을 표시(사원이름과 담당 업무)하시오.
--사원번호가 7499인 사원보다 급여가 많은 사원을 찾자 - 그럼 7499인 놈의 급여를 구해야한다
--select salary from employee where eno='7499';
select ename, job, salary
from employee
where salary > (
    select salary
    from employee
    where eno='7499'
);

--03.최소 급여를 받는 사원의 이름, 담당 업무 및 급여를 표시하시오(그룹함수 사용).
--select min(salary) from employee;
select  ename, job, salary
from employee
where salary = (
    select min(salary) 
    from employee
);

--04.평균 급여가 가장 적은 직급(job)과 평균 급여를 표시하시오.
--job 별 평균 급여가 가장 적은 사람은?
--select job, avg(salary) from employee group by job;
-- 업무 = 그놈
--select job, avg(salary) from employee
--where salary < all (select avg(salary) from employee group by job);
--교재 190p, 30번 부서에서 최소급여를 구한후 최소급여가 구한 최소 급여보다 큰 부서만 출력
select dno, min(salary)
from employee
group by dno
having min(salary) > (select min (salary) from employee where dno=30);
--min 안에 avg 넣는 식으로 응용이 되는구나

select job, avg(salary)
from employee
group by job
having avg(salary) = (select min(avg(salary)) from employee group by job);

select min(avg(salary)) from employee group by job;


--05.각부서의 최소 급여를 받는 사원의 이름, 급여, 부서번호를 표시하시오.
--각 부서의 최소급여
select job, min(salary) from employee group by job;

select ename, salary, dno
from employee
where salary = any (
    select min(salary) 
    from employee 
    group by job
);


--06.담당 업무가 분석가(ANALYST)인 사원보다 급여가 적으면서 업무가 분석가(ANALYST)가 아닌 사원들을 
--표 시(사원번호, 이름, 담당업무, 급여)하시오.
--분석가가 아닌 사람들, 사원이 아닌 킹도 빼고
select ename from employee where job!='ANALYST' and job!='PRESIDENT';

select eno, ename, job, salary
from employee
where salary in (
    select min(salary) 
    from employee
    where job!='ANALYST' and job!='PRESIDENT'
    group by job
);


--07.부하직원이 없는 사원의 이름을 표시하시오.
select *from employee;
--부하직원이 없는 사원 = 상사의 번호와 eno가 !아닐때?
select manager from employee
where manager is not null
group by manager;

select eno from employee
group by eno;

select eno, ename, manager
from employee
where eno not in (select manager from employee
where manager is not null
group by manager );

select eno, ename, manager
from employee;

select manager from employee
group by manager;


select eno, ename, manager
from employee
where eno not in (select manager from employee
where manager is not null);


--08.부하직원이 있는 사원의 이름을 표시하시오.
select eno, ename
from employee
where eno = any (select manager from employee
group by manager);

--09.BLAKE와 동일한 부서에 속한 사원의 이름과 입사일을 표시하는 질의를 작성하시오(단. BLAKE는 저|외).


--10.급여가 평균 급여 보다 많은 사원들의 사원번호와 이름을 표시하되 결과를 급여에 대해서 오름차순으로 정렬 하시오.


--11.이름에 K가 포함된 사원과 같은 부서에서 일하는 사원의 사원번호와 이름을 표시하는 질의를 작성하시오


--12.부서 위치가 DALLAS인 사원의 이름과 부서번호 및 담당 업무를 표시하시오.


--13.KING어|게 보고하는 사원의 이름과 급여를 표시하시오.


--14.RESEARCH 부서의 사원에 대한 부서번호 사원이름 및 담당 업무를 표시하시오.


--15.평균 급여 보다 많은 급여를 받고 이름에 M이 포함된 사원과 같은 부서에서 근무하는 사원의 사원번호, 이름, 급여를 표시하시오.


--16.평균 급여가 가장 적은 업무를 찾으시오.


--17.담당 업무가 MANAGER인 사원이 소속된 부서와 동일한 부서의 사원을 표시하시오.


