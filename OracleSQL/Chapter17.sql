desc emp_copy;
desc dept_copy;

select eno, ename, job
from emp_copy
union
select dno, dname, loc
from dept_copy;
--두개의 결과를 묶어서 하나로 보여줌. 위는 숫자/문자/문자 -- 컬럼갯수, 순서, 타입이 같아야한다.
--생긴게 기묘한데?
--자체 distinct 기능이 default. union all 하면 다나옴


create table emp_copy2
as
select *from employee;

select *from emp_copy2;

delete from emp_copy2
where dno=30; --dno 10, 20 보유
select *from emp_copy2;


delete from emp_copy
where dno=20; --dno 10, 30 보유
select *from emp_copy1;


select *
from emp_copy
union
select *
from emp_copy2;


select *
from emp_copy
intersect
select *
from emp_copy2; --둘이 겹치는 dno 10 출력


select *
from emp_copy --dno 10, 30 보유
minus
select *
from emp_copy2; --dno 10, 20 보유
--차집합이니까, emp_copy - emp_copy2 니까 30만 나오는구나


select *
from emp_copy2 --dno 10, 20 보유
minus
select *
from emp_copy; --dno 10, 30 보유
--10,20 에서 10,30 빼니까  20 나옴