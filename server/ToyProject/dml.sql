
--회원
insert into tblUser (id, pw, name, email, lv, pic, profile)
    values ('hong', '1111', '홍길동', 'hong@gmail.com', '1', default, '자바를 공부하는 학생입니다.');

--관리자
insert into tblUser (id, pw, name, email, lv, pic, profile)
    values ('admin', '1111', '관리자', 'admin@gmail.com', '3', default, '프로젝트 관리자입니다. 언제든지 연락주세요.');
    
select * from tblUser;

select * from tblBoard;


--게시물 보기
select 
    tblBoard.*,
    (select name from tblUser where id = tblBoard.id) as name    
from tblBoard   
    where seq = 4;
    

--댓글
select * from tblComment;


select * from (select a.*, rownum as rnum from vwBoard a) where rnum between 1 and 10;


select nvl(max(thread), 0) as thread from tblBoard;

select * from tblBoard;

delete from tblBoard;

select * from tblPlace; --23

select * from tblHashTag; --1,2

select * from tblPlaceHashTag; --23+1, 23+2

select 
    tblPlace.*, 
    (select name from tblUser where id = tblPlace.id) as uname 
from tblPlace 
    where seq in (select pseq from tblPlaceHashTag
                where hseq = (select seq from tblHashTag where tag = '졸업' and rownum = 1))
    order by seq desc;
    
delete from tblPlaceHashTag;
delete from tblHashTag;
delete from tblPlace;

commit;
