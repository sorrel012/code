
set serveroutput on;

/*

A.02 교사 계정 관리
    - 교사 정보는 교사 이름, 주민번호, 강의 가능 과목 > 입력, 출력, 수정, 삭제
	- 전체 명단의 교사명, 주민번호 뒷자리, 전화번호, 강의 가능 과목을 출력
	- 특정 교사의 배정된 개설 과목명, 개설 과목 기간(시작 년 월일, 끝 년월일), 교재명, 
      강의실, 강의진행여부(날짜별 기준) 조회
	- 교사 정보 입력, 출력, 수정, 삭제
	- 교사의 강의가능과목 추가(과목명으로 입력)
  
*/


/*교사 기본 정보*/

-- 1. 입력

-- 함수
create or replace function fnTeacherInfoI_h (
    pId varchar2,
    pSsn varchar2,
    pTel varchar2,
    pName varchar2
) return varchar2
is    
begin    
    insert into tblMemberInfo(memberInfo_seq, memberInfoid)
        values((select max(memberinfo_seq) from tblMemberinfo) + 1, pId);
        
    insert into tblTeacher(teacher_seq, memberinfo_seq, teacherSsn, teacherTel, teacherName)
        values((select max(teacher_seq) from tblTeacher) + 1, (select max(memberinfo_seq) from tblMemberinfo), pSsn, pTel, pName);
        
    return '입력되었습니다.';
end;

--호출
declare
    result varchar2(200);
begin
    result := fnTeacherInfoI_h('teachermmmmmmm', '850624-2486218', '010-7561-4523', '정소율'); --number 자료형으로 넣어보기 > 오류 확인!
    dbms_output.put_line(result);
exception
    when others then
        dbms_output.put_line('입력에 실패하였습니다.');    
end;


-- 3. 교사 정보 수정

--프로시저

--이름
create or replace procedure procTeacherNameU_h(
    pteacherName varchar2,
    pteacherSeq number
)
is
begin
    update tblTeacher set teacherName = pteacherName
        where teacher_seq = pteacherSeq;    
end procTeacherNameU_h;


--주민번호
create or replace procedure procTeacherSsnU_h(
    pteacherSsn varchar2,
    pteacherSeq number
)
is
begin
    update tblTeacher set teacherSsn = pteacherSsn
        where teacher_seq = pteacherSeq;
end procTeacherSsnU_h;


--연락처
create or replace procedure procTeacherTelU_h(
    pteacherTel varchar2,
    pteacherSeq number
)
is
begin
    update tblTeacher set teacherTel = pteacherTel
        where teacher_seq = pteacherSeq;    
end procTeacherTelU_h;


--호출
begin
    procTeacherNameU_h('정하율', 11);
    procTeacherSsnU_h('850624-2482858', 11);
    procTeacherTelU_h('010-2136-7542', 11);
end;

-- 4. 삭제

--프로시저
create or replace procedure procTeacherD_h(
    pteacherSeq number
)
is
begin
    delete tblTeacher where teacher_seq = pteacherSeq;    
end procTeacherD_h;


--호출    > 선생님 참조되어있을 경우 삭제 불가
declare
    sub_exist EXCEPTION;
    PRAGMA EXCEPTION_INIT(sub_exist,-2292);
begin
    procTeacherD_h(11);
exception    
    when sub_exist then
        dbms_output.put_line('담당하는 과목이 있으므로 삭제할 수 없습니다.');
end;



/*교사 강의 가능 과목 정보*/

-- 1. 입력

-- 프로시저
create or replace procedure procAvailSubI_h(
    pteacherSeq number,
    psubjectName varchar2
)
is
begin
    insert into tblAvailSubject(teacher_seq, subject_seq)
        values(pteacherSeq, (select subject_seq from tblSubject where subjectName = psubjectName));    
end procAvailSubI_h;

    
--호출    
begin
    procAvailSubI_h(5, 'Algorithm');
end;


-- 2. 출력
select 
    t.teacherName as "교사명",
    s.subjectName as "과목명" 
from tblSubject s
    inner join tblAvailSubject av
        on s.subject_seq = av.subject_seq
            inner join tblTeacher t
                on t.teacher_seq = av.teacher_seq
order by teacherName;

    
-- 3. 수정

-- 프로시저
create or replace procedure procAvailSubU_h(
    pteacherSeq number,
    poldSubjectSeq number,
    pnewSubjectSeq number
)
is
begin
    update tblAvailSubject set subject_seq = pnewSubjectSeq 
        where teacher_seq = pteacherSeq and subject_seq = poldSubjectSeq;
end procAvailSubU_h;

    
--호출    
begin
    procAvailSubU_h(6, 12, 18);
end;


-- 4. 삭제

-- 프로시저
create or replace procedure procAvailSubD_h(
    pteacherSeq number,
    psubjectSeq number    
)
is
begin
    delete tblAvailSubject
        where teacher_seq = pteacherSeq and subject_seq = psubjectSeq;
end procAvailSubD_h;

    
--호출    
begin
    procAvailSubD_h(8, 20);
end;


/* 전체 교사 명단 출력*/
--view
select 
    v.이름, 
    v.주민등록번호, 
    v.연락처, 
    s.subjectName as "강의 가능 과목"    
from vwTeacher v
    inner join tblAvailSubject avs
        on v.교사번호 = avs.teacher_seq
            inner join tblSubject s
                on s.subject_seq = avs.subject_seq
order by v.이름;


/* 특정 교사 정보 출력*/ 

-- 프로시저
create or replace procedure procTeacherInfo_h(
    pteacherSeq number
)
is
    vsubjectName tblSubject.subjectName%type;
    vcursubStart tblCurSub.cursubStart%type;
    vcursubEnd tblCurSub.cursubEnd%type;
    vbookName tblBook.bookName%type;
    vlectureRoomnum tblLecture.lectureRoomnum%type;
    vteacherStatus varchar2(50);
    cursor vcursor is select s.subjectName, cs.cursubStart, cs.cursubEnd, bk.bookName, lt.lectureRoomnum 
                        from tblCurSub cs
                            inner join tblSubject s on s.subject_seq = cs.subject_seq
                            inner join tblLecture lt on lt.curriculum_seq = cs.curriculum_seq
                            inner join tblSubBook sb on sb.subject_seq = s.subject_seq
                            inner join tblBook bk on bk.book_seq = sb.book_seq
                            inner join tblAvailSubject avs on avs.subject_seq = s.subject_seq and avs.teacher_seq = cs.teacher_seq    
                        where cs.teacher_seq = pteacherSeq
                            group by s.subjectName, cs.cursubStart, cs.cursubEnd, bk.bookName, lt.lectureRoomNum
                                order by cs.cursubStart;
begin
     open vcursor;
        loop
            fetch vcursor into vsubjectName, vcursubStart, vcursubEnd, vbookName, vlectureRoomnum;
            exit when vcursor%notfound;
            
            if vcursubEnd < sysdate then
                vteacherStatus := '강의종료';
            elsif vcursubStart > sysdate then
                vteacherStatus := '강의예정';
            else
                vteacherStatus := '강의중';
            end if;            
            
            dbms_output.put_line('과정명: ' ||vsubjectName || ' / 과정 시작일: ' || to_char(vcursubStart, 'yyyy-mm-dd') || ' / 과정 종료일: ' ||
                                    to_char(vcursubEnd, 'yyyy-mm-dd') || ' / 교재명: ' || vbookName || ' / 강의실: ' || vlectureRoomnum || '호 / 강의 여부:' || vteacherStatus);
            
        end loop;
    close vcursor; 
    
end procTeacherInfo_h;

--호출

begin
    procTeacherInfo_h(1);
end;