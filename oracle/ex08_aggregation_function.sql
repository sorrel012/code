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


/*avg*/
select sum(basicpay) / count(*) from tblInsa;

select avg(basicpay) from tblInsa;

-- 평균 인구수 
select 
    avg(population) as "평균1",
    sum(population) / count(*) as "평균2",
    sum(population) / count(population) as "평균3"
from tblCountry;

-- 회사 > 성과급 지급 > 성과급 출처 : 1팀 공로
--1. 균등 지급: 총지급액 / 모든 직원수 = sum() / count(*)
--2. 차등 지급: 총지급액 / 참여 직원수 = sum() / count(참여직원수)  > avg()


/*min , max*/


select max(height), min(height) from tblComedian; --숫자형
select max(name), min(name) from tblInsa; --문자형
select max(ibsadate), min(ibsadate) from tblInsa; --날짜형



/*=======================문제=======================*/

-- 집계함수 > sum(), avg(), max(), min()

-- 집계함수 > count()


-- 1. tblCountry. 아시아(AS)와 유럽(EU)에 속한 나라의 개수?? -> 7개
select 
    count(*) 
from tblCountry 
    where continent in ('AS', 'EU');

-- 2. 인구수가 7000 ~ 20000 사이인 나라의 개수?? -> 2개
select 
    count(*) 
from tblCountry 
    where population between 7000 and 20000;

-- 3. hr.employees. job_id > 'IT_PROG' 중에서 급여가 5000불이 넘는 직원이 몇명? -> 2명
select 
    count(*)
from hr.employees
    where job_id = 'IT_PROG' and salary > 5000;

-- 4. tblInsa. tel. 010을 안쓰는 사람은 몇명?(연락처가 없는 사람은 제외) -> 42명
select 
    count(*)
from tblInsa
    where tel is not null and tel not like '010%';

-- 5. city. 서울, 경기, 인천 -> 그 외의 지역 인원수? -> 18명
select 
    count(*)
from tblInsa
    where city not in ('서울', '경기', '인천');

-- 6. 여름태생(7~9월) + 여자 직원 총 몇명? -> 7명
select 
    count(*)
from tblInsa
    where (ssn like '__07%'or ssn like '__08%' or ssn like '__09%')
        and ssn like '%-2%';

-- 7. 개발부 + 직위별 인원수? -> 부장 ?명, 과장 ?명, 대리 ?명, 사원 ?명
select 
    count(case
        when jikwi = '부장' then 1
    end) as 부장, 
    count(case
        when jikwi = '과장' then 1
    end) as 과장, 
    count(case
        when jikwi = '대리' then 1
    end) as 대리,
    count(case
        when jikwi = '사원' then 1
    end) as 사원
from tblInsa
    where buseo = '개발부';

--sum()
--1. 유럽과 아프리카에 속한 나라의 인구 수 합? tblCountry > 14,198
select 
    sum(population)
from tblCountry
    where continent in ('EU', 'AF');

--2. 매니저(108)이 관리하고 있는 직원들의 급여 총합? hr.employees > 39,600
select 
    sum(salary)
from hr.employees
    where manager_id = 108;

--3. 직업(ST_CLERK, SH_CLERK)을 가지는 직원들의 급여 합? hr.employees > 120,000
select
    sum(salary)
from hr.employees
    where job_id in ('ST_CLERK', 'SH_CLERK');

--4. 서울에 있는 직원들의 급여 합(급여 + 수당)? tblInsa > 33,812,400
select
    sum(basicpay + sudang)
from tblInsa
    where city = '서울';

--5. 장급(부장+과장)들의 급여 합? tblInsa > 36,289,000
select 
    sum(basicpay)
from tblInsa
    where jikwi in ('부장', '과장');
    
--avg()
--1. 아시아에 속한 국가의 평균 인구수? tblCountry > 39,165
select 
    avg(population)
from tblCountry
    where continent = 'AS';

--2. 이름(first_name)에 'AN'이 포함된 직원들의 평균 급여?(대소문자 구분없이) hr.employees > 6,270.4
select
    avg(salary)
from hr.employees
    where first_name like '%an%' 
        or first_name like '%AN%' 
        or first_name like '%aN%' 
        or first_name like '%An%';

--3. 장급(부장+과장)의 평균 급여? tblInsa > 2,419,266.66
select 
    avg(basicpay)
from tblInsa
    where jikwi in ('부장', '과장');

--4. 사원급(대리+사원)의 평균 급여? tblInsa > 1,268,946.66
select 
    avg(basicpay)
from tblInsa
    where jikwi in ('대리', '사원');

--5. 장급(부장,과장)의 평균 급여와 사원급(대리,사원)의 평균 급여의 차액? tblInsa > 1,150,320
select distinct
    (select
        avg(basicpay)
    from tblInsa
    where jikwi in ('부장', '과장'))
    - 
    (select
        avg(basicpay)
    from tblInsa
    where jikwi in ('대리', '사원'))
    as "평균 급여 차액"
from tblInsa;

select
    avg(case
            when jikwi in ('부장', '과장') then basicpay
         end) 
    - avg(case
            when jikwi in ('대리', '사원') then basicpay
         end) as "평균 급여 차액"   
from tblInsa;
 
--max(),min()
--1. 면적이 가장 넓은 나라의 면적은? tblCountry > 959
select 
    max(area)
from tblCountry;

--2. 급여(급여+수당)가 가장 적은 직원은 총 얼마를 받고 있는가? tblInsa > 988,000
select 
    min(basicpay + sudang)
from tblInsa;


















