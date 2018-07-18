--Chapter06 조인하기

select A.dno, B.dname
    from employee A, department B
    order by A.dno;
    
select * from employee, department
where employee.dno = department.dno;

select employee.eno, employee.ename, department.loc from employee, department
where employee.dno = department.dno
--and employee.eno = 7788;
and department.dno = 20;

select a.eno, a.ename, b.loc from employee a, department b
where a.dno = b.dno
--and employee.eno = 7788;
and b.dno = 20;

select "a b".eno, "a b".ename, b.loc from employee "a b", department b
where "a b".dno = b.dno
--and employee.eno = 7788;
and b.dno = 20;

---------------------------------------------------------------------------------

select * from employee e natural join department d;

select * from employee join department d using(dno);

select A.eno, a.ename, B.dname, dno
from employee a join department b using(dno)
where a.eno = 7788;

---------------------------------------------------------------------------------

select ename, salary, grade from employee, salgrade
where salary between losal and hisal
and ename='SCOTT';


select a.ename, b.dname, a.salary, c.grade from employee a, department b, salgrade c
where a.dno = b.dno
and a.salary between c.losal and hisal;


--셀프 join
select a.eno, a.ename, a.manager, b.ename
from employee a, employee b
where a.manager = b.eno;


--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
--Outer Join
select a.eno, a.ename, a.manager, b.ename
from employee a, employee b
where a.manager = b.eno(+);

select e1.ename || ' 의 직속 상관은 ' || e2.ename
from employee e1 join employee e2 on e1.manager = e2.eno(+);

select e1.ename || ' 의 직속 상관은 ' || e2.ename
from employee e1 left outer join employee e2 on e1.manager = e2.eno;

