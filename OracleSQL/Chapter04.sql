--chapter04 다양한 함수

--select 'Oracle mania', 
--    upper('Oracle mania'), 
--    lower('Oracle mania'), 
--    initcap('Oracle mania')
--        from dual;

--select lengthb('Oraclemania'), lengthb('오라클매니아')
--    from dual;
    

--select 'Oracle', 'mania', 
--    concat('Oracle', 'mania'), 'Oracle' || 'mania' 
--        from dual;

--select substr('동해물과 백두산이', 2, 2),
--        substrb('동해물과 백두산이', 1, 3),
--        substrb('동해물과 백두산이', 4, 3)
--            from dual;

--이런 젠장 한글 3byte 로 설정되있음
--select *from nls_database_parameters where parameter = 'NLS_CHARACTERSET';

--select '[' || trim(' Oracle mania ') || ']' from dual;

--select 578.7654,
--        round(578.7654), --.7 반올림
--        round(578.7654, 1),
--        round(578.7654, 2), --소숫점 둘째자리
--        round(578.7654, -1), --정수 자릿수로 간다
--        round(578.7654, -2)
--            from dual;

--select ename, round(round(sysdate-hiredate)/365) as 입사일로부터 from employee;
--select ename, hiredate, round(sysdate-hiredate), trunc(MONTHS_BETWEEN(sysdate, hiredate)) from employee;
--select ename, hiredate, ADD_MONTHS(hiredate, 120) from employee;

--찾고자 하는 요일은 오라클 설치시 설정한 언어 값에 다라 한국어, 영어... 등으로 달라짐....
select sysdate, next_day(sysdate, '금') from dual;
select sysdate, last_day(ADD_MONTHS(sysdate, 2)) from dual;


select TO_CHAR(sysdate, 'YYYY-MM-DD DAY dy') from dual;
select ename, hiredate, TO_CHAR(hiredate, 'YYYY-MM-DD DAY dy day') from employee;
select To_CHAR(sysdate, 'hh:mi:ss') from dual;

--select ename, hiredate from employee where hiredate=19810220;
select ename, hiredate from employee where hiredate=to_date(19810220, 'yy-mm-dd');

select to_number('100,000', '999,999') - to_number('50,000', '999,999') from dual;

select ename, salary*12, commission, '커미션 = ' || nvl(commission, 0) from employee;
select ename, salary*12, commission, '커미션 = ' || nvl2(commission, 0, 300) from employee;

select ename, salary, commission, coalesce(commission, salary, 0) from employee order by job;

select ename, dno, decode(dno, 10, 'ACCOUNTING',
                                20, 'REASEARCH',
--                                30, 'SALES',
                                '???') as 부서명 from employee;
                                
select ename, dno,
    case when dno=10 then '부서10'
        when dno=20 then '부서20'
--        when dno=30 then '부서30'
        else '아몰랑'
        end as DNAME
        from employee order by dno;
    




