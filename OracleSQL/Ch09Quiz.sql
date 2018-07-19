-- Ch09Quiz

--01.EMP 테이블의 구조만 복사하여 EMP_INSERT란 이름의 빈 테이블을 만드시오.
create table EMP_INSERT
as
select *from employee
where 0=1;

select *from EMP_INSERT;


--02.본인을 EMP_INSERT 테이블에 추가하되 SYSDATE를 이용해서 입사일을 오늘로 입력하시오.
insert into EMP_INSERT(hiredate)
values (sysdate);

select *from EMP_INSERT;


--03.EMP_INSERT 테이블에 옆 사람을 추가하되 TO_DATE 함수률 이용해서 입사일을 어제로 입력하시오.
insert into EMP_INSERT(hiredate)
values (to_date(sysdate-1));

select *from EMP_INSERT;


--04.emp!oyee 테이블의 구조와 내용을 복사하여 EMP_COPY란 이름의 테이블을 만드시오.
create table EMP_COPY
as
select *from employee;

select *from emp_copy;


--05.사원번호가 7788인 사원의 부서번호를 10번으로 수정하시오.
update emp_copy
set dno = 10
where eno=7788;

select *from emp_copy;


--06.사원번호 7788의 담당 업무 및 급여를 사원번호 7499의 담당 업무 및 급여와 일치하도록 갱신하시오.
update emp_copy
set job = (select job from emp_copy where eno=7499),
    salary = (select salary from emp_copy where eno=7499)
where eno=7788;


--07.사원번호 7369와 업무가 동일한 모든 사원의 부서번호를 
--사원 7369의 현재 부서번호로 갱신하시오.
update emp_copy
set dno = (select dno from emp_copy where eno=7369)
where job = (select job from emp_copy where eno=7369);

select job from emp_copy
where eno=7369;

select dno from emp_copy where eno=7369;

select *from emp_copy;

rollback;
commit;



--08.department 테이블의 구조와 내용을 복사하여 DEPT_COPY란 이름의 테이블을 만드시오.
create table DEPT_COPY
as
select *from department;

select *from dept_copy;


--09.DEPT_COPY 테이블에서 부서명이 RESEARCH인 부서를 제거하시오.
--update dept_copy
--set dname = null
--where dname = 'RESEARCH';
-- 아 라인 제거해달라고;
delete from dept_copy
where dname = 'RESEARCH';

select *from dept_copy;

rollback;
commit;


--10.DEPT_COPY 테이블에서 부서 번호가 1001거나 40인 부서를 제거하시오.
delete from dept_copy
where dno = 10 OR dno = 40;