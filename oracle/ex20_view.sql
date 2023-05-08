
/* view , 뷰*/

create or replace view vwInsa
as
select * from tblInsa;


select * from vwInsa;   --tblInsa처럼 행동


create or replace view vwInsa
as
select name, jikwi, city, buseo from tblInsa where buseo = '영업부';

select * from vwInsa;  --영업부 테이블 역할


--비디오 대여점 사장 > 반복 업무 > 뷰로 만들기
create or replace view 대여체크
as
select 
    m.name as mname,
    v.name as vname,
    to_char(r.rentdate, 'yyyy-mm-dd') as rentdate,
    case
        when r.retdate is not null then '반납 완료'
        else '미반납'
    end as state,
    case
        when r.retdate is null 
            then round(sysdate - (r.rentdate + (select period from tblGenre where seq = v.genre)))
    end as 연체일수,
    case
        when r.retdate is null
            then round((sysdate - (r.rentdate + (select period from tblGenre where seq = v.genre)))
                    * g.price * 0.1)
    end as 연체금 -- 대여가격(10%) x 연체일
from tblRent r
    inner join tblVideo v
        on v.seq = r.video
            inner join tblMember m
                on m.seq = r.member
                    inner join tblGenre g
                        on g.seq = v.genre
order by state asc;

select * from 대여체크;

                
create or replace view vwComedian
as
select * from tblComedian;

select * from tblComedian;  --원본 테이블
select * from vwComedian;   --복사 테이블

update tblComedian set
    weight = 70 where first = '재석';
    
select * from vwComedian; --재사용 목적
select * from (select * from tblComedian); --from 서브쿼리 == 인라인 뷰 > 일회용



select * from tblInsa; --전직원 + 모든 정보

--신입사원(hr) > 영업부 > 업무 > 영업부 직원들에게 일괄 문자 메시지 전송
select * from tblInsa; -- 신입사원에게 tblInsa 접근할 권한 > tblInsa 접근 제한

create or replace view 연락처
as
select name, tel from tblInsa where buseo = '영업부';

select * from 연락처; -- 신입사원에게 연락처 객체에 대한 접근 권한만 부여


create or replace view vwTodo
as
select * from tblTodo;

select * from vwTodo;
insert into vwTodo values(21, '오라클 복습하기', sysdate, null);
update vwTodo set title = '오라클 정리하기' where seq = 21;
delete from vwTodo where seq = 21;

commit;

select * from 대여체크; --복합뷰 > 2개 이상의 테이블을 사용해서 select




























