select * from user_views;


create table emp_copy
as
select *from employee;

create table dept_copy
as
select *from department;
 
select *from emp_copy;
select eno, ename, job, manager, dno
from emp_copy;
 
create view v_emp_copy
as
select eno, ename, job, manager, dno
from emp_copy;
 
desc user_views;
 
select *from v_emp_copy;
delete from v_emp_copy
where eno=7369;
 
create view v_emp2
as
select  a.eno, a.ename, a.salary, dno, b.dname, b.loc
from emp_copy a natural join dept_copy b;
 
select *from v_emp2;

---------------------------------------------------------------------

--create view v_emp3
--create force view v_emp3
create or replace view v_emp3 --보통 이걸로 덮어씌운다고 함
as
select dno, 
    sum(salary) as "sal_sum",
    avg(salary) as "sal_avg"
    from emp_copy
    group by dno;
    
select dno, "sal_sum", round("sal_avg") from v_emp3;

------------------------------------------------------------------

drop table emp_copy;
drop view v_emp3;

create table emp_copy
as
select *from employee;

create or replace view v_emp1
as
select eno, ename, dno, job
from emp_copy
where job = 'MANAGER';
select *from v_emp1;

--나는 view 에 insert 하고자 했는데, view의 보관된 스크립트상에는 MANAGER만을 본다.
--그래서 하단의 데이터는 emp_copy 에 들어가있다.
insert into v_emp1 values(1, '홍길동', 10, 'CLERK');

create or replace view v_emp1
as
select eno, ename, dno, job
from emp_copy
where job = 'MANAGER' with check option; --check option 이 붙어있어서 violation 에러 띄움
-- with check option 이 붙으면 해당 view 가 보는 범위에서 insert를 하도록 요청함
-- with read only 하면 select 밖에 안됨

insert into v_emp1 values(2, '전우치', 10, 'CLERK');