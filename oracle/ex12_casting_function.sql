-- casting_function

/*형변환 함수*/

/*1. to_char(숫자)*/
select
    weight,             --우측정렬(숫자)
    to_char(weight),    --좌측정렬(문자)
    
    length(weight),     --length() 문자열함수 > weight 숫자 > 암시적 형변환
    length(to_char(weight))
from tblComedian;

--형식문자

select  
    weight,
    '@' || to_char(weight) || '@',
    '@' || to_char(weight, '99999') || '@',
    '@' || to_char(weight, '00000') || '@',
    '@' || to_char(-weight, '99999') || '@',
    '@' || to_char(-weight, '00000') || '@'
from tblComedian;

select 
    100,
    to_char(100, '$999'),
    to_char(100, 'L999') --원화
from dual;

select
    1234567.89,
    to_char(1234567.89, '9,999,999.9')
from dual;

select sysdate from dual;
select to_char(sysdate) from dual;
select to_char(sysdate, 'yyyy') from dual;  --년(4자리)*****
select to_char(sysdate, 'yy') from dual;    --년(2자리)
select to_char(sysdate, 'month') from dual; --월(풀네임)
select to_char(sysdate, 'mon') from dual;   --월(약어)
select to_char(sysdate, 'mm') from dual;    --월(2자리)*****
select to_char(sysdate, 'day') from dual;   --요일(풀네임)
select to_char(sysdate, 'dy') from dual;    --요일(약어)
select to_char(sysdate, 'ddd') from dual;   --일(올해의 며칠)
select to_char(sysdate, 'dd') from dual;    --일(이번달의 며칠)*****
select to_char(sysdate, 'd') from dual;     --일(이번주의 며칠) > 요일
select to_char(sysdate, 'hh') from dual;    --시(12시간)
select to_char(sysdate, 'hh24') from dual;  --시(24시간)*****
select to_char(sysdate, 'mi') from dual;    --분*****
select to_char(sysdate, 'ss') from dual;    --초*****
select to_char(sysdate, 'am') from dual;    --오전/오후
select to_char(sysdate, 'pm') from dual;    --오전/오후

--암기!!--
select 
    sysdate,
    to_char(sysdate, 'yyyy-mm-dd'),
    to_char(sysdate, 'hh24:mi:ss'),
    to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss'),
    to_char(sysdate, 'day am hh:mi:ss')
from dual;


--입사
select
    name,
    ibsadate,
    to_char(ibsadate, 'yyyy-mm-dd') as hire_date,
    to_char(ibsadate, 'day') as day,
    case
        when to_char(ibsadate, 'd') in('1', '7') then '휴일 입사'
        else '평일 입사'
    end
from tblInsa;


--날짜 상수
--입사 날짜 > 2000년 이후
select * from tblInsa
    where ibsadate >= '2000-01-01';

