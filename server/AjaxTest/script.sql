
-- 설문조사
create table tblResearch (
    seq number primary key,             --번호(PK)
    question varchar2(300)  not null,   --질문
    item1 varchar2(300) not null,       --항목1
    item2 varchar2(300) not null,       --항목2
    item3 varchar2(300) not null,       --항목3
    item4 varchar2(300) not null,       --항목4
    cnt1 number default 0 not null,    --선택1
    cnt2 number default 0 not null,    --선택2
    cnt3 number default 0 not null,    --선택3
    cnt4 number default 0 not null     --선택4
);

insert into tblResearch values ( 1, '가장 자신있는 프로그래밍 언어는?'
                                , 'JAVA', 'C#', 'Python', 'Dart'
                                , default, default, default, default);

select * from tblResearch;

--현재 진행중인 상태를 웹페이지에 출력

update tblResearch set
        cnt1 = 7,
        cnt2 = 8,
        cnt3 = 5,
        cnt4 = 10
            where seq = 1;