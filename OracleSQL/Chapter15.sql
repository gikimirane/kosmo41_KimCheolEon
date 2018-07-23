--Chapter 15. 프로시저, 함수와 트리거

create procedure sp_salary
is
    v_salary employee.salary%type;

begin
    select salary into v_salary
    from employee
    where ename = 'SCOTT';
    dbms_output.put_line('SCOTT 의 급여는 ' || v_salary);
end;
/

execute sp_salary;

set serveroutput on;

---------------------------------------------------------------

select name, text from user_source
where name like('%SP_SALARY%');

drop procedure SP_SALARY;

---------------------------------------------------------------
---------------------------------------------------------------
--IN 매개변수

create or replace procedure sp_salary_ename
(
    v_ename in employee.ename%type
)
is
    v_salary employee.salary%type;

begin
    select salary into v_salary
    from employee
    where ename = 'SCOTT';
    dbms_output.put_line(v_ename || ' 의 급여는 ' || v_salary);
end;
/

execute sp_salary_ename('SCOTT');

select name, text from user_source;

drop procedure sp_salary_ename;

---------------------------------------------------------------
---------------------------------------------------------------
--OUT 매개변수

create or replace procedure sp_salary_ename2
(
    v_ename in employee.ename%type,
    v_salary out employee.salary%type
)
is
begin
    select salary into v_salary
    from employee
    where ename = v_ename;
end;
/

variable v_salary varchar2(14);
execute sp_salary_ename2('SCOTT', :v_salary);
print v_salary;

drop procedure sp_salary_ename2;

---------------------------------------------------------------
---------------------------------------------------------------
--함수, 매개변수 사용 안하고 결과값을 되돌려 줄라고 씀

create or replace function fn_salary_ename
(
    v_ename in employee.ename%type
)
    RETURN number
is
    v_salary number(7,2);
    
begin
    select salary into v_salary
    from employee
    where ename = v_ename;
    RETURN v_salary;
end;
/

variable v_salary number;
execute : v_salary := fn_salary_ename('SCOTT');
print v_salary;

---------------------------------------------------------------
--SQL 문에서 함수 호출

select ename, fn_salary_ename('SCOTT')
from employee
where ename = 'SCOTT';

select ename, fn_salary_ename('&id')
from employee
where ename = '&id';


---------------------------------------------------------------
---------------------------------------------------------------
--트리거 - insert

create table dept_original
as
select * from department where 0=1;


create table dept_copy
as
select * from department where 0=1;



create or replace trigger trg_sample1
    after insert
    on dept_original
    for each row
begin
    if inserting then
        DBMS_OUTPUT.PUT_LINE('Insert Triger 발생');
        insert into dept_copy
--            values(:new.dno, :new.dname, :new.loc);
            values(:new.dept_copy); --이렇게 통으로 날려도 되는군;;;
    end if;
end;
/

insert into dept_original
values (10, 'ACCOUNTING', 'NEW YORK2');

select *from dept_original;
select *from dept_copy;

select name, text from user_source;

delete from user_source cascade; --권한 딸림 못함 
select distinct name, type from user_source; -- 하나씩 찾아서 열심히 제거해야함

--열심히 수동으로 지워야함
drop procedure sp_salary_ename;
drop function FN_SALARY_ENAME;
drop trigger TRG_SAMPLE1;

---------------------------------------------------------------
--트리거 - delete

create or replace trigger trg_sample2
    after delete
    on dept_original
    for each row
begin
    DBMS_OUTPUT.PUT_LINE('Delete Triger 발생');
    delete from dept_copy
        where dept_copy.dno = :old.dno;
end;
/

drop trigger TRG_SAMPLE2;

select *from dept_original;
select *from dept_copy;

delete from dept_original where dno = 10;