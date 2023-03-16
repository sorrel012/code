
--string_function


/*upper(), lower(), initcap()*/

select 
    first_name,
    upper(first_name),
    lower(first_name)
from employees;

select
    'abc', initcap('abc'), initcap('aBC')
from dual;


/*substr()*/

select 
    title,
    substr(title, 3),
    substr(title, 3, 4)
from tblTodo;

select
    name,
    substr(name, 1, 1) as "성",
    substr(name, 2) as "이름",
    ssn,
    substr(ssn, 1, 2) as "생년",
    substr(ssn, 3, 2) as "생월",
    substr(ssn, 5, 2) as "생일",
    substr(ssn, 8, 1) as "성별"
from tblInsa;
    
select
count(case
        when substr(name, 1, 1) = '김' then 1
    end) as "김",
    count(case
        when substr(name, 1, 1) = '이' then 1
    end) as "이",
    count(case
        when substr(name, 1, 1) = '박' then 1
    end) as "박",
    count(case
        when substr(name, 1, 1) = '최' then 1
    end) as "최",
    count(case
        when substr(name, 1, 1) = '정' then 1
    end) as "정",
    count(case
        when substr(name, 1, 1) not in ('김', '이', '박', '최', '정') then 1
    end) as "나머지"
from tblInsa;
    

select * from tblInsa
    where substr(ssn, 8, 1) = '2';
    
-- 남자 -> 여자
select 
    name,
    ssn,
    case
        when substr(ssn, 8, 1) = '1' then 1
        when substr(ssn, 8, 1) = '2' then 2
    end as gender
from tblInsa
    order by gender;

select 
    name,
    ssn
from tblInsa
    order by case
        when substr(ssn, 8, 1) = '1' then 1
        when substr(ssn, 8, 1) = '2' then 2
    end;
    
select 
    name,
    ssn
from tblInsa
    order by substr(ssn, 8, 1);
    
    
/*lenght*/    
    
--컬럼 리스트에서 사용
select name, length(name) from tblCountry;

--조건절에서 사용
select name, length(name) from tblCountry where length(name) > 3;
select name, length(name) from tblCountry where length(name) between 4 and 6;

--정렬에서 사용
select name, length(name) from tblCountry order by length(name) desc;


-- 게시판 제목이 길면 잘라서 말줄임표 표시(..)

select 
    title,
    case
        when length(title) >= 8 then substr(title, 1, 8) || '..'
        else title
    end
from tblTodo;


/*instr()*/

select
    '안녕하세요. 홍길동님',
    instr('안녕하세요. 홍길동님', '홍길동') as r1,
    instr('안녕하세요. 홍길동님', '아무개') as r2,
    instr('안녕하세요. 홍길동님. 홍길동님!', '홍길동') as r3,
    instr('안녕하세요. 홍길동님. 홍길동님', '홍길동', 11) as r4,
    instr('안녕하세요. 홍길동님. 홍길동님', '홍길동'
            , instr('안녕하세요. 홍길동님. 홍길동님!', '홍길동') + length('홍길동')) as r5,
    instr('안녕하세요. 홍길동님. 홍길동님!', '홍길동', -1) as r6
from dual;


/* lpad(), rpad() */

select 
    'a',
    lpad('a', 5, 'b'),
    '1',
    lpad('1', 3, '0'),
    lpad('12', 3, '0'),
    lpad('123', 3, '0'),
    lpad('1234', 3, '0'),
    rpad('1', 3, '0')
from dual;


/*trim()*/

select
    '   하나  둘   셋   ',
    trim('   하나  둘   셋   '),
    ltrim('   하나  둘   셋   '),
    rtrim('   하나  둘   셋   ')
from dual;

select 
    replace('홍길동', '홍', '김'),
    replace('홍길동', '이', '김'),
    replace('홍길홍', '홍', '김')
from dual;

select 
    name,
    continent,
    case
        when continent = 'AS' then '아시아'
        when continent = 'EU' then '유럽'
        when continent = 'AG' then '아프리카'
    end as c1,
    replace(replace(replace(continent, 'AS', '아시아'), 'EU', '유럽'), 'AF', '아프리카') as c2
from tblCountry;


/*decode()*/

select
    gender,
    case
        when gender = 'm' then '남자'
        when gender = 'f' then '여자'
    end as g1,
    
    replace(replace(gender, 'm', '남자'), 'f', '여자') as g2,
    
    decode(gender, 'm', '남자','f', '여자') as g3
    
from tblComedian;

--남자와 여자의 수
select
    count(decode(gender, 'm', 1)) as "남자",
    count(decode(gender, 'f', 1)) as "여자"
from tblComedian;










