--Ch08Quiz

--01. dept 테이블생성
create table DEPT(
    DNO number(2),
    DNAME varchar2(14),
    LOC varchar2(13)
);
drop table dept;

create table DEPT
as
select *from department;


--02. emp 테이블 생성
create table EMP(
    ENO number(4),
    ENAME varchar2(10),
    DNO number(2)
);
drop table EMP;

create table EMP (ENO, ENAME, DNO)
as
select ENO, ENAME, DNO from employee;


--03. 긴 이름 저장용 EMP 테이블 수정
alter table EMP
modify ename varchar2(25);


--04. 임플로이 복사 임플로이2, 부분칼럼만, 칼럼명 변경
create table EMPLOYEE2 (EMP_ID, NAME, SAL, DEPT_ID)
as
select eno, ename, salary, dno from employee;


--05. EMP 테이블의 삭제
drop table EMP;


--06. EMPLOYEE2 를 EMP로 변경
alter table EMPLOYEE2
rename to emp;


--07. DEPT 테이블에서 DNAME 칼럼 제거
select *from dept;

alter table dept
drop column dname;


--08. dept 테이블에서 loc 칼럼을 unused로 표시
-- https://docs.oracle.com/cd/B28359_01/server.111/b28310/tables006.htm#ADMIN11659
-- unused 는 되돌릴 수 없음 / 삭제시간이 오래걸리는걸 염려해서 만든 마킹
alter table dept
set unused column loc;


--09. unusde 표시된것 칼럼들 삭제
-- 칼럼-'s'
alter table dept
drop unused columns;


