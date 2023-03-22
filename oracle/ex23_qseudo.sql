
/* pseudo */

select  
    name, buseo,    --컬럼(속성)  > output > 객체의 특성에 따라 다른 값을 가진다.(개인 데이터)
    sysdate,        --함수        > output > 모든 레코드가 동일한 값을 가진다.(정적 데이터)
    substr(name, 2),--함수        > input + output > 객체마다 다른 값을 가진다.
    '상수',         --상수        > output > 모든 레코드가 동일한 값을 가진다.(정적 데이터)
    rownum          --의사 컬럼   > output > 객체의 특성에 따라 다른 값을 가진다.(개인 데이터)
from tblInsa;

select name, buseo, rownum from tblInsa;
select name, buseo, rownum from tblInsa where rownum = 1; --위치로 검색
select name, buseo, rownum from tblInsa where rownum <= 5;

select name, buseo, rownum from tblInsa where rownum = 10;
select name, buseo, rownum from tblInsa where rownum > 5;


select 
    name, buseo, rownum --3. 소비
from tblInsa            --1. 이 시점의 데이터를 가지고 rownum이 이미 할당되어 있다.****
    where rownum = 1;   --2. 조건
    
select 
    name, buseo, rownum --3. 소비
from tblInsa            --1. 생성
    where rownum = 3;   --2. 조건 > 조건을 충족하지 않을 경우 index가 shift됨.. > 


select 
    name, buseo, rownum
from tblInsa      
    order by basicpay desc; -- order by 전에 rownum이 매겨지기 때문에 order by를 할 경우 rownum이 뒤죽박죽 섞인다.  
    
select
    name, buseo, basicpay, rownum
from (select 
            name, buseo, basicpay, rownum
        from tblInsa      
            order by basicpay desc)
    where rownum <= 5;


-- 인구수가 가장 많은 나라 1~3등
SELECT
    *
FROM (SELECT * FROM tblcountry WHERE population IS NOT NULL ORDER BY population DESC)
    WHERE ROWNUM <= 3;

--1. 급여 순으로 정렬
SELECT a.*, ROWNUM FROM (SELECT * FROM tblinsa ORDER BY basicpay DESC) a;

SELECT a.*, ROWNUM FROM (SELECT * FROM tblinsa ORDER BY basicpay DESC) a WHERE ROWNUM = 1;
SELECT a.*, ROWNUM FROM (SELECT * FROM tblinsa ORDER BY basicpay DESC) a WHERE ROWNUM <= 5;
SELECT a.*, ROWNUM FROM (SELECT * FROM tblinsa ORDER BY basicpay DESC) a WHERE ROWNUM = 3;

SELECT * FROM(SELECT a.*, ROWNUM AS rnum FROM (SELECT * FROM tblinsa ORDER BY basicpay DESC) a)
    WHERE rnum = 3;
    
SELECT * FROM tblinsa;

-- 5번째 뚱뚱한 사람?
SELECT * FROM tblComedian;

-- 1. 정렬
SELECT * FROM tblcomedian ORDER BY weight DESC;

--2. 서브쿼리 > rownum 별칭
SELECT a.*, ROWNUM AS rnum FROM(SELECT * FROM tblcomedian ORDER BY weight DESC) a;

--3. 서브쿼리 > rownum 고정시키기 위해서
SELECT * FROM (SELECT a.*, ROWNUM AS rnum FROM(SELECT * FROM tblcomedian ORDER BY weight DESC) a)
    WHERE rnum = 5;
    
    
