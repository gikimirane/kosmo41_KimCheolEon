--도로명정렬
--주소를 정렬 시 구 1길 2길.... 정렬 - 아 그그그 12345678910 그 기묘한 정렬을 바꿔볼것
--트랜슬레이트 & 리플레이스

select *from zipcode where sidok='인천광역시';

select sidok, upmyenk, replace(translate(dorok, '번지'), '', '0123456789') as test from zipcode
where sidok='인천광역시'
order by sigunguk, upmyenk, test;


select sidok, sigunguk, dorok,
tanslate(dorok, '0123456789' || dorok, '0123456789') A,
nvl(Translate(dorok, '0123456789' || dorok, '0123456789') , 0) B,
to_number(nvl(Translate(dorok, '0123456789' || dorok, '0123456789') , 0)) as order1
from zipcode
where dorok like '우각로%'
group by sidok, sigunguk, dorok
order by orde1;
