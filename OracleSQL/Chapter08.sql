create table dept(
    dno number(2),
    dname varchar2(14),
    loc varchar2(13)
    );
    
      
create table dept2
as
select dno, dname, loc
from dept;
desc dept2;


create table dept3
as select *from dept;
desc dept3;


create table dept4(
dno1, dname1, loc1)
as select *from dept;
desc dept4;


alter table dept4
add (birth date);
desc dept4;


alter table dept4
add (school varchar2(20));
desc dept4;

alter table dept4
modify school varchar2(15);
desc employee;

alter table employee
modify ename varchar2(10);

desc dept4;
alter table dept4
drop column birth;


alter table dept4
--set unused (dno1);
set  (dno1)
desc dept4;

alter table dept4
drop unused columns;


rename dept4 to dept5;
rename dept5 to dept4;

desc dept2;
insert into dept2 values(10, '회계', '가산동');
commit;

select *from dept2;

drop table dept2;

desc dept3;
insert into dept3 values(10, '회계', '가산동');
commit;

select *from dept3;
truncate table dept3;
delete from dept3;




----------------------------------------------------------------------------------

select *from user_tables;
select *from all_tables;
select *from tab;

select *from dba_tables;

SELECT TABLESPACE_NAME, STATUS, CONTENTS FROM DBA_TABLESPACES;

select * from user_all;


SELECT tablespace_name, SUM(bytes), MAX(bytes) 
   FROM DBA_FREE_SPACE 
 GROUP BY tablespace_name;





