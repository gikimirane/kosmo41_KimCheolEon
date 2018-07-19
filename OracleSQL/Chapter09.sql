desc dept;

insert into dept values(1, 'Account', '가산');
insert into dept(dno, dname, loc) values (2, 'Sales', '구로');
insert into dept(dno, dname) values (3, 'MArketting');
insert into dept(dno, loc) values(4, '남구로');

select *from dept;

--데이터 통쨰로 복사됨
create table dept2
as
select *from department;

desc dept2;
select *from dept2;

--데이터를 제외한 구조만 복사...오 신기
create table dept4
as
select *from department where 0 = 1;

desc dept4;
select *from dept4;

-------------------------------------------------------

insert into dept values (5, 'Analyst', null);
select *from dept;

create table emp_copy
as
select * from employee where 0=1;
select count (*) from emp_copy;



insert into emp_copy values(7008, 'CANDY', 'MANGER', 7788, '18,07,21', 500, null, 10);
desc emp_copy;
select *from employee;
select *from emp_copy;

insert into emp_copy 
values(7009, 'CANDY', 'MANGER', 7788, to_date('2018,07,19', 'yyyy-mm-dd'), 500, null, 10);

--서브쿼리로 다른 테이블 복사 / 이전에서는 as로 테이블을 복사할 수 있었음.
insert into emp_copy
select *from employee;

insert into emp_copy (eno, ename)
select eno, ename from employee;

insert into emp_copy (eno, ename, manager)
select eno, ename, '7788' from employee;

select *from emp_copy;

-----------------------------------------------------------------------------------------------

select *from emp_copy where ename='CANDY';

--update는 사용시 주의하며 where를 걸고 꼭 쓸것;
update emp_copy set MANAGER = 7782 where eno = 7000;

update emp_copy set ename = 'CANDYDATE' where ename = 'CANDY';

select *from emp_copy;



create table dept_copt
as
select *from department where 1=0;

desc dept_copt;

insert into dept_copt
select * from department;

select *from dept_copt;

update dept_copt
set loc = (select loc from dept_copt
where dno = 20)
where dno = 10;

select *from dept_copt;

-------------------------------------------------
--delete도 위험하니 꼭 카운트를 세어보든가 select 등 확인을 해보고 운용할것
select count(*) from dept_copt
where loc='DALLAS';

delete from dept_copt
where loc='DALLAS';

select *from dept_copt;

----------------------------------------------------
--다른 창 띄우고 시작 / 상단 비공유 SQL 워크시트
select *from dept_copt;
commit;

insert into dept_copt values(10, 'ACC1', 'D');
insert into dept_copt values(20, 'ACC1', 'D');
update dept_copt set loc = 'A' where dno = 10;
rollback;



