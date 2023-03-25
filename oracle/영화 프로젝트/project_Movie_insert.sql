
/*tblNation*/ --완료
create sequence seqNation start with 1;

insert into tblNation values(seqNation.nextval, '일본');
insert into tblNation values(seqNation.nextval, '한국');
insert into tblNation values(seqNation.nextval, '미국');
insert into tblNation values(seqNation.nextval, '영국');
insert into tblNation values(seqNation.nextval, '아일랜드');
insert into tblNation values(seqNation.nextval, '스웨덴');
insert into tblNation values(seqNation.nextval, '이란');
insert into tblNation values(seqNation.nextval, '프랑스');
insert into tblNation values(seqNation.nextval, '독일');
insert into tblNation values(seqNation.nextval, '인도');
insert into tblNation values(seqNation.nextval, '뉴질랜드');
insert into tblNation values(seqNation.nextval, '캐나다');


/*tblGenre*/


/*tblGrade*/ --완료
insert into tblGrade values (1, '전체관람가');
insert into tblGrade values (2, '12세 이상 관람가');
insert into tblGrade values (3, '15세 이상 관람가');
insert into tblGrade values (4, '청소년 관람불가');
insert into tblGrade values (5, '미정');

/*tblActor*/ --완료
create sequence seqActor start with 1;

insert into tblActor values (seqActor.nextval, '하라 나노카', to_date('2003-08-26', 'yyyy-mm-dd') , 14, 1);
insert into tblActor values (seqActor.nextval, '박성웅', to_date('1997-03-15', 'yyyy-mm-dd') , 17, 2);
insert into tblActor values (seqActor.nextval, '전소니', to_date('1990-02-17', 'yyyy-mm-dd') , 7, 2); 
insert into tblActor values (seqActor.nextval, '키무라 스바루', to_date('1990-06-29', 'yyyy-mm-dd') , 17, 9);
insert into tblActor values (seqActor.nextval, '제커리 레비', to_date('1980-09-29', 'yyyy-mm-dd') , 20, 3);
insert into tblActor values (seqActor.nextval, '가브리엘 라벨', to_date('2002-09-20', 'yyyy-mm-dd') , null, 12);
insert into tblActor values (seqActor.nextval, '하나에 나츠키', to_date('1991-06-26', 'yyyy-mm-dd') , null, 1);
insert into tblActor values (seqActor.nextval, '조진웅', to_date('1977-01-25', 'yyyy-mm-dd') , 32, 2);
insert into tblActor values (seqActor.nextval, '양자경', to_date('1962-08-06', 'yyyy-mm-dd') , 5, 1);
insert into tblActor values (seqActor.nextval, '마이크 콜터', to_date('1976-08-26', 'yyyy-mm-dd') , null, 3);
insert into tblActor values (seqActor.nextval, '유연석', to_date('1985-04-10', 'yyyy-mm-dd') , null, 2);
insert into tblActor values (seqActor.nextval, '임영웅', to_date('1991-06-16', 'yyyy-mm-dd') , null, 2);
insert into tblActor values (seqActor.nextval, '김시은', to_date('1999-01-19', 'yyyy-mm-dd') , null, 2);
insert into tblActor values (seqActor.nextval, '전종서', to_date('1992-03-26', 'yyyy-mm-dd') , 24, 2);
insert into tblActor values (seqActor.nextval, '크리스 파인', to_date('1980-08-26', 'yyyy-mm-dd') , null, 3);
insert into tblActor values (seqActor.nextval, '데이비드 바티스타', to_date('1969-01-18', 'yyyy-mm-dd') , null, 3);
insert into tblActor values (seqActor.nextval, '스톰 레이드', to_date('2003-07-01', 'yyyy-mm-dd') , null, 3);
insert into tblActor values (seqActor.nextval, '서현우', to_date('1989-09-15', 'yyyy-mm-dd') , null, 2);
insert into tblActor values (seqActor.nextval, '콜린 파렐', to_date('1976-05-31', 'yyyy-mm-dd') , 22, 5);
insert into tblActor values (seqActor.nextval, '키이라 나이틀리', to_date('1985-03-26', 'yyyy-mm-dd') , null, 4);
insert into tblActor values (seqActor.nextval, '박서준', to_date('1989-02-12', 'yyyy-mm-dd') , null, 2);
insert into tblActor values (seqActor.nextval, '김보라', to_date('1995-09-28', 'yyyy-mm-dd') , null, 2);
insert into tblActor values (seqActor.nextval, '케이트 블란쳇', to_date('1969-05-14', 'yyyy-mm-dd') , 36, 11);
insert into tblActor values (seqActor.nextval, '조나단 메이저스', to_date('1989-09-07', 'yyyy-mm-dd') , null, 3);
insert into tblActor values (seqActor.nextval, '진선규', to_date('1977-09-13', 'yyyy-mm-dd') , null, 2);
insert into tblActor values (seqActor.nextval, '안재홍', to_date('1986-03-31', 'yyyy-mm-dd') , null, 2);
insert into tblActor values (seqActor.nextval, '톰 행크스', to_date('1956-07-09', 'yyyy-mm-dd') , 26, 3);
insert into tblActor values (seqActor.nextval, '러셀 크로우', to_date('1964-04-07', 'yyyy-mm-dd') , 22, 11);
insert into tblActor values (seqActor.nextval, '이동휘', to_date('1985-07-2', 'yyyy-mm-dd') , null, 2);
insert into tblActor values (seqActor.nextval, '브렌든 프레이저', to_date('1968-12-03', 'yyyy-mm-dd') , 14, 3);
insert into tblActor values (seqActor.nextval, '제이슨 스타뎀', to_date('1967-07-26', 'yyyy-mm-dd') , null, 4);
insert into tblActor values (seqActor.nextval, '아미르 자디디', to_date('1984-06-20', 'yyyy-mm-dd') , null, 7);
insert into tblActor values (seqActor.nextval, '크레이그 데이빗 다우젯', to_date('1988-05-22', 'yyyy-mm-dd') , null, 4);
insert into tblActor values (seqActor.nextval, '진 스미트', to_date('1951-09-13', 'yyyy-mm-dd') , null, 3);
insert into tblActor values (seqActor.nextval, '이인성', to_date('1950-07-27', 'yyyy-mm-dd') , null, 2);
insert into tblActor values (seqActor.nextval, '토우마 아미', to_date('2006-11-02', 'yyyy-mm-dd') , null, 1);
insert into tblActor values (seqActor.nextval, '맷 데이먼', to_date('1970-10-08', 'yyyy-mm-dd') , null, 3);
insert into tblActor values (seqActor.nextval, '신석호', to_date('1989-06-15', 'yyyy-mm-dd') , null, 2);
insert into tblActor values (seqActor.nextval, '키아누 리브스', to_date('1964-09-02', 'yyyy-mm-dd') , null, 7);
insert into tblActor values (seqActor.nextval, '알브레히트 슈흐', to_date('1985-08-21', 'yyyy-mm-dd') , null, 9);
insert into tblActor values (seqActor.nextval, '선동혁', to_date('1955-10-17', 'yyyy-mm-dd') , null, 2);
insert into tblActor values (seqActor.nextval, '스테파니 수', to_date('1990-1-25', 'yyyy-mm-dd') , 43, 3);
insert into tblActor values (seqActor.nextval, '매튜 솔로몬', to_date('1980-03-13', 'yyyy-mm-dd') , null, 3);
insert into tblActor values (seqActor.nextval, '심규혁', to_date('1970-01-19', 'yyyy-mm-dd') , null, 2);
insert into tblActor values (seqActor.nextval, '카미키 류노스케', to_date('1993-05-19', 'yyyy-mm-dd') , null, 1);
insert into tblActor values (seqActor.nextval, '조 샐다나', to_date('1978-06-19', 'yyyy-mm-dd') , null, 3);
insert into tblActor values (seqActor.nextval, '현빈', to_date('1981-08-12', 'yyyy-mm-dd') , null, 2);
insert into tblActor values (seqActor.nextval, '크리스 프랫', to_date('1979-06-21', 'yyyy-mm-dd') , null, 3);
insert into tblActor values (seqActor.nextval, '해리슨 포드', to_date('1942-07-13', 'yyyy-mm-dd') , null, 3);
insert into tblActor values (seqActor.nextval, '브루스 칸', to_date('1997-03-15', 'yyyy-mm-dd') , null, 1);

/*tblDirector*/ --완료
create sequence seqDirector start with 1;

insert into tblDirector values(seqDirector.nextval,'신카이 마코토',to_date('1973-02-09', 'yyyy-mm-dd'),1,1);
insert into tblDirector values(seqDirector.nextval,'박성광',to_date('1981-08-15','yyyy-mm-dd'),2,2);
insert into tblDirector values(seqDirector.nextval,'민용근',to_date('1976-08-02','yyyy-mm-dd'),5,2);
insert into tblDirector values(seqDirector.nextval,'이노우에 다케히코',to_date('1967-01-12','yyyy-mm-dd'),null ,1);
insert into tblDirector values(seqDirector.nextval,'데이비드F 샌드버그',to_date('1981-01-21','yyyy-mm-dd'),27 ,6);
insert into tblDirector values(seqDirector.nextval,'스티븐 스필버그',to_date('1946-12-18','yyyy-mm-dd'),3,3);
insert into tblDirector values(seqDirector.nextval,'소토자키 하루오',to_date('1973-12-29','yyyy-mm-dd'),null ,1);
insert into tblDirector values(seqDirector.nextval,'이원태',to_date('1975-06-18','yyyy-mm-dd'),10,2);
insert into tblDirector values(seqDirector.nextval,'다니엘 콴',to_date('1988-02-10','yyyy-mm-dd'),9 ,3);
insert into tblDirector values(seqDirector.nextval,'다니엘 샤이너트',to_date('1987-06-07','yyyy-mm-dd'),null ,3);
insert into tblDirector values(seqDirector.nextval,'장 프랑소와 리셰',to_date('1966-07-02','yyyy-mm-dd'),39 ,8);
insert into tblDirector values(seqDirector.nextval,'김주환',to_date('1981-03-22','yyyy-mm-dd'), 34,2);
insert into tblDirector values(seqDirector.nextval,'오윤동',to_date('1975-11-12','yyyy-mm-dd'), null,2);
insert into tblDirector values(seqDirector.nextval,'정주리',to_date('1980-02-02','yyyy-mm-dd'), 31,2);
insert into tblDirector values(seqDirector.nextval,'애나 릴리 아미푸르',to_date('1976-07-25','yyyy-mm-dd'),18,8);
insert into tblDirector values(seqDirector.nextval,'조나단 골드스타인',to_date('1969-07-02','yyyy-mm-dd'),null ,3);
insert into tblDirector values(seqDirector.nextval,'존 프란시스 데일리',to_date('1985-07-20','yyyy-mm-dd'), null,3);
insert into tblDirector values(seqDirector.nextval,'M 나이트 샤말린',to_date('1970-08-06','yyyy-mm-dd'),8 ,10);
insert into tblDirector values(seqDirector.nextval,'니콜라스D.존슨',to_date('1967-12-16','yyyy-mm-dd'), null,3);
insert into tblDirector values(seqDirector.nextval,'윌 메릭',to_date('1993-04-09','yyyy-mm-dd'), null,4);
insert into tblDirector values(seqDirector.nextval,'윤준형',to_date('1974-01-26','yyyy-mm-dd'),42 ,2);
insert into tblDirector values(seqDirector.nextval,'마틴 맥도나',to_date('1970-03-26','yyyy-mm-dd'),4 ,4);
insert into tblDirector values(seqDirector.nextval,'맷 러스킨',to_date('1981-03-26','yyyy-mm-dd'),43 ,3);
insert into tblDirector values(seqDirector.nextval,'이병헌',to_date('1980-07-23','yyyy-mm-dd'),11 ,2);
insert into tblDirector values(seqDirector.nextval,'정용기',to_date('1970-05-23','yyyy-mm-dd'), null,2);
insert into tblDirector values(seqDirector.nextval,'토드 필드',to_date('1964-02-24','yyyy-mm-dd'), null,3);
insert into tblDirector values(seqDirector.nextval,'페이튼 리드',to_date('1964-07-03','yyyy-mm-dd'), null,3);
insert into tblDirector values(seqDirector.nextval,'권혁재',to_date('1980-05-13','yyyy-mm-dd'),null ,2);
insert into tblDirector values(seqDirector.nextval,'장항준',to_date('1969-09-17','yyyy-mm-dd'),29 ,2);
insert into tblDirector values(seqDirector.nextval,'마크 포스터',to_date('1969-11-30','yyyy-mm-dd'),35 ,9);
insert into tblDirector values(seqDirector.nextval,'러셀 크로우',to_date('1964-04-07','yyyy-mm-dd'), 22,2);
insert into tblDirector values(seqDirector.nextval,'형슬우',to_date('1987-02-11','yyyy-mm-dd'), null,2);
insert into tblDirector values(seqDirector.nextval,'대런 아로노프스키',to_date('1969-02-12','yyyy-mm-dd'),28 ,3);
insert into tblDirector values(seqDirector.nextval,'가이 리치',to_date('1968-09-10','yyyy-mm-dd'),null ,4);
insert into tblDirector values(seqDirector.nextval,'아쉬가르 파라디',to_date('1972-01-01','yyyy-mm-dd'),36 ,10);
insert into tblDirector values(seqDirector.nextval,'리스 플레이크 워터필드',to_date('1982-10-21','yyyy-mm-dd'),null ,3);
insert into tblDirector values(seqDirector.nextval,'데이미언 셔젤',to_date('1985-01-19','yyyy-mm-dd'), null,3);
insert into tblDirector values(seqDirector.nextval,'김수정',to_date('1950-07-31','yyyy-mm-dd'),null ,2);
insert into tblDirector values(seqDirector.nextval,'임경원',null,null ,2);
insert into tblDirector values(seqDirector.nextval,'하라 케이이치',to_date('1959-07-24','yyyy-mm-dd'), 43,1);
insert into tblDirector values(seqDirector.nextval,'벤 애플렉',to_date('1968-08-15','yyyy-mm-dd'), null,3);
insert into tblDirector values(seqDirector.nextval,'홍상수',to_date('1960-10-25','yyyy-mm-dd'),21 ,2);
insert into tblDirector values(seqDirector.nextval,'채드 스타헬스키',to_date('1968-09-20','yyyy-mm-dd'),null,3);
insert into tblDirector values(seqDirector.nextval,'에드워드 버거',to_date('7068-02-13','yyyy-mm-dd'), null,9);
insert into tblDirector values(seqDirector.nextval,'이창열',to_date('1972-05-15','yyyy-mm-dd'), null,2);
insert into tblDirector values(seqDirector.nextval,'안토인 르',to_date('1961-06-18','yyyy-mm-dd'), null,8);
insert into tblDirector values(seqDirector.nextval,'제임스 카메론',to_date('1954-08-16','yyyy-mm-dd'), null,12);
insert into tblDirector values(seqDirector.nextval,'임순례',to_date('1961-01-01','yyyy-mm-dd'), null,2);
insert into tblDirector values(seqDirector.nextval,'제임스 건',to_date('1970-08-05','yyyy-mm-dd'), null,3);
insert into tblDirector values(seqDirector.nextval,'제임스 맨골드',to_date('1963-12-16','yyyy-mm-dd'),null ,3);
insert into tblDirector values(seqDirector.nextval,'이승원',to_date('1980-09-10','yyyy-mm-dd'), null,2);


/*tblMovie*/ --완료
create sequence seqMovie start with 1;

insert into tblMovie values (seqMovie.nextVal, '스즈메의 문단속', 122, 14584, '나는 스즈메의 내일이란다', '2023.03.08 개봉', 1, 2);
insert into tblMovie values (seqMovie.nextVal, '웅남이', 97, 6204, null, '2023.03.22 개봉', 2, 3);
insert into tblMovie values (seqMovie.nextVal, '소울메이트', 124, 4179, '사람들 얼굴이 왜 다 다른줄 아나? 각자 다 다르게 살라고, 네 맘 가는대로 살아', '2023.03.15 개봉', 3, 2);
insert into tblMovie values (seqMovie.nextVal, '더퍼스트슬램덩크', 124, 11912, null, '2023.01.04 개봉', 4, 2);
insert into tblMovie values (seqMovie.nextVal, '샤잠! 신들의분노', 130, 325, '위기의 순간, 날아온 편지를 읽는 장면 전부', '2023.03.15 개봉', 5, 2);
insert into tblMovie values (seqMovie.nextVal, '파벨만스', 151, 382, '지평선은 아래있어도 좋고, 위에 있어도 좋지만, 가운데 있으면 더럽게 재미없는거야. 알았으면 이제 꺼져', '2023.03.22 개봉', 6, 2);
insert into tblMovie values (seqMovie.nextVal, '귀멸의 칼날: 상현집결, 그리고 도공 마을로', 110, 1694, null, '2023.03.02 개봉', 7, 3);
insert into tblMovie values (seqMovie.nextVal, '대외비', 116, 2348, '예수님입니다, 부활 하셨거든', '2023.03.01 개봉', 8, 3);
insert into tblMovie values (seqMovie.nextVal, '에브리씽 에브리웨어 올 앳 원스+', 122, 14584, '다정', '2023.03.01 개봉', 9, 3);
insert into tblMovie values (seqMovie.nextVal, '플레인', 107, 337, '더 좋은 계획 있어요?', '2023.03.15 개봉', 10, 3);
insert into tblMovie values (seqMovie.nextVal, '멍뭉이', 113, 2407, '새로운 가족이 와서 다른 가족을 버리는 건 진짜 가족이 아니예요', '2023.03.01 개봉', 11, 1);
insert into tblMovie values (seqMovie.nextVal, '아임히어로 더 파이널', 102, 9648, '별을 품을수 있는 더 큰 우주가 되겠습니다', '2023.03.01 개봉', 12, 1);
insert into tblMovie values (seqMovie.nextVal, '다음 소희', 138, 2817, '힘든 일을 하면 존중받으면 좋을텐데 그런 일이나 한다고 더 무시해', '2023.02.08 개봉', 13, 3);
insert into tblMovie values (seqMovie.nextVal, '모나리자와 블러드 문', 107, 713, null, '2023.03.22 개봉', 14, 3);
insert into tblMovie values (seqMovie.nextVal, '던전 앤 드래곤: 도적들의 명예', 134, 314, null, '2023.03.29 개봉 예정', 15, 2);
insert into tblMovie values (seqMovie.nextVal, '똑똑똑', 100, 275, null, '2023.03.08 개봉', 16, 3);
insert into tblMovie values (seqMovie.nextVal, '서치 2', 111, 1216, '시리야 119 전화해줘', '2023.02.22 개봉', 17, 2);
insert into tblMovie values (seqMovie.nextVal, '마루이 비디오 ', 87, 1269, '아버지', '2023.02.22 개봉', 17, 3);
insert into tblMovie values (seqMovie.nextVal, '이니셰린의 밴시', 114, 324, '손가락 자르기 전까지는 분위기 괜찮았다니까!', '2023.03.15 개봉', 19, 3);
insert into tblMovie values (seqMovie.nextVal, '보스턴 교살자 ', 112, 48, null, '2023.03.17 개봉', 20, 3);
insert into tblMovie values (seqMovie.nextVal, '드림', 140, 13996, null, '2023.04.26 개봉 예정', 21, 5);
insert into tblMovie values (seqMovie.nextVal, '옥수역귀신', 80, 217, null, '2023.04 개봉 예정', 22, 5);
insert into tblMovie values (seqMovie.nextVal, 'TAR 타르', 158, 535, null, '2023.02.22 개봉', 22, 3);
insert into tblMovie values (seqMovie.nextVal, '앤트맨과 와스프: 퀀텀매니아', 124, 2871, '내 덕에 8달러나 아꼈지', '2023.02.15 개봉', 24, 2);
insert into tblMovie values (seqMovie.nextVal, '카운트', 109, 2368, '바통 좀 받아도, 숨차다.', '2023.02.22 개봉', 25, 2);
insert into tblMovie values (seqMovie.nextVal, '리바운드', 122, 624, null, '2023.04.05 개봉 예정', 26, 2);
insert into tblMovie values (seqMovie.nextVal, '오토라는 남자', 126, 272, null, '2023.03.29 개봉 예정', 27, 2);
insert into tblMovie values (seqMovie.nextVal, '포커페이스', 91, 27, null, '2023.03.23 개봉', 28, 3);
insert into tblMovie values (seqMovie.nextVal, '어쩌면 우린 헤어졌는지 모른다', 103, 621, null, '2023.02.08 개봉', 28, 2);
insert into tblMovie values (seqMovie.nextVal, '더웨일', 117, 884, '알아야겠어. 내 인생에서 잘한 일이 하나라도 있단걸!', '2023.03.01 개봉', 30, 3);
insert into tblMovie values (seqMovie.nextVal, '스파이 코드명 포춘', 100, 128, null, '2023.상반기 개봉 예정', 30, 5);
insert into tblMovie values (seqMovie.nextVal, '어떤 영웅', 128, 152, null, '2023.03.15 개봉', 32, 2);
insert into tblMovie values (seqMovie.nextVal, '곰돌이 푸: 피와 꿀', 84, 203, null, '2023.04.06 개봉 예정', 33, 5);
insert into tblMovie values (seqMovie.nextVal, '바빌론', 189, 1454, '영화를 재생시키면, 그 안에서 당신은 몇 번이고 살아나.', '2023.02.01 개봉', 34, 4);
insert into tblMovie values (seqMovie.nextVal, '아기공룡 둘리 : 얼음별 대모험 4K 리마스터링', 80, 694, '저질? 그래 너 오늘 저질 맛좀 보자.', '2023.05 개봉 예정', 35, 1);
insert into tblMovie values (seqMovie.nextVal, '거울 속 외딴 성', 116, 275, null, '2023.04.12 개봉 예정', 36, 2);
insert into tblMovie values (seqMovie.nextVal, '에어', 112, 167, null, '2023.04.05 개봉 예정', 36, 3);
insert into tblMovie values (seqMovie.nextVal, '물안에서', 61, 39, null, '2023.04.12 개봉 예정', 38, 2);
insert into tblMovie values (seqMovie.nextVal, '존 윅 4', 169, 742, null, '2023.04.12 개봉 예정', 38, 4);
insert into tblMovie values (seqMovie.nextVal, '서부 전선 이상 없다', 147, 105, null, '2022.10.28 개봉', 38, 4);
insert into tblMovie values (seqMovie.nextVal, '그대 어이가리', 120, 472, null, '2023.03.08 개봉', 38, 2);
insert into tblMovie values (seqMovie.nextVal, '에브리씽 에브리웨어 올 앳 원스', 139, 3298, '다정함을 보여줘', '2022.10.12 개봉', 38, 3);
insert into tblMovie values (seqMovie.nextVal, '팔로우드', 96, 54, null, '2023.03.22 개봉', 38, 3);
insert into tblMovie values (seqMovie.nextVal, '날씨의 아이', 112, 11808, '신이 있다면 우리에게 어떠한 것도 주지마시고, 가져가지도 말아주세요.', '2021.09.09 개봉', 38, 3);
insert into tblMovie values (seqMovie.nextVal, '너의 이름은.', 106, 26375, '(좋아해) 이래선 이름을 알 수 없잖아', '2021.09.09 개봉', 38, 2);
insert into tblMovie values (seqMovie.nextVal, '아바타: 물의 길', 192, 23668, '아버지는 지킨다, 그것이 존재 이유다.', '2022.12.14 개봉', 38, 2);
insert into tblMovie values (seqMovie.nextVal, '교섭', 108, 8843, '자존심이 총알 막아주는거 아닙니다', '2023.01.18 개봉', 47, 2);
insert into tblMovie values (seqMovie.nextVal, '가디언즈 오브 갤럭시: Volume 3 ', 120, 2710, null, '2023.06 개봉 예정', 47, 5);
insert into tblMovie values (seqMovie.nextVal, '인디아나 존스: 운명의 다이얼', 122, 474, '고고학자가 되고 싶나? 그럼 도서관을 벗어나','2023.06 개봉 예정', 49, 5);
insert into tblMovie values (seqMovie.nextVal, '리벤져', 102, 439, '클레멘타인은 수작이네', '2018.12.06 개봉', 49, 3);


/*tbScore*/

/*tblViewer*/

/*tblActor_List*/

/*tblDirector_List*/


/*tblDirector*/

/*tblDirector*/

