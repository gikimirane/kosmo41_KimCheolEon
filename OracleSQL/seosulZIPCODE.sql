create table ZIPCODE(
	zipcode varchar2(5),
	sido varchar2(14),
	sidoe varchar2(20),
	sigungu varchar2(20),
	sigungue varchar2(20),
	myun varchar2(2),
	myun2 varchar2(2),
	dorocode varchar2(12),
	doroname varchar2(20),
	doronamee varchar2(20),
	jiha varchar2(1),
	buildnum1 varchar2(3),
	buildnum2 varchar2(3),
	buildmng varchar2(25),
	name2 varchar2(30),
	name3 varchar2(30),
	bupcode varchar2(10),
	bupname varchar2(20),
	riname varchar2(20),
	hangname varchar2(20),
	sancheck varchar2(1),
	jibun1 varchar2(10),
	myunnum varchar2(10),
	jibun2 varchar2(10),
	oldzip varchar2(10),
	oldzipnum varchar2(10)
);

ALTER TABLE ZIPCODE MODIFY doronamee varchar2(30);
ALTER TABLE ZIPCODE MODIFY sido varchar2(20);
ALTER TABLE ZIPCODE MODIFY name3 varchar2(100);
ALTER TABLE ZIPCODE MODIFY buildnum1 varchar2(20);
ALTER TABLE ZIPCODE MODIFY buildnum2 varchar2(20);
ALTER TABLE ZIPCODE MODIFY doroname varchar2(50);
ALTER TABLE ZIPCODE MODIFY hangname varchar2(50);

select count (*) from ZIPCODE;

delete frome ZIPCODE; --틀 남기고 제거
commit; --적용

--drop table ZIPCODE; --완전히 drop
