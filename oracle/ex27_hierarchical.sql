
/* 

    계층형 쿼리, Hierarchical Query 


    컴퓨터
        - 본체
            - 메인보드
            - 그래픽카드
            - CPU
            - 메모리
        - 모니터
            -모니터암
            -보호필름

*/

create table tblComputer (
    seq number primary key,                         --식별자(PK)
    name varchar2(50) not null,                     --부품명
    qty number not null,                            --수량
    pseq number null references tblComputer(seq)    --부모부품(FK)
);

insert into tblComputer values(1, '컴퓨터', 1, null);

insert into tblComputer values(2, '본체', 1, 1);

insert into tblComputer values(3, '메인보드', 1, 2);
insert into tblComputer values(4, '그래픽카드', 1, 2);
insert into tblComputer values(5, 'CPU', 1, 2);
insert into tblComputer values(6, '메모리', 2, 2);

insert into tblComputer values(7, '모니터', 1, 1);

insert into tblComputer values(8, '모니터암', 1, 7);
insert into tblComputer values(9, '보호필름', 1, 7);



-- Case 2.
create table tblCategoryBig (
    seq number primary key,                 --식별자(PK)
    name varchar2(100) not null             --카테고리명
);

create table tblCategoryMedium (
    seq number primary key,                             --식별자(PK)
    name varchar2(100) not null,                        --카테고리명
    pseq number not null references tblCategoryBig(seq) --부모카테고리(FK)
);

create table tblCategorySmall (
    seq number primary key,                                 --식별자(PK)
    name varchar2(100) not null,                            --카테고리명
    pseq number not null references tblCategoryMedium(seq)  --부모카테고리(FK)
);


insert into tblCategoryBig values (1, '카테고리');

insert into tblCategoryMedium values (1, '컴퓨터용품', 1);
insert into tblCategoryMedium values (2, '운동용품', 1);
insert into tblCategoryMedium values (3, '먹거리', 1);

insert into tblCategorySmall values (1, '하드웨어', 1);
insert into tblCategorySmall values (2, '소프트웨어', 1);
insert into tblCategorySmall values (3, '소모품', 1);

insert into tblCategorySmall values (4, '테니스', 2);
insert into tblCategorySmall values (5, '골프', 2);
insert into tblCategorySmall values (6, '달리기', 2);

insert into tblCategorySmall values (7, '밀키트', 3);
insert into tblCategorySmall values (8, '베이커리', 3);
insert into tblCategorySmall values (9, '도시락', 3);



-- tblComputer

-- 1. 조인
select
    c1.name as "부품명",
    c2.name as "부모부품명"
from tblComputer c1 --자식부품
    inner join tblComputer c2 --부모부품
        on c2.seq = c1.pseq;


-- 2. 계층형 쿼리

/*
    구문
    - start with절 + connect by절
    
    계층형 쿼리 의사 컬럼
    a. prior : 자기와 연관된 부모 레코드 참고
    b. level : 세대수(depth)

*/

select 
    seq,
    lpad(' ', (level-1) * 5) || name, -- 보기 편하게 .. 실제로 이런 작업을 하진  x
    prior name, --부모의  name
    level   --depth
from tblComputer
--    start with seq = 1 -- 결과셋의 루트 지정
--    start with seq = 7
--    start with seq = (select seq from tblCommputer where name = '본체')
    start with pseq is null
        connect by prior seq = pseq; --현재 레코드와 부모 레코드를 연결하는 조건(조인-on 역할)

select * from tblSelf;

select 
    lpad(' ', (level-1) * 2) || name as "직원명"
from tblSelf
    start with seq = 1
        connect by super = prior seq;



--보통  where절로 따로따로 봄.
select * from tblCategoryBig;
select * from tblCategoryMedium where pseq = 1;
select * from tblCategorySmall where pseq = 2;

-- 한번에 보고 싶다면 join

select 
    *
from tblCategoryBig b
    inner join tblCategoryMedium m
        on b.seq = m.pseq
            inner join tblCategorySmall s
                on m.seq = s.pseq;

































