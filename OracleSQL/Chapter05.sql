--Chapter 05. 그룹함수

select sum(salary) 총합,
        round(avg(salary)) 평균,
        max(salary) 최대값,
        min(salary) 최소값
        from employee;
        
select sum(commission) as "커미션 총액" from employee;

select count (*) as "사원의 수" from employee where dno=10;
select count (*) as "사원의 수" from employee where dno in (10, 20);

select distinct job as "직업 종류" from employee;
select count (job) as "직업 종류" from employee;
select count(distinct job) as "직업 종류" from employee;

select dno, salary from employee where dno = 20;
select round(avg(salary), 1) from employee where dno=20;
--한방에 가자!
select dno, round(avg(salary)) from employee group by dno;
--select ename, dno, round(avg(salary)) from employee group by dno;

--select dno, job, round(avg(salary)) from employee group by dno, job;


--그룹간의 관계를 좀 미묘하게 잘 봐야함
select dno, job, count (*), sum(salary)
    from employee
        group by dno, job
        order by dno, job;
        
--그룹의 제한은 where 가 아니라 having 에 넣는다!
select dno, max(salary)
    from employee
        group by dno
            having max(salary) >= 3000;
            
select dno, min(salary)
    from employee 
        group by dno 
--            having min(salary) > 1000;
            having dno=10;