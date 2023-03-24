
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

/* movie insert*/

drop sequence seqMovie;
create sequence seqMovie;

insert into tblMovie values (seqMovie.nextVal, '스즈메의 문단속', 122, 14584, '나는 스즈메의 내일이란다', '2023.03.08 개봉', 1 );
insert into tblMovie values (seqMovie.nextVal, '웅남이', 97, 6204, null, '2023.03.22 개봉', 2 );
insert into tblMovie values (seqMovie.nextVal, '소울메이트', 124, 4179, '사람들 얼굴이 왜 다 다른줄 아나? 각자 다 다르게 살라고, 네 맘 가는대로 살아', '2023.03.15 개봉', 3 );
insert into tblMovie values (seqMovie.nextVal, '더퍼스트슬램덩크', 124, 11912, null, '2023.01.04 개봉', 4 );
insert into tblMovie values (seqMovie.nextVal, '샤잠! 신들의분노', 130, 325, '위기의 순간, 날아온 편지를 읽는 장면 전부', '2023.03.15 개봉', 5 );
insert into tblMovie values (seqMovie.nextVal, '파벨만스', 151, 382, '지평선은 아래있어도 좋고, 위에 있어도 좋지만, 가운데 있으면 더럽게 재미없는거야. 알았으면 이제 꺼져', '2023.03.22 개봉', 6 );
insert into tblMovie values (seqMovie.nextVal, '귀멸의 칼날: 상현집결, 그리고 도공 마을로', 110, 1694, null, '2023.03.02 개봉', 7 );
insert into tblMovie values (seqMovie.nextVal, '대외비', 116, 2348, '예수님입니다, 부활 하셨거든', '2023.03.01 개봉', 8 );
insert into tblMovie values (seqMovie.nextVal, '에브리씽 에브리웨어 올 앳 원스+', 122, 14584, '다정', '2023.03.01 개봉', 9 );
insert into tblMovie values (seqMovie.nextVal, '플레인', 107, 337, '더 좋은 계획 있어요?', '2023.03.15 개봉', 10 );
insert into tblMovie values (seqMovie.nextVal, '멍뭉이', 113, 2407, '새로운 가족이 와서 다른 가족을 버리는 건 진짜 가족이 아니예요', '2023.03.01 개봉', 11 );
insert into tblMovie values (seqMovie.nextVal, '아임히어로 더 파이널', 102, 9648, '별을 품을수 있는 더 큰 우주가 되겠습니다', '2023.03.01 개봉', 12 );
insert into tblMovie values (seqMovie.nextVal, '다음 소희', 138, 2817, '힘든 일을 하면 존중받으면 좋을텐데 그런 일이나 한다고 더 무시해', '2023.02.08 개봉', 13 );
insert into tblMovie values (seqMovie.nextVal, '모나리자와 블러드 문', 107, 713, null, '2023.03.22 개봉', 14 );
insert into tblMovie values (seqMovie.nextVal, '던전 앤 드래곤: 도적들의 명예', 134, 314, null, '2023.03.29 개봉 예정', 15 );
insert into tblMovie values (seqMovie.nextVal, '똑똑똑', 100, 275, null, '2023.03.08 개봉', 16 );
insert into tblMovie values (seqMovie.nextVal, '서치 2', 111, 1216, '시리야 119 전화해줘', '2023.02.22 개봉', 17 );
insert into tblMovie values (seqMovie.nextVal, '마루이 비디오 ', 87, 1269, '아버지', '2023.02.22 개봉', 17 );
insert into tblMovie values (seqMovie.nextVal, '이니셰린의 밴시', 114, 324, '손가락 자르기 전까지는 분위기 괜찮았다니까!', '2023.03.15 개봉', 19 );
insert into tblMovie values (seqMovie.nextVal, '보스턴 교살자 ', 112, 48, null, '2023.03.17 개봉', 20 );
insert into tblMovie values (seqMovie.nextVal, '드림', 140, 13996, null, '2023.04.26 개봉 예정', 21 );
insert into tblMovie values (seqMovie.nextVal, '옥수역귀신', 80, 217, null, '2023.04 개봉 예정', 22 );
insert into tblMovie values (seqMovie.nextVal, 'TAR 타르', 158, 535, null, '2023.02.22 개봉', 22 );
insert into tblMovie values (seqMovie.nextVal, '앤트맨과 와스프: 퀀텀매니아', 124, 2871, '내 덕에 8달러나 아꼈지', '2023.02.15 개봉', 24 );
insert into tblMovie values (seqMovie.nextVal, '카운트', 109, 2368, '바통 좀 받아도, 숨차다.', '2023.02.22 개봉', 25 );
insert into tblMovie values (seqMovie.nextVal, '리바운드', 122, 624, null, '2023.04.05 개봉 예정', 26 );
insert into tblMovie values (seqMovie.nextVal, '오토라는 남자', 126, 272, null, '2023.03.29 개봉 예정', 27 );
insert into tblMovie values (seqMovie.nextVal, '포커페이스', 91, 27, null, '2023.03.23 개봉', 28 );
insert into tblMovie values (seqMovie.nextVal, '어쩌면 우린 헤어졌는지 모른다', 103, 621, null, '2023.02.08 개봉', 28 );
insert into tblMovie values (seqMovie.nextVal, '더웨일', 117, 884, '알아야겠어. 내 인생에서 잘한 일이 하나라도 있단 걸!', '2023.03.01 개봉', 30 );
insert into tblMovie values (seqMovie.nextVal, '스파이 코드명 포춘', 100, 128, null, '2023.03.03 개봉', 30 );
insert into tblMovie values (seqMovie.nextVal, '어떤 영웅', 128, 152, null, '2023.03.15 개봉', 32 );
insert into tblMovie values (seqMovie.nextVal, '곰돌이 푸: 피와 꿀', 84, 203, null, '2023.04.06 개봉 예정', 33);
insert into tblMovie values (seqMovie.nextVal, '바빌론', 189, 1454, '영화를 재생시키면, 그 안에서 당신은 몇 번이고 살아나.', '2023.02.01 개봉', 34 );
insert into tblMovie values (seqMovie.nextVal, '아기공룡 둘리 : 얼음별 대모험 4K 리마스터링', 80, 694, '저질? 그래 너 오늘 저질 맛좀 보자.', '2023.05 개봉 예정', 35 );
insert into tblMovie values (seqMovie.nextVal, '거울 속 외딴 성', 116, 275, null, '2023.04.12 개봉 예정', 36 );
insert into tblMovie values (seqMovie.nextVal, '에어', 112, 167, null, '2023.04.05 개봉 예정', 36 );
insert into tblMovie values (seqMovie.nextVal, '물안에서', 61, 39, null, '2023.04.12 개봉 예정', 38 );
insert into tblMovie values (seqMovie.nextVal, '존 윅 4', 169, 742, null, '2023.04.12 개봉 예정', 38 );
insert into tblMovie values (seqMovie.nextVal, '서부 전선 이상 없다', 147, 105, null, '2022.10.28 개봉', 38 );
insert into tblMovie values (seqMovie.nextVal, '그대 어이가리', 120, 472, null, '2023.03.08 개봉', 38 );
insert into tblMovie values (seqMovie.nextVal, '에브리씽 에브리웨어 올 앳 원스', 139, 3298, '다정함을 보여줘', '2022.10.12 개봉', 38 );
insert into tblMovie values (seqMovie.nextVal, '팔로우드', 96, 54, null, '2023.03.22 개봉', 38 );
insert into tblMovie values (seqMovie.nextVal, '날씨의 아이', 112, 11808, '신이 있다면 우리에게 어떠한 것도 주지마시고, 가져가지도 말아주세요.', '2021.09.09 개봉', 38 );
insert into tblMovie values (seqMovie.nextVal, '너의 이름은.', 106, 26375, '(좋아해) 이래선 이름을 알수없잖아', '2021.09.09 개봉', 38 );
insert into tblMovie values (seqMovie.nextVal, '아바타: 물의 길', 192, 23668, '아버지는 지킨다, 그것이 존재 이유다.', '2022.12.14 개봉', 38 );
insert into tblMovie values (seqMovie.nextVal, '교섭', 108, 8843, '자존심이 총알 막아주는거 아닙니다', '2023.01.18 개봉', 47 );
insert into tblMovie values (seqMovie.nextVal, '가디언즈 오브 갤럭시: Volume 3 ', 120, 2710, null, '2023.06 개봉 예정', 47 );
insert into tblMovie values (seqMovie.nextVal, '인디아나 존스: 운명의 다이얼', 122, 474, '고고학자가 되고 싶나? 그럼 도서관을 벗어나','2023.06 개봉 예정', 49 );
insert into tblMovie values (seqMovie.nextVal, '리벤져', 102, 439, '클레멘타인은 수작이네', '2018.12.06 개봉', 49 );

