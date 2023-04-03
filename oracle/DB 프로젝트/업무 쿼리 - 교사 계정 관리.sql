
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
insert all 
    into tblMemberInfo(memberInfo_seq, memberInfoid)
        values((select max(memberinfo_seq) from tblMemberinfo) + 1, 'teacherlllllll')
    into tblTeacher(teacher_seq, memberinfo_seq, teacherSsn, teacherTel, teacherStatus, teacherName)
        values((select max(teacher_seq) from tblTeacher) + 1, (select max(memberinfo_seq) from tblMemberinfo), '700127-1684532', '010-6542-0456', '강의예정', '박시원')
select * from dual;


-- 2. 출력
select 
    teacherName as 이름, 
    substr(teacherSsn, 8, 7) as 주민등록번호, 
    teacherTel as 연락처,
    teacherStatus as "강의 여부"
from tblTeacher
    order by teacherName;


-- 3-1. 이름 수정
update tblTeacher set teacherName = '박준영' 
    where teacher_seq = 11;

-- 3-2. 주민번호 수정
update tblTeacher set teacherSsn = '700327-1684533'
    where teacher_seq = 11;

-- 3-3 강의 여부 수정
update tblTeacher set teacherStatus = '강의중' 
    where teacher_seq = 11;

-- 3-4 연락처 수정
update tblTeacher set teacherTel = '010-2456-7565' 
    where teacher_seq = 11;


-- 4. 삭제
delete tblTeacher where teacher_seq = 11;



/*교사 강의 가능 과목 정보*/

-- 1. 입력
insert into tblAvailSubject(teacher_seq, subject_seq)
    values(11, (select subject_seq from tblSubject where subjectName = 'Java'));
    

-- 2. 출력
select 
    t.teacherName,
    s.subjectName 
from tblSubject s
    inner join tblAvailSubject av
        on s.subject_seq = av.subject_seq
            inner join tblTeacher t
                on t.teacher_seq = av.teacher_seq
order by teacherName;

    
-- 3. 수정
update tblAvailSubject set subject_seq = 18 where teacher_seq = 6 and subject_seq = 12;


-- 4. 삭제
delete tblAvailSubject
    where subject_Seq = 12;



/* 전체 교사 명단 출력*/
select 
    t.teacherName as 이름, 
    substr(t.teacherSsn, 8, 7) as 주민등록번호, 
    t.teacherTel as 연락처, 
    s.subjectName as "강의 가능 과목"
from tblTeacher t
    inner join tblAvailSubject av
        on t.teacher_seq = av.teacher_seq
            inner join tblSubject s
                on s.subject_seq = av.subject_seq
order by teacherName;



/* 특정 교사 정보 출력*/ 
    
select 
    s.subjectName as 과목명,
    cs.cursubStart as "과목 시작일",
    cs.cursubEnd as "과목 종료일",
    bk.bookName as "교재명",
    lt.lectureRoomnum || '호' as "강의실",
    case
        when cs.cursubEnd < sysdate then '강의종료'
        when cs.cursubStart > sysdate then '강의예정'
        else '강의중'  
    end as "강의 여부"       
from tblCurSub cs
    inner join tblSubject s on s.subject_seq = cs.subject_seq
    inner join tblLecture lt on lt.curriculum_seq = cs.curriculum_seq
    inner join tblSubBook sb on sb.subject_seq = s.subject_seq
    inner join tblBook bk on bk.book_seq = sb.book_seq
    inner join tblAvailSubject avs on avs.subject_seq = s.subject_seq and avs.teacher_seq = cs.teacher_seq    
where cs.teacher_seq = 1 
    group by s.subjectName, cs.cursubStart, cs.cursubEnd, bk.bookName, lt.lectureRoomNum
        order by curSubStart;


-- 프로시저
create or replace procedure procTeacherInfo(
    teacherSeq number
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
                        where cs.teacher_seq = teacherSeq
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
    
end;


begin
    procTeacherInfo(1);
end;