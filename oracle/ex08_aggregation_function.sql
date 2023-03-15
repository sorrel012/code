/* 함수, Fuction*/

/*집계 함수, Aggregation Function*/

/*1. count()*/
select count(name) from tblCountry;

-- 'AS'에 속한 나라 갯수
select count(name) from tblCountry where continent = 'AS';

select capital from tblCountry;
select count(capital) from tblCountry;

select population from tblCountry;
select count(population) from tblCountry; --null 포함되어 있음..

-- tblCountry에 나라가 총 몇 개? > 14
select count(name) from tblCountry;
select count(capital) from tblCountry;
select count(population) from tblCountry;

select count(*) from tblCountry;

-- 모든 직원 수
select count(*) from tblInsa;               --60
-- 연락처가 있는 직원 수
select count(tel) from tblInsa;             --57
select count(*) from tblInsa where tel is not null;
-- 연락처가 없는 직원 수
select count(*) - count(tel) from tblInsa;  --3
select count(*) from tblInsa where tel is null;

-- tblInsa 에 있는 부서들 수
select count(distinct buseo) from tblInsa;

-- tblComedian 남자 수, 여자 수

select count(*) from tblComedian where gender = 'm';
select count(*) from tblComedian where gender = 'f';

--남자수 여자수 한번에 구하기
--자주 사용되는 패턴**
select 
    count(*) as 전체인원수,
    count(case
        when gender = 'm' then '1'
    end) as 남자인원수, 
    count(case
        when gender = 'f' then '1'
    end) as 여자인원수
from tblComedian;

--tblInsa 기획부 몇명? 총무부 몇명? 개발부 몇명?
select 
    count(case
        when buseo = '기획부' then 1
    end) as 기획부, 
    count(case
        when buseo = '총무부' then 1
    end) as 총무부, 
    count(case
        when buseo = '개발부' then 1
    end) as 개발부
from tblInsa;


/*sum*/

select sum(height) from tblComedian;
select sum(height), sum(weight) from tblComedian;

select 
    sum(basicpay) as "지출 급여 합",
    sum(sudang) as "지출 수당 합",
--    sum(basicpay) + sum(sudang) as "총 지출"
    sum(basicpay + sudang) as "총 지출"
from tblInsa;





