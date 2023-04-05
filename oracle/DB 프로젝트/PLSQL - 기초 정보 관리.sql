/*

A.01 기초 정보 관리
	- 과정명, 과목명, 강의실명(정원 포함), 교재명(출판사명 포함) 입력, 출력, 수정, 삭제

*/


/* 과정명 관리 */

--1.입력

--프로시저
create or replace procedure procCurrNameI_h (
   pcurriculumName varchar2
)
is
begin    
    insert into tblCurriculum(curriculum_seq, curriculumName) 
        values ((select max(curriculum_seq) from tblCurriculum) + 1,  pcurriculumName);
end procCurrNameI_h;

-- 호출
begin
    procCurrNameI_h('(게임콘텐츠제작) 유니티 UNIY 게임프로그래밍 실무과정');
end;
  
    
--3. 수정

--프로시저
create or replace procedure procCurrNameU_h (
    pcurriculumName varchar2,
    pcurriculumSeq number
)
is
begin
    update tblCurriculum set curriculumName = pcurriculumName
        where curriculum_seq = pcurriculumSeq;
end procCurrNameU_h;


--호출
begin
    procCurrNameU_h('(게임콘텐츠제작) 유니티 UNIY 게임프로그래밍 실무과정', 37);
end;


--4. 삭제

--프로시저
create or replace procedure procCurrNameD_h (
    pcurriculumSeq number
)
is
begin
    delete from tblCurriculum 
        where curriculum_seq = pcurriculumSeq;
end procCurrNameD_h;
   
   
--호출    
begin
    procCurrNameD_h(37);
end;
    
    

/* 과목명 관리 */

--1.입력

--프로시저
create or replace procedure procSubNameI_h (
    psubjectName varchar2
)
is
begin
    insert into tblSubject(subject_seq, subjectName) 
        values ((select max(subject_seq) from tblSubject) + 1, psubjectName);
end procSubNameI_h;
   
   
--호출    
begin
    procSubNameI_h('엘라스틱 서치');
end;

    
--3. 수정
    
-- 프로시저
create or replace procedure procSubNameU_h (
    psubjectName varchar2,
    psubjectSeq number
)
is
begin
    update tblSubject set subjectName = psubjectName
        where subject_seq = psubjectSeq;
end procSubNameU_h;
   
   
--호출    
begin
    procSubNameU_h('Elastic Search', 30);
end;


--4. 삭제

-- 프로시저
create or replace procedure procSubNameD_h (
    psubjectSeq number
)
is
begin
    delete from tblSubject 
        where subject_seq = psubjectSeq;
end procSubNameD_h;
   
   
--호출    
begin
    procSubNameD_h(30);
end;



/* 교재명 관리 */

--1.입력

--프로시저
create or replace procedure procBookI_h (
    pbookName varchar2,
    pbookPrice number,
    pbookPublisher varchar2,
    pbookAuthor varchar2
)
is
begin
    insert into tblBook(book_seq, bookName, bookPrice, bookPublisher, bookAuthor)
        values((select max(book_seq) from tblBook) + 1, pbookName, pbookPrice, pbookPublisher, pbookAuthor);
end procBookI_h;
   

--호출
begin
    procBookI_h('모두의 파이썬', 12000, '길벗(주)', '이승천');
end;


--2. 출력
select 
    bookName as 제목,
    bookPrice as 가격,
    bookPublisher as 출판사,
    bookAuthor as 저자
from tblBook;
    
    
--3. 교재 정보 수정

--교재명 프로시저
create or replace procedure procBookNameU_h (
    pbookName varchar2,
    pbookSeq number
)
is
begin
    update tblBook set bookName = pbookName
        where book_seq = pbookSeq;
end procBookNameU_h;
   
   
--교재 가격 프로시저
create or replace procedure procBookPriceU_h (
    pbookPrice number,
    pbookSeq number
)
is
begin
    update tblBook set bookPrice = pbookPrice
        where book_seq = pbookSeq;
end procBookPriceU_h;


-- 교재 출판사
create or replace procedure procBookPublisherU_h (
    pbookPublisher varchar2,
    pbookSeq number
)
is
begin
    update tblBook set bookPublisher = pbookPublisher
        where book_seq = pbookSeq;
end procBookPublisherU_h;


--교재명 저자
create or replace procedure procBookAuthorU_h (
    pbookAuthor varchar2,
    pbookSeq number
)
is
begin    
    update tblBook set bookAuthor = pbookAuthor
        where book_seq = pbookSeq;
end procBookAuthorU_h;


--호출
begin
    procBookNameU_h('모두의 파이썬 개정2판',26);
    procBookPriceU_h(10800,26);
    procBookPublisherU_h('길벗',26);
    procBookAuthorU_h('이승찬',26);
end;


--4. 삭제
    
--프로시저
create or replace procedure procBookD_h (
    pbookSeq number
)
is
begin    
    delete from tblBook 
        where book_seq = pbookSeq;
end procBookD_h;


--호출
begin
    procBookD_h(26);
end;   
