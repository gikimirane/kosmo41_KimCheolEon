--서울시의 모든 구를 출력하시오.
--서울시의 모든 구별 동이름(법정동)을 출력하시오.
--서울시의 모든 구별 중학교 수를 출력하시오.

--전국에서, 서울시의 모든 구 출력
select sigunguk from zipcode where sidok='서울특별시' group by sigunguk;
--서울시의 구 갯수
select count(distinct sigunguk) from zipcode where sidok='서울특별시';

--서울시의 모든 구별 동이름
select law_name from zipcode where sidok='서울특별시' group by law_name;
--서울시의 동 갯수
select count(distinct law_name) from zipcode where sidok='서울특별시' ;


--서울시의 시/구/동/중학교
select sidok, sigunguk, law_name, bd_name from zipcode where sidok='서울특별시' and substr(bd_name, -3, 3)='중학교';

select sigunguk, law_name, count(*) from zipcode where sidok='서울특별시' group by sidok;



