/*
    order by
    - [asc|desc]
*/

select * from tblCountry order by name asc;
select * from tblCountry order by population desc; --null 컬럼을 대상으로 정렬
select * from tblCountry where population is not null order by population desc; 

select * from tblInsa order by name asc; --문자열 + 오름차순
select * from tblInsa order by basicpay; --숫자 + 오름차순
select * from tblInsa order by ibsadate; --날짜 + 오름차순

select * from tblInsa order by buseo asc, city asc, name asc; --다중 정렬

select  
    name, buseo, jikwi
from tblInsa
    order by 2, 3, 1;
    
-- 가공된 값 > where 절
-- 가공된 값 > order by 절
select * from tblInsa order by basicpay desc;
select * from tblInsa order by basicpay + sudang desc;


-- 직위순으로 정렬 : 부장 > 과장 > 대리 > 사원
select name, jikwi,
    case
        when jikwi = '부장' then 1
        when jikwi = '과장' then 2
        when jikwi = '대리' then 3
        when jikwi = '사원' then 4
    end jikwiSeq
from tblInsa
    order by jikwiSeq;


select name, jikwi,
    case
        when jikwi = '부장' then 1
        when jikwi = '과장' then 2
        when jikwi = '대리' then 3
        when jikwi = '사원' then 4
    end 
from tblInsa
    order by 3;


select 
    name, jikwi    
from tblInsa
    order by case
        when jikwi = '부장' then 1
        when jikwi = '과장' then 2
        when jikwi = '대리' then 3
        when jikwi = '사원' then 4
    end;
    
-- 주민등록번호 앞자리를 이용하여 성별순으로 정렬 : 남자 > 여자
select * 
    from tblInsa
    order by case 
                when ssn like '%-1%' then '1'
                when ssn like '%-2%' then '2'
            end asc;
