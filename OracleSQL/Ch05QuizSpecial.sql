--1. 서울시의 모든 구를 출력하시오.
--2. 서울시의 모든 구별 동이름(법정동)을 출력하시오.
--3. 서울시의 모든 구별 중학교 수를 출력하시오.

--전국에서, 서울시의 모든 구 출력
select sigunguk from zipcode where sidok='서울특별시' group by sigunguk;
--서울시의 구 갯수
select count(distinct sigunguk) from zipcode where sidok='서울특별시';

--서울시의 모든 구별 동이름
select law_name from zipcode where sidok='서울특별시' group by law_name;
--서울시의 동 갯수
select count(distinct law_name) from zipcode where sidok='서울특별시' ;


--서울시의 시/구/동/중학교
select sidok, sigunguk, law_name, bd_name from zipcode where sidok='서울특별시' and substr(bd_name, -3, 3)='중학교'
order by sigunguk, law_name;

select sigunguk, law_name, count(*) from zipcode where sidok='서울특별시' group by sidok;



-------------해설-------------
--1. 내가 생각한게 맞음
select sigunguk from zipcode where sidok='서울특별시' group by sigunguk order by sigunguk;
--1. 추가해설
select sidok, sigunguk from zipcode group by sidok, sigunguk having sidok='서울특별시' order by sigunguk;


--2. 대체로 비슷한데, 특히 동 카운터에 갯수는 더 좋음
select sigunguk, law_name from zipcode 
    where sidok='서울특별시' group by sigunguk, law_name 
        order by sigunguk, law_name;

select sigunguk, count(distinct law_name) from zipcode where sidok='서울특별시' group by sigunguk
    order by sigunguk;


--3. 중학교 탐색쪽은 비슷함. 카운트만 좀 더 확실히 구분지으면 결과가 나왔을듯
select sigunguk, count(*) from zipcode where sidok='서울특별시' and bd_name like '%중학교%'
group by sigunguk
order by sigunguk;

select sigunguk, bd_name from zipcode where sidok='서울특별시' and bd_name like '%중학교%'
group by sigunguk, bd_name
order by sigunguk;