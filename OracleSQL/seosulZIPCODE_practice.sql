select count (*) from zipcode
    where bupname = '�Ż絿';
    
select distinct sigungu from zipcode
    where bupname = '�Ż絿';
    
select count (*) from zipcode
    where bupname like '_��%';

select * from zipcode
    where bupname like '_��%';

select distinct sigungu from zipcode
    where hangname = '�Ż絿';

select distinct doroname from zipcode
    where doroname like '������%'
    order by doroname;
    