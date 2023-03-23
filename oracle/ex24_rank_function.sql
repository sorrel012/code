
/* 순위 함수 */


--급여순으로 가져오시오. +순위


-- rownum
select a.*, rownum from(select 
                            name, buseo, basicpay
                        from tblInsa
                            order by basicpay desc) a;

-- 1. rank() over()
select 
    name, buseo, basicpay,
    rank() over(order by basicpay desc)
from tblInsa;


-- 2. dense_rank() over()
select 
    name, buseo, basicpay,
    dense_rank() over(order by basicpay desc)
from tblInsa;


-- 3. row_number() over()
select 
    name, buseo, basicpay,
    row_number() over(order by basicpay desc)
from tblInsa;



select * from (select 
                    name, buseo, basicpay,
                    row_number() over(order by basicpay desc) as rnum
                from tblInsa)
    where rnum = 5;
    
    
select
    name, buseo, basicpay,
    rank() over(order by basicpay desc, sudang asc) as rnum
from tblInsa;
    


--========================================================================

/* 

    그룹별 순위 구하기 
    - 순위 함수 + group by

*/

-- 급여 + 순위
select 
    name, buseo, basicpay,
    dense_rank() over(order by basicpay desc) as rnum
from tblInsa;


-- 부서별 급여 순위
select
    buseo, name, basicpay,
    dense_rank() over(partition by buseo order by basicpay desc) as rnum
from tblInsa;
    

select
    buseo, name, basicpay,
    rank() over(partition by buseo order by basicpay desc) as rnum
from tblInsa;


select
    buseo, name, basicpay,
    row_number() over(partition by buseo order by basicpay desc) as rnum
from tblInsa;


























    