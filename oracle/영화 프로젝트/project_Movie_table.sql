
-- 국가
create table tblNation(                 

    nation_seq number primary key,      --국가번호(PK)
    nation_name varchar2(30) not null   --국가명
    
);

-- 장르
create table tblGenre (

    genre_seq number primary key,       --장르번호(PK)
    genre_name varchar2(30) not null    --장르명
    
);

-- 등급
create table tblGrade( 

    grade_seq number primary key,       --등급번호(PK)
    grade_name varchar2(30) not null    --등급분류
    
);

-- 배우
create table tblActor(  

    actor_seq number primary key,       --배우번호(PK)
    actor_name varchar2(50) not null,   --배우이름
    actor_birth date not null,          --생년월일
    member_rank number null,            --영화인순위
    nation_seq number not null,         --국가번호(FK)
 
    constraint a_nation_seq_fk foreign key (nation_seq) references tblNation(nation_seq)  
    
); 

--감독
create table tblDirector(                                  

    director_seq number primary key,        --감독번호(PK)
    director_name varchar2(50) not null,    --감독명
    director_birth date null,               --생년월일
    member_rank number null,                --영화인순위
    nation_seq number not null,             --국가번호(FK)
    
    constraint d_nation_seq_fk foreign key (nation_seq) references tblNation(nation_seq)  
    
);

--영화
create table tblMovie (

    movie_seq number primary key,       --영화번호(PK)
    title varchar2(100) not null,       --제목
    runtime number not null,            --상영시간
    likes number not null,              --좋아요수
    line varchar2(300) null,            --명대사
    release_date varchar(30) not null,  --개봉일
    movie_rank number not null,         --영화순위
    grade_seq number not null,          --등급번호(FK)
    
    constraint m_grade_seq_fk foreign key(grade_seq) references tblGrade(grade_seq)
    
);

--평점
create table tblScore (
    
    score_seq number primary key,   --평점번호(PK)
    viwer number null,              --관람객
    reporter number null,           --기자,평론가
    netizen number null,            --네티즌
    movie_seq number not null,      --영화번호(FK)
    
    constraint s_movie_seq_pk foreign key(movie_seq) references tblMovie(movie_seq)
    
);

-- 관객
--관객 테이블
create table tblViewer (
    seq number primary key not null,                                                 --관객번호(PK)            
    movie_seq number not null,                                                       --영화번호(FK)
    gen_10 Integer,                                                                  --10대
    gen_20 Integer,                                                                  --20대
    gen_30 Integer,                                                                  --30대
    gen_40 Integer,                                                                  --40대
    gen_50 Integer,                                                                  --50대(50대 이상부터는 50대에 모두 편입)
    gender_m Integer,                                                                --남자비율
    gender_w Integer,                                                                --여자비율
    viewer_sum Integer,                                                              --누적관객수(숫자)
    
    constraint v_movie_seq_fk foreign key(movie_seq) references tblMovie(movie_seq)       --tblmovie 기본키를 tblviewer의 movie_seq로 참조
);



-- 영화-출연진
create table tblActor_List (

    movie_seq number not null,      --영화번호(FK)
    actor_seq number not null,      --배우번호(FK)
    
    constraint al_movie_fk foreign key(movie_seq) references tblMovie(movie_seq),
    constraint al_actor_fk foreign key(actor_seq) references tblActor(actor_seq)
    
);

-- 영화-장르
create table tblGenre_List (

    movie_seq number not null,      --영화번호(FK)
    genre_seq number not null,      --장르번호(FK)
    
    constraint gl_movie_fk foreign key(movie_seq) references tblMovie(movie_seq),
    constraint gl_genre_fk foreign key(genre_seq) references tblGenre(genre_seq)
    
);

-- 영화-국가
create table tblNation_List (

    movie_seq number not null,      --영화번호(FK)
    nation_seq number not null,     --국가번호(FK)
    
    constraint nl_movie_fk foreign key(movie_seq) references tblMovie(movie_seq),
    constraint nl_nation_fk foreign key(nation_seq) references tblNation(nation_seq)
    
);

-- 영화-감독
create table tblDirector_List (

    movie_seq number not null,      --영화번호(FK)
    director_seq number not null,   --감독번호(FK)
    
    constraint dl_movie_fk foreign key(movie_seq) references tblMovie(movie_seq),
    constraint dl_director_fk foreign key(director_seq) references tblDirector(director_seq)
    
);
