

/*국민취업제도*/
create table tblKua(  
    kua_seq number primary key,
    kuaType number not null,
    kuaAllowance number not null,
    kuaRegdate date not null,
    kuaCenter varchar2(50) not null,    
    student_seq number not null,
    
    constraint ku_student_seq_fk foreign key (student_seq) references tblStudent(student_seq)    
); 


/*필기*/
create table tblWrittenTest(    
    written_seq number primary key,
    writtenScore number not null,
    writtenDate date not null,
    wq_seq number not null,
    
    constraint wt_wq_seq_fk foreign key (wq_seq) references tblWrQuestion(wq_seq)    
);


/*실기*/
create table tblPracticalTest(
    practical_seq number primary key,
    practicalScore number not null,
    practicalDate date not null,
    pq_seq number not null,
    
    constraint pt_pq_seq_fk foreign key (pq_seq) references tblPrQuestion(pq_seq) 
);


/*필기문제*/
create table tblWrQuestion(
    wq_seq number primary key,
    writtenQ varchar2(2505) not null,
    subject_seq number not null,
    
    constraint wr_subject_seq_fk foreign key (subject_seq) references tblSubject(subject_seq)
);


/*실기문제*/
create table tblPrQuestion(
    pq_seq number primary key,
    practicalQ varchar2(2505) not null,
    subject_seq number not null,
    
    constraint pr_subject_seq_fk foreign key (subject_seq) references tblSubject(subject_seq)
);


/*성적*/
create table tblScore(   
    attScore number null,
    student_seq not null,
    practical_seq not null,
    written_seq not null,
    
    constraint sc_student_seq_fk foreign key (student_seq) references tblStudent(student_seq),
    constraint sc_practical_seq_fk foreign key (practical_seq) references tblPracticalTest(practical_seq),
    constraint sc_written_seq_fk foreign key (written_seq) references tblWrittenTest(written_seq)
);


/*과정평가*/
create table tblCurEval(
    curEval_seq number primary key,
    evalScore number null,
    evalDate date null,
    evalContent varchar2(300) null,
    curriculum_seq number not null,
    student_seq number not null,
    
    constraint ce_curriculum_seq_fk foreign key (curriculum_seq) references tblCurriculum(curriculum_seq),
    constraint ce_student_seq_fk foreign key (student_seq) references tblStudent(student_seq)    
);


/*수강등록*/
create table tblCurReg(
    curReg_seq number primary key,
    curRegName varchar2(10) not null,
    student_seq number not null,
    curriculum_seq number not null,
    
    constraint cr_student_seq_fk foreign key (student_seq) references tblStudent(student_seq) ,
    constraint cr_curriculum_seq_fk foreign key (curriculum_seq) references tblCurriculum(curriculum_seq)
);
