
/* DDL */

create table tblMemo (

    --컬럼명 자료형(길이) NULL 제약사항
    seq number(3) null,         --메모번호
    name varchar2(30) null,     --작성자
    memo varchar2(1000) null,   --메모
    regdate date null           --작성날짜

);

insert into 테이블(컬럼리스트) values (값리스트);

insert into tblMemo (seq, name, memo, regdate)
            values (1, '홍길동', '메모입니다.', sysdate);
            
insert into tblMemo (seq, name, memo, regdate)
            values (2, '아무개', null, sysdate); --메모 내용 생략(null)

insert into tblMemo (seq, name, memo, regdate)
            values (3, null, null, null); --메모 내용 생략(null)     
            
insert into tblMemo (seq, name, memo, regdate) 
            values (null, null, null, null);   --절대 생성 금지!!!!!!
            
insert into tblMemo (seq, name, memo, regdate)
            values (4, '홍길동', '메모입니다.', '2023-03-15');            

insert into tblMemo (seq, name, memo, regdate)
            values (5, '홍길동', '메모입니다.', to_date('2023-03-15 12:30:50', 'yyyy-mm-dd hh24:mi:ss'));       
            
select * from tblMemo;



drop table tblMemo;

/* 1. 컬럼 수준 */


/* not null*/

--메모 테이블
create table tblMemo (

    --컬럼명 자료형(길이) NULL 제약사항
    seq number(3) not null,         --메모번호
    name varchar2(30) null,         --작성자
    memo varchar2(1000) not null,   --메모
    regdate date null               --작성날짜

);


insert into tblMemo (seq, name, memo, regdate)
            values (1, '홍길동', '메모입니다.', sysdate);

insert into tblMemo (seq, name, memo, regdate)
            values (2, '홍길동', null, sysdate); -- not null 제약조건 때문에 에러!
            
insert into tblMemo (seq, name, memo, regdate)
            values (3, '홍길동', '', sysdate); -- not null 제약조건 때문에 에러!

select * from tblMemo;

drop table tblMemo;


/* primary key */

--메모 테이블
create table tblMemo (

    --컬럼명 자료형(길이) NULL 제약사항
    seq number(3) primary key,       --메모번호(일련번호)
    name varchar2(30) null,         --작성자
    memo varchar2(1000) not null,   --메모
    regdate date null               --작성날짜

);

insert into tblMemo (seq, name, memo, regdate)
            values (1, '홍길동', '메모입니다.', sysdate);

insert into tblMemo (seq, name, memo, regdate)
            values (1, '아무개', '메모입니당.', sysdate); --unique 제약조건 위반

insert into tblMemo (seq, name, memo, regdate)
            values (2, '아무개', '메모입니당.', sysdate);
            
insert into tblMemo (seq, name, memo, regdate)
            values (null, '아무개', '메모입니당.', sysdate); --null 불가
            
select * from tblMemo;


/* unique */

create table tblMemo (

    --컬럼명 자료형(길이) NULL 제약사항
    seq number(3) primary key,      --메모번호(일련번호)
    name varchar2(30) unique,       --작성자 > 한 사람이 딱 한 개의 글 작성 가능
    memo varchar2(1000) not null,   --메모
    regdate date null               --작성날짜

);

insert into tblMemo (seq, name, memo, regdate)
            values (1, '홍길동', '메모입니다.', sysdate);

insert into tblMemo (seq, name, memo, regdate)
            values (2, '홍길동', '메모입니당~~', sysdate);  --unique 제약 위배

insert into tblMemo (seq, name, memo, regdate)
            values (2, '아무개', '메모입니당~~', sysdate);  
            
insert into tblMemo (seq, name, memo, regdate)
            values (3, null, '메모!', sysdate);  

/* check */

drop table tblMemo;

create table tblMemo (

    --컬럼명 자료형(길이) NULL 제약사항
    seq number(3) primary key,                                          --메모번호(일련번호)
    name varchar2(30) check(length(name) > 1),                          --작성자 
    memo varchar2(1000),                                                --메모
    regdate date null,                                                  --작성날짜
    priority number check(priority between 1 and 3),                    --1(중요), 2(보통), 3(사소)
    category varchar2(30) check(category in ('할일', '장보기', '공부'))
    
);
       
insert into tblMemo (seq, name, memo, regdate, priority, category)
            values (1, '홍길동', '메모입니다.', sysdate, 1, '할일'); 

insert into tblMemo (seq, name, memo, regdate, priority, category)
            values (2, '홍', '메모입니다.', sysdate, 10, '공부');  --check 제약조건 위배           
            
select * from tblMemo; 


/* default */

drop table tblMemo;

create table tblMemo (

    --컬럼명 자료형(길이) NULL 제약사항
    seq number(3) primary key,        --메모번호(일련번호)
    name varchar2(30) default '익명', --작성자 > 입력되지 않으면 익명이 입력됨.
    memo varchar2(1000),              --메모
    regdate date default sysdate      --작성날짜
    
);

insert into tblMemo (seq, name, memo, regdate)
            values (1, '홍길동', '메모입니다.', sysdate);

insert into tblMemo (seq, name, memo, regdate)
            values (2, '홍길동', '메모입니다~~', '2023-01-01');
            
insert into tblMemo (seq, name, memo, regdate)
            values (3, null, '메모입니다.', sysdate);

insert into tblMemo (seq, memo, regdate)                -- 1.name 컬럼 생략 > 자동으로 default값 입력됨
            values (4, '메모입니당!!', sysdate);

insert into tblMemo (seq, memo, regdate)
            values (5, '메모 남기는 중', default);       -- 2.값에 직접 default 상수 지정
            
select * from tblMemo;


create table tblMemo (

    --제약사항명 : 테이블명_컬럼명_제약종류
    --컬럼명 자료형(길이) [constraint 제약사항명] 제약 종류
    seq number(3) constraint tblmemo_seq_pk primary key,                                    
    name varchar2(30),
    memo varchar2(1000),
    regdate date
    
);

insert into tblMemo (seq, name, memo, regdate) values (1, '홍길동', '메모', sysdate);

drop table tblMemo;


/* 2. 테이블 수준 */

create table tblMemo (

    seq number(3),                                    
    name varchar2(30),
    memo varchar2(1000),
    regdate date,
    
    --제약사항 선언    
    constraint tblmemo_seq_pk primary key(seq),
    constraint tblmemo_name_uq unique(name),
    constraint tblmemo_memo_ck check(length(memo) >= 10),
    constraint tblmemo_memo_df default sysdate
    
);

/* 3. 외부 수준 */

create table tblMemo(
    seq number(3),
    name varchar2(50),
    memo varchar2(1000),
    regdate date
);

alter table tblMemo
    add constraint tblmemo_deq_pk primary key(seq);

alter table tblMemo
    add constraint tblmemo_name_uq unique(name);
    
alter table tblMemo
    add constraint tblmemo_memo_ck check(length(memo) >= 10);




