create table customer (
    id varchar2(20) not null,
    pwd varchar2(20) not null,
    name varchar2(20) not null,
    phone varchar2(30),
    address varchar2(100)
);

desc customer;

insert 
into customer(id, pwd, name, phone, address) 
values('a', 'a', '전우치', '010-1234-5678', '금천구 가산동');
select * from customer;


----------------------------------------------------------------------

drop table customer;

create table customer (
    id varchar2(20) not null,
    pwd varchar2(20) not null,
    name varchar2(20) unique,   --unique 의 사용 / 중복 x
    phone varchar2(30),
    address varchar2(100)
);

insert 
into customer(id, pwd, name, phone, address) 
values('a', 'a', '전우치', '010-1234-5678', '금천구 가산동');

------------------------------------------------------------------------
drop table customer;

create table customer (
    id varchar2(20) constraint customer_id_uk unique, -- unique 의 제약조건이름
    pwd varchar2(20) not null, --not null한테까지 이름을 지어주기엔 좀 그럼
    name varchar2(20) not null,
    phone varchar2(30),
    address varchar2(100)
);

desc customer;

select table_name, constraint_name
from user_constraints
where table_name in('CUSTOMER');

-------------------------------------------------------------------------
drop table customer;

create table customer (
    id varchar2(20),
    pwd varchar2(20) not null,
    name varchar2(20) not null,
    phone varchar2(30),
    address varchar2(100),
--    primary key(phone)
    constraint customer_id_pk primary key(id)
);

---------------------------------------------------------------------------
-- department 문제있어서 잠시 패스

drop table emp_second;
create table emp_second(
    eno number(4) constraint emp_second_eno_pk primary key,
    ename varchar2(10),
    job varchar2(9),
    dno number(9) constraint emp_second_dno_fk references department
    --쉼표오타랑 타입을 맞춰야함 varchar2 - number
);


alter table department
add constraint department_dno_pk primary key(dno);

-----------------------------------------------------------------------------
drop table emp_second;

create table emp_second(
    eno number(4) constraint emp_second_eno_pk primary key,
    ename varchar2(10),
    salary number(4) constraint emp_second_salary_min CHECK(salary>0)
);

insert into emp_second values('9999', '홍길동', '10');
insert into emp_second values('9998', '홍길동', '0');  --조건 위배

---------------------------------------------------------------------------------

create table emp_second(
    eno number(4) constraint emp_second_eno_pk primary key,
    ename varchar2(10),
    salary number(7, 2) default 1000
);

insert into emp_second
values (3, '홍길동');

select * from emp_second;

------------------------------------------------------------------------------------

desc emp_copy;
select table_name, constraint_name
from user_constraints
where table_name in('EMP_COPY');

alter table emp_copy
add constraint emp_copy_eno_pk primary key(eno);

delete from emp_copy;

insert into emp_copy
select * from employee;

select *from emp_copy;
desc emp_copy;

alter table emp_copy
add constraint emp_copy_eno_pk primary key(eno); --제약조건 추가 (primary key)


alter table emp_copy
drop primary key; --제약 조건의 제거

alter table emp_copy
--disable constraint emp_copy_eno_pk;
enable constraint emp_copy_eno_pk;
--제약조건 비활성화 / 할성화
----------------------------------------------------------------------------


select table_name, constraint_name
from user_constraints
where table_name in('EMP');

drop table dept_copt;


create table dep
as
select *from department;

create table emp
as
select *from employee;

alter table dept_copy
add primary key(dno);

alter table dept_copy
add foreign key(dno) references dept_copy(dno);

alter table emp_copy
add primary key(dno);

alter table emp_copy
drop primary key;

delete from emp_copy;

alter table dept_copy
drop primary key;

-------------------------------------------------------------------------------------
drop table dep;
drop table emp;

drop table department;

create table dep
as
select *from department;

create table emp
as
select *from employee;

