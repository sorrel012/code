
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
    decode(sizeof,'small','소형','medium','중형','large','대형') as 분류, 
    count(*) as "개수" -- 추가 공부하기
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

