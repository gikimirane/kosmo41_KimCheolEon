create table ZIPCODE_INCHEON(
	zipcode varchar2(10),
	sido varchar2(30),
	sidoe varchar2(30),
	sigungu varchar2(30),
	sigungue varchar2(30),
	myun varchar2(20),
	myun2 varchar2(20),
	dorocode varchar2(20),
	doroname varchar2(50),
	doronamee varchar2(50),
	jiha varchar2(1),
	buildnum1 varchar2(20),
	buildnum2 varchar2(20),
	buildmng varchar2(25),
	name2 varchar2(30),
	name3 varchar2(100),
	bupcode varchar2(10),
	bupname varchar2(20),
	riname varchar2(20),
	hangname varchar2(50),
	sancheck varchar2(1),
	jibun1 varchar2(10),
	myunnum varchar2(10),
	jibun2 varchar2(10),
	oldzip varchar2(10),
	oldzipnum varchar2(10)
);

select count (*) from ZIPCODE_INCHEON;

delete from ZIPCODE_INCHEON; --틀 남기고 제거
drop table ZIPCODE_INCHEON;
commit; --적용


select zipcode, sido, sigungu, doroname, buildnum1, buildnum2, name3, hangname, jibun1, jibun2
    from zipcode_incheon
        where sigungu='미추홀구' and doroname like '우각로' and jibun1=104
        order by doroname;