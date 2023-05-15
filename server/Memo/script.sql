
create table tblCategory (  
    seq number primary key,         --번호(PK)
    name varchar2(50) not null,     --카테고리명
    icon varchar2(100) not null,    --아이콘
    color varchar2(10) not null     --카테고리명
);
create sequence seqCategory;


create table tblMemo (
    seq number primary key,                             --번호(PK)
    memo varchar2(2000) not null,                       --메모
    regdate date default sysdate not null,              --작성시각
    cseq number not null references tblCategory(seq)    --카테고리
);
create sequence seqMemo;


insert into tblCategory values (seqCategory.nextVal, '할일', 'checklist', '#F8EDEB');
insert into tblCategory values (seqCategory.nextVal, '장보기', 'shopping_cart', '#FAE1DD');
insert into tblCategory values (seqCategory.nextVal, '코딩', 'code', '#ECE4DB');

insert into tblMemo values(seqMemo.nextVal, '메모입니다~', default, 1);