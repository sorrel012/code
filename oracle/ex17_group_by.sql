
/* group_by */

/*
[WITH <Sub Query>]	> with절
SELECT column_list	> select절
FROM table_name	> from절
[WHERE search_condition]	> where절
[GROUP BY group_by_expression]	> group by절
[HAVING search_condition]	> having절
[ORDER BY order_expression [ASC|DESC]]	> order by절


select 컬럼리스트--4. 컬럼을 선택하고
from 테이블    --1. 테이블로부터
where 조건    --2. 원하는 레코드를
group by 기준 --3. 그룹을 나눠서
order by 정렬;    --5. 정렬한다.
*/


-- tblInsa. 부서별 평균 급여?

select * from tblInsa;

select distinct buseo from tblInsa;

select round(avg(basicpay)) from tblInsa where buseo = '총무부'; -- 171
select round(avg(basicpay)) from tblInsa where buseo = '개발부'; -- 138
select round(avg(basicpay)) from tblInsa where buseo = '영업부'; -- 160
select round(avg(basicpay)) from tblInsa where buseo = '기획부'; -- 185
select round(avg(basicpay)) from tblInsa where buseo = '인사부'; -- 153
select round(avg(basicpay)) from tblInsa where buseo = '자재부'; -- 141
select round(avg(basicpay)) from tblInsa where buseo = '홍보부'; -- 145

-- group by를 사용할 때 컬럼리스트 제약
-- 1. 집계 함수
-- 2. group by 기준이 된 컬럼

select 
    buseo,
    round(avg(basicpay)) as "평균급여"
from tblInsa
    group by buseo;
    
-- 남자 몇명? 여자 몇명? 남녀별 각각 몇명인지?

select 
    gender,
    count(*)
from tblComedian
    group by gender;


-- 대륙별 국가수?
select 
    count(*), continent
from tblCountry
    group by continent;
    
    
select 
    buseo,
    count(*) as "부서별 인원수",
    sum(basicpay) as "부서별 급여 합",
    round(avg(basicpay)) as "부서별 평균 급여",
    max(ibsadate) as "부서별 막내의 입사일",
    min(ibsadate) as "부서별 고참의 입사일"
from tblInsa
    group by buseo;


select 
    gender,
    round(avg(height)) as "남녀별 평균 키",
    round(avg(weight), 1) as "남녀별 평균 몸무게",
    max(height) as "키가 가장 큰 사람",
    min(height) as "키가 가장 작은 사람"
from tblComedian
    group by gender;
    

--직업별 인원수 - 내림차순 정렬
select 
    job,
    count(*)
from tblAddressBook
    group by job
        order by count(*) desc;  --원래는 order by에 집계함수를 쓸 수 없지만, group by에 의해 집계 함수가 컬럼이 되어서 사용 가능


select 
    round(avg(basicpay)) as "평균급여",
    buseo
from tblInsa
    group by buseo;


select 
    round(avg(basicpay)), --평균급여 > 집합값
    buseo,                --부서명 > 그룹 > 집합값
    name                  --직원명 > 개인값
from tblInsa
    group by buseo;

--다중 그룹

select 
    buseo as "부서명",
    jikwi as "직위명",
    count(*) as "인원수"
from tblInsa
    group by buseo, jikwi
        order by buseo, jikwi;

-- 성별 인원수?
select
    count(*),
    decode(substr(ssn, 8, 1), '1', '남자', '2', '여자') as "성별"
    from tblInsa
        group by substr(ssn, 8, 1);


-- 지역별 인원수?

--서울특별시 / 광주광역시 ...

select 
    substr(address, 1, instr(address, ' ') - 1) as "지역",
    count(*)
from tblAddressBook
    group by substr(address, 1, instr(address, ' ') - 1);


--이메일 사이트별 인원수

select
    substr(email, instr(email, '@')+1) as "도메인",
    count(*)
from tblAddressBook
    group by substr(email, instr(email, '@')+1)
        order by count(*) desc;
        
        
-- 급여별 그룹 인원수
-- 100만원 이하
-- 100만원~ 200만원
-- 200만원 이상
select
    basicpay,
    floor(basicpay / 1000000)
from tblInsa;

select
    (floor(basicpay / 1000000) + 1 ) * 100 || '만원 이하' as "급여대",
    count(*) as "인원수"
from tblInsa
    group by floor(basicpay / 1000000)
        order by floor(basicpay / 1000000);

-- 한 일? 안 한 일? 각각 몇 개?

select
    count(*), 
    case 
        when completedate is null then '안 한 일'
        when completedate is not null then '한 일'
    end as "완료 여부"
from tblTodo
    group by case 
        when completedate is null then '안 한 일'
        when completedate is not null then '한 일'
    end;


-- ====================================Q====================================


-- tblZoo. 종류(family)별 평균 다리의 갯수를 가져오시오.
select 
    family as "종류",
    round(avg(leg)) as "평균 다리수"
from tblZoo
    group by family;


-- tblZoo. 사이즈와 종류별로 그룹을 나누고 각 그룹의 갯수를 가져오시오.
select 
    family,
    decode(sizeof,'small','소형','medium','중형','large','대형') as 크기, 
    count(*) as "개수"
from tblZoo
    group by family, sizeof
        order by family asc, sizeof desc;


-- tblAddressBook. 이메일이 스네이크 명명법으로 만들어진 사람들 중에서 여자이며, 20대이며, 키가 150~160cm 사이며, 고향이 서울 또는 인천인 사람들만 가져오시오.

select 
    *
from tblAddressBook
    where instr(email,'_') <> 0 and
            gender = 'f' and
            floor(age / 10) = 2 and
            height like '15_' and
            hometown in ('서울', '인천');    
            
            
            
--=======================순서 정리============================================

-- 서울 사는 직원 > 부서별 인원수?
select 
    count(*), buseo     --4.
from tblInsa            --1.
    where city = '서울' --2.
        group by buseo; --3.
            
            

select  
    count(*), buseo           --4.
from tblInsa                  --1.
    where basicpay >= 2500000 --2. > 인사부, 홍보부 제외됨
        group by buseo;       --3.


/*having*/

select 
    buseo,
    round(avg(basicpay))    --3. 나눠진 그룹별로 집계함수를 각각 구한다.
from tblInsa                --1. 60명의 데이터를 가져온다.
    group by buseo;         --2. 60명을 대상으로 > 부서로 그룹을 나눈다.


select
    buseo,
    round(avg(basicpay))        --4. 나눠진 그룹별로 집계함수를 각각 구한다.
from tblInsa                    --1. 60명의 데이터를 가져온다.
    where basicpay >= 1500000   --2. 60명을 대상으로 > 조건에 맞는 직원만 남긴다.
        group by buseo;         --3. where절을 만족한 직원들을 대상으로 그룹을 나눈다.



select
    buseo,
    round(avg(basicpay))                --4. 필터링된 그룹별 집계함수를 각각 구한다.
from tblInsa                            --1. 60명의 데이터를 가져온다.
    group by buseo                      --2. 60명을 대상으로 > 부서로 그룹을 나눈다.
        having avg(basicpay) >= 1500000;--3. 그룹별 집계함수값을 조건으로 필터링
        
        
        
/*Q*/        

-- tblZoo. 체온이 변온인 종류 중 아가미 호흡과 폐 호흡을 하는 종들의 갯수를 가져오시오.
select 
    count(case
        when breath = 'lung' then 1
    end) as "변온, 폐 호흡",
    count(case
        when breath = 'gill' then 1
    end) as "변온, 아가미 호흡"
from tblzoo
    group by thermo
        having thermo = 'variable';

-- tblAddressBook. 관리자의 실수로 몇몇 사람들의 이메일 주소가 중복되었다. 중복된 이메일 주소만 가져오시오.
select
    email,
    count(email) as count
from tblAddressBook
    group by email
        having count(email) > 1;


-- tblAddressBook. 성씨별 인원수가 100명 이상 되는 성씨들을 가져오시오.
select 
    substr(name,1,1) as "성",
    count(substr(name,1,1)) as count
from tblAddressBook
    group by substr(name,1,1)
        having count(substr(name,1,1)) >= 100;
        

-- tblAddressBook. '건물주'와 '건물주자제분'들의 거주지가 서울과 지방의 비율이 어떻게 되느냐?
select
    job,
    count(*) as "총인원수",
    count(case
            when substr(address, 1, 2) = '서울' then 1
    end) as "서울 거주",
    count(case
            when substr(address, 1, 2) <> '서울' then 1
    end) as "서울 비거주",    
    round(count(case
            when substr(address, 1, 2) = '서울' then 1
    end) / count(*) * 100, 2) as "서울 거주(%)",    
    round(count(case
            when substr(address, 1, 2) <> '서울' then 1
    end) / count(*) * 100, 2) as "서울 비거주(%)"    
from tblAddressBook
    group by job
        having job in ('건물주', '건물주자제분');

        
        
/* group by 함수 */        

-- rollup()


select 
    buseo,
    count(*),
    round(avg(basicpay))
from tblInsa
    group by rollup(buseo);
    
    
select 
    buseo,
    count(*),
    round(avg(basicpay))
from tblInsa
    group by buseo, jikwi;
    
    
select 
    buseo,
    count(*),
    round(avg(basicpay))
from tblInsa
    group by rollup(buseo, jikwi);
    
    
-- cube()   

select 
    buseo,
    count(*),
    round(avg(basicpay))
from tblInsa
    group by cube(buseo, jikwi);
    
    
    
    
    