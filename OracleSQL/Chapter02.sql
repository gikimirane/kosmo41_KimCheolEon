select eno, ename, salary
    from employee
--    where salary = 1500;
--    where salary <= 1500;
    where salary <> 1500;

select * from employee 
--    where dno=10;
--    where ename = 'SMITH';
--    where job = 'ANALYST';
--    where MANAGER = 7566;
    where hiredate <= '1981/01/01'; --��¥�񱳵� ����

select * from employee
--    where dno=10 and job='MANAGER';
--    where dno=10 or job='MANAGER';
    where not dno=10;

--������ �� ����� ���ϱ�?, ���Ǽ��� �����ϱ�?
select *from employee
    where salary between 1000 and 1500;
--    where salary>=1000 and salary<=1500;

--select * from employee
--    where commission in(300, 500, 1400);
    
--select * from employee
--    where ename like 'F%';
--    where ename like '%N';
--    where ename like '%A%';
--    where ename like '_A%';  
--    where ename like '%E_';

--select * from employee
--    where commission is not null;
--    where commission is null;

--select * from employee
--    order by salary asc;
--    order by salary desc;
--    order by ename asc;    
--    order by hiredate desc;
--    order by salary desc, ename asc; --salary �� ���� ��, �̸��� ���� ���� �߰�
