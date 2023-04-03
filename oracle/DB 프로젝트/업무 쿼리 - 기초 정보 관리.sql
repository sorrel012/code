/*

A.01 기초 정보 관리
	- 과정명, 과목명, 강의실명(정원 포함), 교재명(출판사명 포함) 입력, 출력, 수정, 삭제

*/


/* 과정명 관리 */

--1.입력
insert into tblCurriculum(curriculum_seq, curriculumName) 
    values ((select max(curriculum_seq) from tblCurriculum) + 1, '(게임콘텐츠제작) 유니티 UNIY 게임프로그래밍 실무과정');

--2. 출력
select distinct 
    curriculumName as 과정명 
from tblCurriculum;
    
--3. 수정
update tblCurriculum set curriculumName = '(게임콘텐츠제작) 유니티&언리얼 게임프로그래밍 실무과정' 
    where curriculum_seq = 37;

--4. 삭제
delete from tblCurriculum 
    where curriculum_seq = 37;
    
    

/* 과목명 관리 */

--1.입력
insert into tblSubject(subject_seq, subjectName) 
    values ((select max(subject_seq) from tblSubject) + 1, '엘라스틱 서치');

--2. 출력
select 
    subjectName as 과목명 
from tblSubject;
    
--3. 수정
update tblSubject set subjectName = 'Elastic Search'
    where subject_seq = 31;

--4. 삭제
delete from tblSubject 
    where subject_seq = 31;



/* 교재명 관리 */

--1.입력
insert into tblBook(book_seq, bookName, bookPrice, bookPublisher, bookAuthor)
    values((select max(book_seq) from tblBook) + 1, '모두의 파이썬', 12000, '길벗(주)', '이승천');


--2. 출력
select 
    bookName as 제목,
    bookPrice as 가격,
    bookPublisher as 출판사,
    bookAuthor as 저자
from tblBook;
    
    
--3-1. 교재명 수정
update tblBook set bookName = '모두의 파이썬 개정2판'
    where book_seq = 24;
    
--3-1. 교재 가격 수정
update tblBook set bookPrice = 10800
    where book_seq = 24;

--3-1. 출판사 수정
update tblBook set bookPublisher = '길벗'
    where book_seq = 24;

--3-1. 저자 수정
update tblBook set bookAuthor = '이승찬'
    where book_seq = 24;
    

--4. 삭제
delete from tblBook 
    where book_seq = 24;
    
    