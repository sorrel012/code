/* 교사 계정 관리 */

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
    result := fnTeacherInfoI_h('teachermmmmmmm', '850624-2486218', '010-7561-4523', '정소율');
    dbms_output.put_line(result);
exception
    when others then
        dbms_output.put_line('입력에 실패하였습니다.');    
end;

select * from tblmemberInfo order by memberinfo_seq desc;
select * from tblTeacher order by teacher_seq desc;



/*수료 날짜 지정*/
create or replace trigger trgEndDate
    before
    update of certificateDetail
    on tblCertificate  
    for each row
declare
    vcurrEndDate date;    
begin
    select c.curriculumEnd into vcurrEndDate 
        from tblCurriculum c
            inner join vwSelectInfo v
                on c.curriculum_seq = v.curriculum_seq
        where v.student_seq = :new.student_seq;
      
    if :new.certificateDetail = '졸업' then
        :new.certificateDate := vcurrEndDate;
    end if;
end trgEndDate;



--========================사진만


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
        
        
        

/* 특정 개설 과정 선택 시 개설 과목 정보 출력*/
create or replace procedure procCurSubInfoR_h(
    pCurSeq number
)
is 
    vscurrtName vwCurrInfo.curriculumName%type;
    vsubName vwSubInfo.subjectName%type;
    vcursubStart vwSubInfo.cursubStart%type;
    vcursubEnd vwSubInfo.cursubEnd%type;
    vbookName vwSubInfo.bookName%type;
    vteacherName vwSubInfo.teacherName%type;
    
    cursor vcursor is select distinct vc.curriculumName, vs.subjectName, vs.cursubStart, vs.cursubEnd, vs.bookName, vs.teacherName
                        from vwCurrInfo vc
                            inner join vwSubInfo vs on vc.curriculum_seq = vs.curriculum_seq
                        where vs.curriculum_seq = pCurSeq
                            order by vs.subjectName, vs.cursubStart;
begin
    open vcursor;
    
        loop
        
            fetch vcursor into vscurrtName, vsubName, vcursubStart, vcursubEnd, vbookName, vteacherName;
            exit when vcursor%notfound;
            
            dbms_output.put_line('과정명: ' ||vscurrtName || ' / 과목명: ' || vsubName || ' / 과목 시작일: ' || vcursubStart || ' / 과목 종료일: ' || vcursubEnd || ' / 교재명: ' || vbookName || ' / 교사명: ' || vteacherName);            
        
        end loop;    
        
    close vcursor;
end procCurSubInfoR_h;


--호출
begin
    procCurSubInfoR_h(1);
end;
    

select distinct
    vc.curriculumName as "과정명",
    vs.subjectName as "과목명",
    vs.cursubStart as "과목시작일", 
    vs.cursubEnd as "과목종료일",
    vs.bookName as "교재명", 
    vs.teacherName as "교사명"
from vwCurrInfo vc
    inner join vwSubInfo vs
        on vc.curriculum_seq = vs.curriculum_seq
where vs.curriculum_seq = 1
    order by vs.cursubStart;    