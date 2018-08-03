drop table CHAT_USERS;
drop table ROOMLIST;
drop sequence ROOM_NUM;
create sequence ROOM_NUM
INCREMENT by 1
start with 1;

create table CHAT_USERS(
    NAME varchar2(30) not null,
    LOGIN varchar2(5) not null,
    BLOCK varchar2(10) not null,
    LOCATION varchar2(5) not null,
    ROOMADMIN varchar2(10) not null,
    HOLDWHISPER varchar2(10) not null,
    WHISPERNAME varchar2(30),
    INVITE varchar(10),
    BANNLIST varchar(300),
    BANNWORD varchar(1000),
    primary key(NAME)
);

insert into CHAT_USERS 
values('김철언', upper('NOTIN'), upper('NOTBLOCK'), '1', upper('NOADMIN'), upper('NOHOLD'), null, upper('NOINVITE'), null, null);
insert into CHAT_USERS 
values('김철언ㅋ', upper('NOTIN'), upper('BLOCK'), '1', upper('NOADMIN'), upper('NOHOLD'), null, upper('NOINVITE'), null, null);
insert into CHAT_USERS 
values('오연중', upper('NOTIN'), upper('NOTBLOCK'), '1', upper('NOADMIN'), upper('NOHOLD'), null, upper('NOINVITE'), null, null);
insert into CHAT_USERS 
values('정회현', upper('NOTIN'), upper('NOTBLOCK'), '1', upper('NOADMIN'), upper('NOHOLD'), null, upper('NOINVITE'), null, null);



create table ROOMLIST(
    RNUMBER number(5) not null,
    RMAX varchar2(10) not null,
    RUSERCOUNT varchar2(10) not null,
    RHIDDEN varchar2(10) not null,
    RNAME varchar2(200) not null,
    RPASS varchar2(50),
    primary key(RNUMBER)
);

insert into ROOMLIST(RNUMBER, RMAX, RUSERCOUNT, RHIDDEN, RNAME) values(1, 'INF', 'INF','공개', '대기실');

commit;
