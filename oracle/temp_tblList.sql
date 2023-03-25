
-- 영화-출연진
create table tblActor_List (

    movie_seq number not null,      --영화번호(FK)
    actor_seq number not null,      --배우번호(FK)
    
    constraint al_movie_fk foreign key(movie_seq) references tblMovie(movie_seq),
    constraint al_actor_fk foreign key(actor_seq) references tblMovie(actor_seq)
    
);

-- 영화-장르
create table tblGenre_List (

    movie_seq number not null,      --영화번호(FK)
    genre_seq number not null,      --장르번호(FK)
    
    constraint gl_movie_fk foreign key(movie_seq) references tblMovie(movie_seq),
    constraint gl_genre_fk foreign key(genre_seq) references tblGenre(genre_seq)
    
);


-- 영화-감독
create table tblDirector_List (

    movie_seq number not null,      --영화번호(FK)
    director_seq number not null,   --감독번호(FK)
    
    constraint dl_movie_fk foreign key(movie_seq) references tblMovie(movie_seq),
    constraint dl_director_fk foreign key(director_seq) references tblDirector(director_seq)
    
);