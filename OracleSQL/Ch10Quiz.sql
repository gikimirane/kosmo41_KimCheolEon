--Ch10Quiz

--01.employee 테이블의 구조를 복사히여 EMP_SAMPLE란 이름의 테이블을 만드시오. 
--사원 테이블의 사원번호 칼럼에 테이블 레벨로 primary key 제약 조건을 지정하되 
--제약 조건 이름은 my_emp_pk로 지정하시오.
create table EMP_SAMPLE
as
select *from employee
where 0=1;

select *from EMP_SAMPLE;

alter table emp_sample
add constraint my_emp_pk primary key(eno);

select table_name, constraint_name
from user_constraints
where table_name in ('EMP_SAMPLE');


--02.부서 테이블의 부서번호 칼럼에 테이블 레벨로 primary key 제약 조건을 지정하되 
--제약 조건 이름은 my_dept_pk로 지정하시오.
select *from dept_copy;
delete dept_copy;

alter table dept_copy
add constraint my_dept_pk primary key(dno);

select table_name, constraint_name
from user_constraints
--where table_name in ('DEPT_COPY');
where table_name in ('EMP_COPY');


--03.사원 테이블의 부서번호 칼럼에 존재하지 않는 부서의 사원이 배정되지 않도록 
--외래 키 제약 조건을 지정하되 제약 조건 이름은 my_emp_dept_fk로 지정하시오.
select *from dept_copy; --위에서 프라이머리 키가 이미 등록됬군
select *from emp_copy;

--아하, emp_copy에 프라이머리 키가 없었군?
alter table dept_copy
add constraint my_emp_dept_fk foreign key(dno) references emp_copy(dno);


--어 근데 emp에는 이미 중복된 사원번호가 있는데...
alter table emp_copy
add constraint my_emp_pk primary key(dno);

--아 둘이 바뀌었구나 --아 근데 emp_copy에 데이터가 있어서 에러나는듯
alter table emp_copy
add constraint my_emp_dept_fk foreign key(dno) references dept_copy(dno);

delete from emp_copy;


--04.사원 테이블의 커미션 칼럼에 0보다 큰 값만을 입력할 수 있도록 제약조건을 지정하시오.
--alter table emp_copy
--add CONSTRAINT my_emp_check check (commission > 0);
alter table emp_copy
add check (commission > 0);

alter table emp_copy
add constraint emp_commission_min check (commission > 0);





