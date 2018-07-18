--07. 서브쿼리

select ename, salary from employee
where salary > (
    select salary from employee where ename = 'SCOTT'
);

select ename, salary from employee 
where salary > 3000;


---------------------------------------------
--단일행 서브쿼리

select ename, dno from employee where dno = (select dno from employee where ename='SCOTT');


select a.ename, a.dno, b.dname 
from employee a, department b
where a.dno = (
    select dno from employee where ename = 'SCOTT'
)
and a.dno = b.dno 
and a.ename != 'SCCOT';


---------------------------------------------
--다중행 서브쿼리
select eno, ename, salary
from employee;

select dno, min(salary)
from employee
group by dno;

--발전
select eno, ename
from employee 
where salary in (
    select min(salary) 
    from employee 
    group by dno
);

--더 발전
select a.eno, a.ename, b.dno, b.dname
from employee a, department b
where a.dno = b.dno
and a.salary in (
    select min(salary) 
    from employee 
    group by dno
);

--최종
select a.eno, a.ename, a.salary, b.dname
from employee a, department b
where a.dno = b.dno
and a.salary in (
    select min(salary) 
    from employee 
    group by dno
);

---------------------------------------------
-- ANY 연산자
select eno, ename, job, salary
from employee
where job != 'SALESMAN'
and salary < any(500, 900, 1000) ;
--any 안에 하나라도 참이면 됨

select eno, ename, job, salary
from employee
where job != 'SALESMAN'
and salary < any(
    select salary
    from employee
    where job='SALESMAN'
);


---------------------------------------------
--ALL 연산자
select eno, ename, job, salary
from employee
where job = 'SALESMAN';


select eno, ename, job, salary
from employee
where job != 'SALESMAN'
and salary < ALL(
    select salary
    from employee
    where job='SALESMAN'
);


