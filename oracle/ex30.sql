
-- 일련번호가 필요한 업무 > 순차적으로 증가하는 숫자(날짜)가 필요한 업무
-- 오라클 전용

select
    level,
    prior name as "상사",
    name as "본인"
from tblSelf
--    start with name = '홍사장'
        connect by super = prior seq;
        
-- ********** 일련번호 만들기        
select
    level
from dual
    connect by level <= 5;


--2023-03-01 ~ 2023-03-31 > date

--1.ANSI-SQL > 계층형 쿼리
--2.PL/SQL
--3.Java

select 
    to_date('2023-03-01', 'yyyy-mm-dd') + level - 1
from dual
    connect by level <= 31;
    
    
-- 근태 상황(출석) > 학교에 직접 출석했을 때만 기록 (결석은 기록x)
create table tblDate (
    seq number primary key,         --번호(PK)
    state varchar2(30) not null,    --정상|지각|조퇴
    regdate date not null           --날짜
);

--insert into tblDate values (1, '정상', '2023-03-01');
insert into tblDate values (2, '정상', '2023-03-02');
insert into tblDate values (3, '정상', '2023-03-03');
--insert into tblDate values (4, '정상', '2023-03-04');
--insert into tblDate values (5, '정상', '2023-03-05');
insert into tblDate values (6, '정상', '2023-03-06');
insert into tblDate values (7, '지각', '2023-03-07');
insert into tblDate values (8, '조퇴', '2023-03-08');
insert into tblDate values (9, '정상', '2023-03-09');
insert into tblDate values (10, '정상', '2023-03-10');
--insert into tblDate values (11, '정상', '2023-03-11');
--insert into tblDate values (12, '정상', '2023-03-12');
insert into tblDate values (13, '정상', '2023-03-13');
insert into tblDate values (14, '지각', '2023-03-14');
--insert into tblDate values (15, '정상', '2023-03-15'); -- 결석
insert into tblDate values (16, '지각', '2023-03-16');
insert into tblDate values (17, '정상', '2023-03-17');
--insert into tblDate values (18, '정상', '2023-03-18');
--insert into tblDate values (19, '정상', '2023-03-19');
insert into tblDate values (20, '정상', '2023-03-20');

select * from tblDate;

--요구사항] 3월 1일 ~ 3월 20일까지 모든 날짜와 근태정보를 가져오시오.
--          ****** 근태 기록이 없는 빠진 날짜도 같이 가져오시오.

-- 조회 기간 > 날짜 생성
select 
    to_date('2023-03-20', 'yyyy-mm-dd') - to_date('2023-03-01', 'yyyy-mm-dd') + 1
from dual;

create or replace view vwDate
as
select
    to_date('2023-03-01', 'yyyy-mm-dd') + (level -1) as regdate
from dual
    connect by level <= (to_date('2023-03-20', 'yyyy-mm-dd') - to_date('2023-03-01', 'yyyy-mm-dd') + 1);

select * from vwDate;   --조회기간
select * from tblDate;  --근태기록

--주말 처리(토,일)
select 
    v.regdate,
    case
        when to_char(v.regdate, 'd') in ('1') then '일요일'
        when to_char(v.regdate, 'd') in ('7') then '토요일'
        else t.state
    end state
from vwDate v
    left outer join tblDate t
        on v.regdate = t.regdate
            order by v.regdate asc;


-- 공휴일 처리
create table tblHoliday (
    seq number primary key,
    regdate date not null,
    name varchar2(30)
);

insert into tblHoliday values (1, '2023-03-01', '삼일절');

select 
    v.regdate,
    case
        when to_char(v.regdate, 'd') in ('1') then '일요일'
        when to_char(v.regdate, 'd') in ('7') then '토요일'
        when t.state is null and h.name is not null then h.name
        when t.state is null and h.name is null then '결석'
        else t.state
    end state
from vwDate v
    left outer join tblDate t
        on v.regdate = t.regdate
            left outer join tblHoliday h
                on v.regdate = h.regdate
                    order by v.regdate asc;



