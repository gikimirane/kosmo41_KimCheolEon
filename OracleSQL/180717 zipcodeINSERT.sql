select count (*) from zipcode;
select count (*) from zipcode where sidok='충청북도';

select * from zipcode where sidok='세종특별자치시';

delete from zipcode where sidok='세종특별자치시';

drop table ZIPCODE cascade CONSTRAINTS;

create table ZIPCODE (
	ZIPCODE varchar2(5) not null,
	SIDOK varchar2(20),
	SIDOE varchar2(40),
	SIGUNGUK varchar2(30),
	SIGUNGUE varchar2(40),
	UPMYENK varchar2(20),
	UPMYENE varchar2(40),
	DORO_CODE varchar2(12) not null,
	DOROK varchar2(80),
	DOROE varchar2(80),
	JIHA_FLAG varchar2(1),
	BD_NUM1 numeric(5),
BD_NUM2 numeric(5),
	BD_MNG_NUM varchar2(25),
	MULTI_NAME varchar2(40),
	BD_NAME varchar2(200),
	LAW_CODE varchar2(10),
	LAW_NAME varchar2(20),
	RI_NAME varchar2(20),
	ADMIN_DONG varchar2(40),
	SAN_FLAG varchar2(1),
	JIBEON1 numeric(4),
	UMD_SEQ varchar2(2) not null,
	JIBEON2 numeric(4),
	OLD_ZIP varchar2(6),
	OLD_SEQ varchar2(3)
);
