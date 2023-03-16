
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


    
    
    
    
    