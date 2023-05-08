
/*numerical_function*/


/*round()*/
select
    height / weight,
    round(height / weight),
    round(height / weight, 1),
    round(height / weight, 2),
    round(height / weight, 3)
from tblComedian;

-- 평균 급여
select round(avg(basicpay)) from tblInsa;


/*floor(), trunc()*/

select
    height / weight,
    floor(height / weight),
    trunc(height / weight),
    trunc(height / weight, 1),
    trunc(height / weight, 2)
from tblComedian;


/*ceil()*/

select
    height / weight,
    ceil(height / weight)
from tblComedian;


/*mod()*/

select
    10 / 3,
    mod(10, 3) as "나머지",
    floor(10 / 3) as "몫"
from dual;


/*power() sqrt()*/
select 
    power(2, 2),
    power(2, 3),
    power(2, 4),
    sqrt(4),
    sqrt(9),
    sqrt(16)
from dual;
    
    


