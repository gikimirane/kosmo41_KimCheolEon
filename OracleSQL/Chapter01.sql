--select * from employee;

--select ename, salary, salary*12
--    from employee;

--select salary, salary+300, salary/4, salary*13+200 from employee;

--select ename, salary, job, dno, nvl(commission, 0), salary*12, salary*12+nvl(commission, 0)
--    from employee;

--select ename, salary, job, dno, nvl(commission, 0), salary*12, salary*12+nvl(commission, 0) 
--    from employee;

--select ename, salary, job, dno, nvl(commission, 0), 
--        salary*12, salary*12+nvl(commission, 0) as "¿¬ ºÀ Å× ÀÌ ºí"
--    from employee;

--select dno
--    from employee;

--select DISTINCT dno, job
--    from employee;

desc dual;
select * from dual;
select sysdate from dual;
