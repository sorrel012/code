
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
    name varchar2(30) default '익명', --작성자 > 한 사람이 딱 한 개의 글 작성 가능
    memo varchar2(1000),              --메모
    regdate date default sysdate      --작성날짜
    
);

insert into tblMemo (seq, name, memo, regdate)
            values (1, '홍길동', '메모입니다.', sysdate);

insert into tblMemo (seq, name, memo, regdate)
            values (2, '홍길동', '메모입니다~~', '2023-01-01');
            
insert into tblMemo (seq, name, memo, regdate)
            values (3, null, '메모입니다.', sysdate);

insert into tblMemo (seq, memo, regdate)
            values (4, '메모입니당!!', sysdate);

insert into tblMemo (seq, memo, regdate)
            values (5, '메모 남기는 중', default);
            
select * from tblMemo;
