--Chapter12. 시퀀스와 인덱스

create sequence emp_eno_seq
INCREMENT by 1
start with 1;

delete from emp_copy;
select *from emp_copy;

select * from user_sequences;
--select * from user_views;

insert into emp_copy (eno, ename, job)
values (emp_eno_seq.nextval, '홍길동3', '영업');

--------------------------------------------------------------

select * from user_indexes;

select *
from user_ind_columns
where table_name in('EMPLOYEE');

create table emp_copy
as
select *from employee;

create index idx_employee_ename
on emp_copy(ename);

create index idx_employee_eno
on emp_copy(eno);

------------------------------------------------------------------
--*참고 : like 와 in 인덱스 안탐

select sigunguk a, law_name b
from zipcode
--where sidok = '서울특별시'
where law_name = '숭의동'
group by sigunguk, law_name
order by a, b;


create index idx_zipcode_sigunguk
on zipcode(sigunguk);

create index idx_zipcode_law_name
on zipcode(law_name);

--하하 테이블스페이스를 넉넉하게 늘리고 오토사이즈 걸어놔서 시행됨
create index idx_zipcode_sigungu_law_name
on zipcode(sigunguk, law_name);

drop index idx_zipcode_sigunguk;
drop index idx_zipcode_law_name;
drop index idx_zipcode_sigungu_law_name;


