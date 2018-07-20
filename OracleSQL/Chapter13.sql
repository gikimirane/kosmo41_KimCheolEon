drop user test1 cascade;


create user test1 identified by 0000;
create user test2 identified by 0000;
create user test3 identified by 0000;


grant create session to test1;
grant select on scott.employee to test1 with grant option;
grant create view to test1;

create view em_view
as
select *from scott.emploee;

grant select on test1.em_view to test2;
grant select on test1.em_view to test3;

grant create session to test2;
grant create session to test3;

revoke select on scott.employee from test1; 

grant roletest01 to test2;
grant roletest01 to test3;

drop role roletest01 cascade; --얘는 roletest01 을 가진 애까지 체인으로 삭제함

select *from user_role_privs;

create role roletest01;
grant create session, create table, create view to roletest01;

SELECT * FROM user_role_privs;

------------------테스트를 해봤는데, 하위 권한 날라가는게 끈만 끊기는 거였음
