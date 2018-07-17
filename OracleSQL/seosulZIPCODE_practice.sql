select count (*) from zipcode
    where bupname = '신사동';
    
select distinct sigungu from zipcode
    where bupname = '신사동';
    
select count (*) from zipcode
    where bupname like '_신%';

select * from zipcode
    where bupname like '_신%';

select distinct sigungu from zipcode
    where hangname = '신사동';

select distinct doroname from zipcode
    where doroname like '개포로%'
    order by doroname;
    