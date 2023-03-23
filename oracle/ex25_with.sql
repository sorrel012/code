
/* 

    with절 
    
    with 임시테이블명 as (
        select 
    )

*/

select * from (select name, buseo, jikwi from tblInsa where city = '서울');

with seoul as (select name, buseo, jikwi from tblInsa where city = '서울')
select * from seoul;

select *
    from (select name, age, couple from tblMen where weight < 90) a
        inner join (select name, age from tblWomen where weight > 60) b
            on a.couple = b.name;
            
with a as (select name, age, couple from tblMen where weight < 90),
     b as (select name, age from tblWomen where weight > 60)
select a.*, b.age from a inner join b on a.couple = b.name;


--순위함수 or rownum

-- 급여 5위
select * from ( select  
                    name, buseo, basicpay,
                    rank() over(order by basicpay desc) as rnum
                from tblInsa)
    where rnum = 5;


with insa as (
    select
        name, buseo, basicpay,
        rank() over(order by basicpay desc) as rnum
    from tblInsa
)

select * from insa where rnum = 5;