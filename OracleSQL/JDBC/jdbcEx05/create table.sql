create table test3(
    id varchar (10),
    password varchar(10)
);

insert into test3 values('이순신', '00000');

commit;

select rownum, id, password from test3;

delete from test3;