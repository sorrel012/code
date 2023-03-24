
create table tblNation(                 --국가

    nation_seq number primary key,      --국가번호
    nation_name varchar2(30) not null   --국가명
    
);


create table tblGenre (

    genre_seq number primary key,    --장르번호
    genre_name varchar2(30) not null  --장르명
    
);


create table tblActor(  --배우

    actor_seq number primary key,  --배우번호
    actor_name varchar2(50) not null,   --배우이름
    actor_birth date not null,  --생년월일
    member_rank number null,   --배우순위
    nation_seq number not null,
 
    constraint a_nation_seq_fk foreign key (nation_seq) references tblNation(nation_seq)  
    
);  --배우제약


create table tblDirector(                                  --감독

    director_seq number primary key,                       --감독번호
    director_name varchar2(50) not null,                   --감독명
    director_birth date not null,                          --생년월일
    member_rank number null,                               --영화인순위
    nation_seq number not null,                          --국가번호
    
    constraint d_nation_seq_fk foreign key (nation_seq) references tblNation(nation_seq)  
    
);


create table tblGrade( --등급

    grade_seq number primary key,  --등급번호
    grade_name varchar2(30) not null --등급분류
    
);


create table tblMovie (

    movie_seq number primary key,
    title varchar2(100) not null,
    runtime number not null,
    likes number not null,
    line varchar2(300) null,
    release_date varchar(30) not null,
    movie_rank number not null,
    grade_seq number not null,
    director_seq number not null,
    genre_seq number not null,
    nation_seq number not null,
    actor_seq number not null,
    
    constraint m_grade_seq_fk foreign key(grade_seq) references tblGrade(grade_seq),
    constraint m_director_seq_fk foreign key(director_seq) references tblDirector(director_seq),
    constraint m_genre_seq_fk foreign key(genre_seq) references tblGenre(genre_seq),
    constraint m_nation_seq_fk foreign key(nation_seq) references tblNation(nation_seq),
    constraint m_actor_seq_fk foreign key(actor_seq) references tblActor(actor_seq)
    
);


create table tblScore (
    
    score_seq number primary key,
    viwer number not null,                              --관람객
    reporter number not null,                           --기자,평론가
    netizen number not null,                            --네티즌
    movie_seq number not null,                          --영화번호
    
    --제약 primary
    constraint s_movie_seq_pk foreign key(movie_seq) references tblMovie(movie_seq)
    
);


--관객 테이블
create table tblViewer (
    
    viewer_seq number primary key,                                                  --영화번호(PK)
    age Integer,                                                                     --나이
    gender varchar2(30),                                                             --성별(한글로 작성)
    viewer_sum Integer,                    
    movie_seq number not null, 
    --누적관객수(숫자)
    constraint v_movie_fk foreign key(movie_seq) references tblMovie(movie_seq)       --tblmovie 기본키를 tblviewer의 movie_seq로 참조
);
