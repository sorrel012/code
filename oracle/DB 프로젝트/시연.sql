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





