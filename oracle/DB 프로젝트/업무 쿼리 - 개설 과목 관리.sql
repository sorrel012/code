/*
    
A.04 개설 과목 관리
	- 특정 개설 과정 선택 시 개설 과목 정보 출력 및 개설 과목 신규 등록
	- 개설 과목 정보 입력시 과목명, 과목기간(시작 년월일, 끝 년월일), 교재명, 교사명을 입력
	- 개설 과목 출력 시 개설 과정 정보(과정명, 과정기간(시작 년월일, 끝 년월일), 강의실)와 과목명, 과목기간(시작 년월일, 끝 년월일), 교재명, 교사명을 출력
	- 개설 과목 정보에 대한 입력, 출력, 수정, 삭제

*/


/*개설 과목 정보*/


-- 1. 입력



-- 2. 출력
select 
    c.curriculumName as "과정명",
    c.curriculumStart as "과정 시작일",
    c.curriculumEnd as "과정 종료일",
    l.lectureRoomnum||'호' as "강의실",
    as "과목명",
    as "과목 시작일",
    as "과목 종료일",
    as "교재명",
    as "교사명"
from tblCurriculum c
    inner join tblLecture l
        on c.curriculum_seq = l.curriculum_seq
order by c.curriculumStart;


-- 3-1. 수정



-- 4. 삭제
