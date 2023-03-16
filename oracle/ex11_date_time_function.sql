
/* 날짜 시간 함수, date_time_function */

/* sysdate */

select sysdate from dual;


/* 날짜 연산 */

-- 1. 시각 - 시각 = 시간(일)
-- 1-1. month_between : 시각 - 시각 = 시간(월)

select  
    name,
    ibsadate,
    round(sysdate - ibsadate) as "근무일수",
    round(months_between(sysdate, ibsadate)) as "근무월수",
    round(months_between(sysdate, ibsadate) / 12) as "근무년수",
    round((sysdate - ibsadate) * 24) as "근무시수",
    round((sysdate - ibsadate) * 24 * 60) as "근무분수",
    round((sysdate - ibsadate) * 24 * 60 * 60) as "근무초수"
from tblInsa;

select  
    name,
    ibsadate,
    sysdate - ibsadate as "근무일수",
    round(sysdate - ibsadate) as "근무일수 반올림"
from tblInsa;

select
    title,
    adddate,
    completedate,
    round((completedate - adddate) * 24, 1) as "걸린 시간"
from tblTodo
--    where round((completedate - adddate) * 24, 1) <= 1;
    order by round((completedate - adddate) * 24, 1) desc;
     
     
--2. 시각 - 시간(일) = 시각
--3. 시각 - 시간(일) = 시각    

select
    sysdate,
    sysdate + 100 as "100일 후",
    sysdate - 100 as "100일 전",
    sysdate + (3 / 24) as "3시간 후",
    sysdate - (5 / 24) as "5시간 전",
    sysdate + (30 / 60 / 24) as "30분 후"
from dual;
    

select 
    sysdate,
    sysdate + 10, --10일 뒤
    add_months(sysdate, 1), --한달 뒤
    add_months(sysdate, -3), --3개월 전
    add_months(sysdate, 3*12) --3년 뒤
from dual;


--Q--

-- employees

-- 1. 전체 이름(first_name + last_name)이 가장 긴 -> 짧은 사람 순으로 정렬해서 가져오기
--    > 컬럼 리스트 > fullname(first_name + last_name), length(fullname)
select 
    first_name || last_name as fullname,
    length(first_name || last_name) as length
from hr.employees
    order by length(first_name || last_name) desc;
    

-- 2. 전체 이름(first_name + last_name)이 가장 긴 사람은 몇글자? 가장 짧은 사람은 몇글자? 평균 몇글자?
--    > 컬럼 리스트 > 숫자 3개 컬럼
select 
    max(length(first_name || last_name)) as "max",
    min(length(first_name || last_name)) as "min",
    round(avg(length(first_name || last_name)), 2) as "avg"
from hr.employees;


-- 3. last_name이 4자인 사람들의 first_name을 가져오기
--    > 컬럼 리스트 > first_name, last_name
--    > 정렬(first_name, 오름차순)
select 
    first_name,
    last_name
from hr.employees
    where length(last_name) = 4
        order by length(first_name);


-- decode

-- 4. tblInsa. 부장 몇명? 과장 몇명? 대리 몇명? 사원 몇명?
select
    count(decode(jikwi, '부장', '1')) as "부장",
    count(decode(jikwi, '과장', '1')) as "과장",
    count(decode(jikwi, '대리', '1')) as "대리",
    count(decode(jikwi, '사원', '1')) as "사원"
from tblInsa;


-- 5. tblInsa. 간부(부장, 과장) 몇명? 사원(대리, 사원) 몇명?
select
    count(decode(jikwi, '부장', '1'))
    + count(decode(jikwi, '과장', '1')) as "간부",
    count(decode(jikwi, '대리', '1'))
    + count(decode(jikwi, '사원', '1')) as "사원"
from tblInsa;


-- 6. tblInsa. 기획부, 영업부, 총무부, 개발부의 각각 평균 급여?
select distinct
    (select
        avg(basicpay)
    from tblInsa
        where buseo = '기획부')  as "기획부",
     (select
        avg(basicpay)
    from tblInsa
        where buseo = '영업부') as "영업부",
     (select
        avg(basicpay)
    from tblInsa
        where buseo = '총무부') as "총무부",
    (select
        avg(basicpay)
    from tblInsa
        where buseo = '개발부') as "개발부"
from tblInsa;


select
    avg(case
        when buseo = '기획부' then basicpay
    end) as "기획부",
    avg(case
        when buseo = '영업부' then basicpay
    end) as "영업부",
    avg(case
        when buseo = '총무부' then basicpay
    end) as "총무부",
    avg(case
        when buseo = '개발부' then basicpay
    end) as "개발부"    
from tblInsa;


select
    avg(decode(buseo, '기획부', basicpay)) as "기획부",
    avg(decode(buseo, '영업부', basicpay)) as "영업부",
    avg(decode(buseo, '총무부', basicpay)) as "총무부",
    avg(decode(buseo, '개발부', basicpay)) as "개발부"    
from tblInsa;


-- 7. tblInsa. 남자 직원 가장 나이가 많은 사람이 몇년도 태생? 여자 직원 가장 나이가 어린 사람이 몇년도 태생?
select distinct
    (select
        '19' || min(substr(ssn, 1, 2))
    from tblInsa
        where substr(ssn, 8, 1) = '1') as "남자",
      (select
        '19' || max(substr(ssn, 1, 2))
    from tblInsa
        where substr(ssn, 8, 1) = '2') as "여자"        
from tblInsa;    


select 
    '19' || min(case
        when substr(ssn, 8, 1) = '1' then substr(ssn, 1, 2)
    end) as "남자",
    '19' || max(case
        when substr(ssn, 8, 1) = '2' then substr(ssn, 1, 2)
    end) as "여자"
from tblInsa;           


select
    '19' || min(decode(substr(ssn, 8, 1), '1', substr(ssn, 1, 2))) as "남자",
    '19' || max(decode(substr(ssn, 8, 1), '2', substr(ssn, 1, 2))) as "여자"
from tblInsa;       
    