/*
    
A.03 개설 과정 관리
	- 과정명, 과정 기간(시작 년월일, 끝 년월일), 강의실 정보를 입력
	- 개설 과정 정보 입력, 출력, 수정, 삭제
	- 개설 과정 정보 출력 시 개설 과정명, 개설 과정기간(시작 년월일, 끝 년월일), 강의실명, 개설 과목 등록 여부, 교육생 등록인원을 출력
	- 특정 개설 과정 선택 시 개설 과정에는 등록된 개설 과목 정보(과목명, 과목기간(시작 년월일, 끝년월일), 교재명, 교사명) 및 등록된 교육생 정보(교육생 이름, 주민번호 뒷자리, 등록일, 수료 및 중도 탈락) 조회
	- 특정 개설 과정이 수료한 경우 등록된 교육생 전체에 대해서 수료날짜를 지정(중도탈락자 제외)
	- 강의실 정보 추가(강의실명으로 입력)
    
*/


/*개설 과정 정보 > 과정명, 과정 기간(시작 년월일, 끝 년월일), 강의실 정보, 개설 과목 등록 여부, 교육생 등록인원  */

-- 1. 입력

-- 프로시저
create or replace procedure procCurrInfoI_h (
    pCurriName varchar2,
    pCurriStart date,
    pCurriEnd date
)
is
    vCurriSeq number;
begin
    select max(curriculum_seq) + 1 into vCurriSeq from tblCurriculum;
    insert into tblCurriculum(curriculum_seq, curriculumName, curriculumStart, curriculumEnd)
        values(vCurriSeq, pCurriName, pCurriStart, pCurriEnd);
    insert into tblLecture(lecture_seq, lectureMaxStudent, curriculum_seq, lectureRoomnum)
        values((select max(lecture_seq) from tblLecture) + 1, 30, vCurriSeq, 1);
end procCurrInfoI_h;



--호출
begin
    procCurrInfoI_h('빅데이터기반 AI알고리즘 서비스(추천,트레이딩)개발자 양성과정', '2023-12-04', '2024-4-19');
end;



-- 3. 과정 정보 수정

-- 과정 기간 프로시저
create or replace procedure procCurrPerU_h(
    pcurrStart date,
    pcurrEnd date,
    pcurSeq number
)
is
begin
    update tblCurriculum set curriculumStart = pcurrStart, curriculumEnd = pcurrEnd
        where curriculum_seq = pcurSeq;
end procCurrPerU_h;

-- 강의실 정보 프로시저
create or replace procedure procLecRoomU_h(
    plecRoom number,
    pcurSeq number
)
is
begin
    update tblLecture set lectureRoomnum = plecRoom
        where curriculum_seq = pcurSeq;
end procLecRoomU_h;


--호출
begin
    procCurrPerU_h('2023-12-01', '2024-04-18', 37);
    procLecRoomU_h(3, 37);
end;


-- 4. 개설 과정 삭제

--프로시저
create or replace procedure procCurrInfoD_h(
    pcurSeq number
)
is
begin    
    delete tblLecture
        where curriculum_seq = pcurSeq;
        
    delete tblCurriculum
        where curriculum_seq = pcurSeq;
end procCurrInfoD_h;


--호출
begin
    procCurrInfoD_h(37);
end;


/* 특정 개설 과정이 수료한 경우 등록된 교육생 전체에 대해서 수료날짜를 지정(중도탈락자 제외) */

--프로시저
create or replace procedure procCurrEndDateU_h(
    pcurSeq number
)
is
begin    
    update tblCertificate set certificateDate = (select curriculumEnd from tblCurriculum where curriculum_seq = pcurSeq) 
        where certificateDetail = '졸업' and student_seq between ((pcurSeq - 1) * 30 + 1) and (pcurSeq * 30);
end procCurrEndDateU_h;

--호출
begin
    procCurrEndDateU_h(24);
end;

