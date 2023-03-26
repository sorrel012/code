
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
insert into tblNation values(seqNation.nextval, '베트남');
insert into tblNation values(seqNation.nextval, '호주');
insert into tblNation values(seqNation.nextval, '스페인');
insert into tblNation values(seqNation.nextval, '멕시코');
insert into tblNation values(seqNation.nextval, '중국');


/*tblGenre*/ --완료
insert into tblGenre values (1, '드라마');
insert into tblGenre values (2, '판타지');
insert into tblGenre values (3, '서부');
insert into tblGenre values (4, '공포');
insert into tblGenre values (5, '모험');
insert into tblGenre values (6, '스릴러');
insert into tblGenre values (7, '느와르');
insert into tblGenre values (8, '컬트');
insert into tblGenre values (9, '다큐멘터리');
insert into tblGenre values (10, '코미디');
insert into tblGenre values (11, '가족');
insert into tblGenre values (12, '미스터리');
insert into tblGenre values (13, '전쟁');
insert into tblGenre values (14, '애니메이션');
insert into tblGenre values (15, '범죄');
insert into tblGenre values (16, '뮤지컬');
insert into tblGenre values (17, 'SF');
insert into tblGenre values (18, '액션');
insert into tblGenre values (19, '무협');
insert into tblGenre values (20, '에로');
insert into tblGenre values (21, '서스펜스');
insert into tblGenre values (22, '서사');
insert into tblGenre values (23, '블랙코미디');
insert into tblGenre values (24, '실험');
insert into tblGenre values (25, '공연실황');
insert into tblGenre values (26, '멜로/로맨스');


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
insert into tblActor values (seqActor.nextval, '데이브 바티스타', to_date('1969-01-18', 'yyyy-mm-dd') , null, 3);
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
insert into tblActor values (seqActor.nextval, '마츠무라 호쿠토', to_date('1995-06-18', 'yyyy-mm-dd') , 3, 1);
insert into tblActor values (seqActor.nextval, '이이경', to_date('1989-01-08', 'yyyy-mm-dd') , null, 2);
insert into tblActor values (seqActor.nextval, '엄혜란', to_date('1976-10-30', 'yyyy-mm-dd') , null, 2);
insert into tblActor values (seqActor.nextval, '김다미', to_date('1995-04-09', 'yyyy-mm-dd') , 11, 2);
insert into tblActor values (seqActor.nextval, '변우석', to_date('1991-10-31', 'yyyy-mm-dd') , 39, 2);
insert into tblActor values (seqActor.nextval, '애셔 앤젤', to_date('2002-09-06', 'yyyy-mm-dd') , null, 3);
insert into tblActor values (seqActor.nextval, '미셸 윌리엄스', to_date('1980-09-09', 'yyyy-mm-dd') , 29, 3);
insert into tblActor values (seqActor.nextval, '폴 다노', to_date('1984-06-19', 'yyyy-mm-dd') , null, 3);
insert into tblActor values (seqActor.nextval, '세스 로건', to_date('1982-04-15', 'yyyy-mm-dd') , null, 12);
insert into tblActor values (seqActor.nextval, '이성민', to_date('1968-12-04', 'yyyy-mm-dd') , null, 2);
insert into tblActor values (seqActor.nextval, '김무열', to_date('1982-05-22', 'yyyy-mm-dd') , null, 2);
insert into tblActor values (seqActor.nextval, '키 호이 콴', to_date('1971-08-20', 'yyyy-mm-dd') , 19, 13);
insert into tblActor values (seqActor.nextval, '제라드 버틀러', to_date('1969-11-13', 'yyyy-mm-dd') , 13, 4);
insert into tblActor values (seqActor.nextval, '차태현', to_date('1976-03-25', 'yyyy-mm-dd') , null, 2);
insert into tblActor values (seqActor.nextval, '배두나', to_date('1979-10-11', 'yyyy-mm-dd') , null, 2);
insert into tblActor values (seqActor.nextval, '케이트 허드슨', to_date('1979-04-19', 'yyyy-mm-dd') , null, 3);
insert into tblActor values (seqActor.nextval, '크레이그 로빈슨', to_date('1971-10-25', 'yyyy-mm-dd') , null, 3);
insert into tblActor values (seqActor.nextval, '미셸 로드리게즈', to_date('1978-07-12', 'yyyy-mm-dd') , null, 3);
insert into tblActor values (seqActor.nextval, '레게장 페이지', to_date('1990-01-24', 'yyyy-mm-dd') , null, 4);
insert into tblActor values (seqActor.nextval, '루퍼트 그린트', to_date('1988-08-24', 'yyyy-mm-dd') , null, 4);
insert into tblActor values (seqActor.nextval, '켄 렁', to_date('1970-01-21', 'yyyy-mm-dd') , null, 3);
insert into tblActor values (seqActor.nextval, '다니엘 헤니', to_date('1979-11-28', 'yyyy-mm-dd') , null, 3);
insert into tblActor values (seqActor.nextval, '조민경', to_date('1989-04-24', 'yyyy-mm-dd') , null, 2);
insert into tblActor values (seqActor.nextval, '브렌단 글리슨', to_date('1955-03-29', 'yyyy-mm-dd') , null, 5);
insert into tblActor values (seqActor.nextval, '캐리 쿤', to_date('1981-01-24', 'yyyy-mm-dd') , null, 3);
insert into tblActor values (seqActor.nextval, '알렉산드로 니볼라', to_date('1972-06-28', 'yyyy-mm-dd') , null, 3);
insert into tblActor values (seqActor.nextval, '아이유', to_date('1993-05-16', 'yyyy-mm-dd') , null, 2);
insert into tblActor values (seqActor.nextval, '김재현', to_date('1994-07-15', 'yyyy-mm-dd') , null, 2);
insert into tblActor values (seqActor.nextval, '신소율', to_date('1985-08-05', 'yyyy-mm-dd') , null, 2);
insert into tblActor values (seqActor.nextval, '폴 러드', to_date('1969-04-06', 'yyyy-mm-dd') , null, 3);
insert into tblActor values (seqActor.nextval, '에반젤린 릴리', to_date('1979-08-03', 'yyyy-mm-dd') , null, 12);
insert into tblActor values (seqActor.nextval, '성유빈', to_date('2000-07-25', 'yyyy-mm-dd') , null, 2);
insert into tblActor values (seqActor.nextval, '오나라', to_date('1974-10-26', 'yyyy-mm-dd') , null, 2);
insert into tblActor values (seqActor.nextval, '이신영', to_date('1998-01-24', 'yyyy-mm-dd') , null, 2);
insert into tblActor values (seqActor.nextval, '정진운', to_date('1991-05-02', 'yyyy-mm-dd') , null, 2);
insert into tblActor values (seqActor.nextval, '리암 헴스워스', to_date('1990-01-13', 'yyyy-mm-dd') , null, 14);
insert into tblActor values (seqActor.nextval, '엘사 파타키', to_date('1976-07-18', 'yyyy-mm-dd') , null, 15);
insert into tblActor values (seqActor.nextval, '정은채', to_date('1986-11-24', 'yyyy-mm-dd') , null, 2);
insert into tblActor values (seqActor.nextval, '강길우', to_date('1986-11-10', 'yyyy-mm-dd') , null, 2);
insert into tblActor values (seqActor.nextval, '세이디 싱크', to_date('2002-04-16', 'yyyy-mm-dd') , null, 3);
insert into tblActor values (seqActor.nextval, '조쉬 하트넷', to_date('1978-07-21', 'yyyy-mm-dd') , null, 3);
insert into tblActor values (seqActor.nextval, '휴 그랜트', to_date('1960-09-09', 'yyyy-mm-dd') , null, 4);
insert into tblActor values (seqActor.nextval, '모센 타나반데', to_date('1975-04-15', 'yyyy-mm-dd') , null, 7);
insert into tblActor values (seqActor.nextval, '페레스테헤 사드르 오라파이', to_date('1962-12-29', 'yyyy-mm-dd') , null, 7);
insert into tblActor values (seqActor.nextval, '브래드 피트', to_date('1963-12-18', 'yyyy-mm-dd') , null, 3);
insert into tblActor values (seqActor.nextval, '마고 로비', to_date('1990-07-02', 'yyyy-mm-dd') , null, 14);
insert into tblActor values (seqActor.nextval, '디에고 칼바', to_date('1992-03-16', 'yyyy-mm-dd') , null, 16);
insert into tblActor values (seqActor.nextval, '박영남', to_date('1946-10-08', 'yyyy-mm-dd') , null, 2);
insert into tblActor values (seqActor.nextval, '아시다 마나', to_date('2004-06-23', 'yyyy-mm-dd') , null, 1);
insert into tblActor values (seqActor.nextval, '키타무라 타쿠미', to_date('1997-11-03', 'yyyy-mm-dd') , null, 1);
insert into tblActor values (seqActor.nextval, '밴 애플렉', to_date('1972-08-15', 'yyyy-mm-dd') , null, 3);
insert into tblActor values (seqActor.nextval, '제이슨 베이트먼', to_date('1969-01-14', 'yyyy-mm-dd') , null, 3);
insert into tblActor values (seqActor.nextval, '신석호', to_date('1989-06-15', 'yyyy-mm-dd') , null, 2);
insert into tblActor values (seqActor.nextval, '김승윤', to_date('1997-09-01', 'yyyy-mm-dd') , null, 2);
insert into tblActor values (seqActor.nextval, '견자단', to_date('1963-07-27', 'yyyy-mm-dd') , null, 17);
insert into tblActor values (seqActor.nextval, '빌 스카스가드', to_date('1990-08-09', 'yyyy-mm-dd') , null, 6);
insert into tblActor values (seqActor.nextval, '에딘 하사노빅', to_date('1992-04-02', 'yyyy-mm-dd') , null, 3);
insert into tblActor values (seqActor.nextval, '다니엘 브륄', to_date('1978-06-16', 'yyyy-mm-dd') , null, 15);
insert into tblActor values (seqActor.nextval, '정아미', to_date('1964-06-05', 'yyyy-mm-dd') , null, 2);
insert into tblActor values (seqActor.nextval, '김유미', to_date('1990-04-26', 'yyyy-mm-dd') , null, 2);
insert into tblActor values (seqActor.nextval, '존 세비지', to_date('1949-08-25', 'yyyy-mm-dd') , null, 3);
insert into tblActor values (seqActor.nextval, '김유림', to_date('1987-05-09', 'yyyy-mm-dd') ,null, 2);
insert into tblActor values (seqActor.nextval, '최한', to_date('1976-08-08', 'yyyy-mm-dd') , null, 2);
insert into tblActor values (seqActor.nextval, '샘 워싱턴', to_date('1976-08-02', 'yyyy-mm-dd') , null, 14);
insert into tblActor values (seqActor.nextval, '시고니 위버', to_date('1949-10-08', 'yyyy-mm-dd') , null, 3);
insert into tblActor values (seqActor.nextval, '황정민', to_date('1970-09-01', 'yyyy-mm-dd') , null, 2);
insert into tblActor values (seqActor.nextval, '강기영', to_date('1983-10-14', 'yyyy-mm-dd') , null, 2);
insert into tblActor values (seqActor.nextval, '피비 월러-브리지', to_date('1985-07-14', 'yyyy-mm-dd') , null, 4);
insert into tblActor values (seqActor.nextval, '안토니오 반데라스', to_date('1960-08-10', 'yyyy-mm-dd') , null, 15);
insert into tblActor values (seqActor.nextval, '박희순', to_date('1970-02-13', 'yyyy-mm-dd') , null, 2);
insert into tblActor values (seqActor.nextval, '윤진서', to_date('1983-08-05', 'yyyy-mm-dd') , null, 2);



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


/*tbScore*/ --완료
create sequence seqScore start with 1;

insert into tblScore values (seqScore.nextval, 8.17, 7.79, 8.30, 1);
insert into tblScore values (seqScore.nextval, 8.28, 3.33, 7.07, 2);
insert into tblScore values (seqScore.nextval, 8.07, 6.17, 8.69, 3);
insert into tblScore values (seqScore.nextval, 9.28, 7.83, 9.44, 4);
insert into tblScore values (seqScore.nextval, 6.89, 4.50, 6.46, 5);
insert into tblScore values (seqScore.nextval, 8.92, 8.67, 8.65, 6);
insert into tblScore values (seqScore.nextval, 6.64, null, 4.97, 7);
insert into tblScore values (seqScore.nextval, 6.16, 5.17, 6.19, 8);
insert into tblScore values (seqScore.nextval, 8.87, null, 7.84, 9);
insert into tblScore values (seqScore.nextval, 7.72, 5.00, 7.91, 10); 
insert into tblScore values (seqScore.nextval, 8.36, 5.00, 8.68, 11);
insert into tblScore values (seqScore.nextval, 9.87, null, 9.82, 12);
insert into tblScore values (seqScore.nextval, 8.75, 6.73, 9.44, 13);
insert into tblScore values (seqScore.nextval, 7.10, 5.20, 7.29, 14);
insert into tblScore values (seqScore.nextval, null, null, null, 15);
insert into tblScore values (seqScore.nextval, 6.02, 5.80, 5.70, 16);
insert into tblScore values (seqScore.nextval, 8.32, 6.50, 8.77, 17); 
insert into tblScore values (seqScore.nextval, 6.19, 5.75, 5.53, 18); 
insert into tblScore values (seqScore.nextval, 8.26, 8.08, 8.28, 19);
insert into tblScore values (seqScore.nextval, null, null, 8.77, 20);
insert into tblScore values (seqScore.nextval, null, null, null, 21);
insert into tblScore values (seqScore.nextval, null, null, null, 22);  
insert into tblScore values (seqScore.nextval, 7.79, 7.55, 7.82, 23);  
insert into tblScore values (seqScore.nextval, 6.88, 5.22, 7.09, 24);
insert into tblScore values (seqScore.nextval, 8.01, 5.50, 8.82, 25);
insert into tblScore values (seqScore.nextval, null, null, null, 26);
insert into tblScore values (seqScore.nextval, null, null, null, 27);
insert into tblScore values (seqScore.nextval, 8.00, 3.50, 6.17, 28);
insert into tblScore values (seqScore.nextval, 7.89, 5.67, 8.28, 29);
insert into tblScore values (seqScore.nextval, 8.27, 6.67, 8.48, 30);
insert into tblScore values (seqScore.nextval, null, null, null, 31);
insert into tblScore values (seqScore.nextval, 8.16, 6.75, 8.08, 32);
insert into tblScore values (seqScore.nextval, null, null, null, 33);
insert into tblScore values (seqScore.nextval, 8.38, 6.86, 7.90, 34);
insert into tblScore values (seqScore.nextval, null, null, 9.35, 35);
insert into tblScore values (seqScore.nextval, null, null, null, 36);  
insert into tblScore values (seqScore.nextval, null, null, null, 37); 
insert into tblScore values (seqScore.nextval, null, null, null, 38);  
insert into tblScore values (seqScore.nextval, null, null, null, 39); 
insert into tblScore values (seqScore.nextval, null, null, 9.03, 40); 
insert into tblScore values (seqScore.nextval, 9.50, 6.00, 9.58, 41);
insert into tblScore values (seqScore.nextval, 8.81, 8.33, 8.16, 42);
insert into tblScore values (seqScore.nextval, 5.50, 1.00, 4.86, 43);
insert into tblScore values (seqScore.nextval, 8.38, 6.57, 7.98, 44);
insert into tblScore values (seqScore.nextval, 9.02, 7.55, 8.81, 45);
insert into tblScore values (seqScore.nextval, 8.82, 7.80, 8.65, 46);
insert into tblScore values (seqScore.nextval, 6.25, 6.43, 5.80, 47); 
insert into tblScore values (seqScore.nextval, null, null, null, 48);  
insert into tblScore values (seqScore.nextval, null, null, null, 49);  
insert into tblScore values (seqScore.nextval, 9.38, null, 4.73, 50);  


/*
    tblViewer
    -null 값 = 집계안됨, 0 = 집계는 됐으나 표본수 부족 
    -나이별 관람추이의 단위는 %
    -성별 관람추이의 단위는 %, 남자,여자 순
    -insert 순서는 2023-03-26 네이버 영화랭킹순
*/
create sequence v_seq;

--null 값 = 집계안됨, 0 = 집계는 됐으나 표본수 부족 
--나이별 관람추이의 단위는 %
--성별 관람추이의 단위는 %, 남자,여자 순
--insert 순서는 2023-03-23 네이버 영화랭킹순
--스즈메의 문단속    
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 1, 6, 36, 34, 18, 6, 64, 36, 2655578);
--웅남이
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 2, 1, 27, 42, 23, 7, 50, 50, 129847);
--소울메이트
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 3, 2, 25, 38, 22, 12, 52, 48, 171429);
--더 퍼스트 슬램덩크    
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 4, 2, 24, 44, 24, 6, 61, 39, 4249401);
--샤잠! 신들의 분노    
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 5, 1, 31, 42, 20, 6, 72, 28, 74928);
--파벨만스   
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 6, 1, 31, 38, 17, 12, 66, 34, 27063);
--귀멸의 칼날: 상현집결, 그리고 도공 마을로    
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 7, 3, 35, 34, 22, 6, 67, 33, 517603);
--대외비    
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 8, 2, 24, 39, 25, 10, 58, 42, 751436);
--에브리씽 에브리웨어 올 앳 원스+    
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 9, 2, 35, 40, 17, 6, 51, 49, 83908);
--플레인
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 10, 0, 20, 39, 31, 10, 60, 40, 34871);
--멍뭉이    
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 11, 4, 26, 37, 21, 12, 40, 60, 168650);
--아임 히어로 더 파이널
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 12, 0, 5, 12, 19, 64, 12, 88, 227956);
--다음소희
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 13, 2, 19, 37, 27, 15, 59, 41, 105338);
--모나리자와 블러드 문   
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 14, 3, 27, 42, 21, 7, 66, 34, 13980);

--던전 앤 드래곤: 도적들의 명예
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 15, null, null, null, null, null, null, null, null);
--똑똑똑
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 16, 1, 26, 40, 26, 6, 61, 39, 30847);
--서치 2
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 17, 1, 34, 38, 20, 8, 51, 49, 412492);
--마루이 비디오
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 18, 2, 30, 40, 22, 6, 66, 34, 165649);
--이니셰린의 밴시
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 19, 2, 18, 46, 24, 10, 66, 34, 16885);    
--보스턴 교살자
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 20, null, null, null, null, null, null, null, null);    
--드림
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 21, null, null, null, null, null, null, null, null);
--옥수역귀신    
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 22, null, null, null, null, null, null, null, null);   
--TAR 타르
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 23, 1, 33, 41, 18, 8, 61, 39, 35236);
--앤트맨과 와스프: 퀀텀매니아
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 24, 2, 27, 42, 21, 7, 61, 39, 1550459);
--카운트
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 25, 1, 24, 41, 24, 10, 49, 51, 391974);    
--리바운드    
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 26, null, null, null, null, null, null, null, null);    
--오토라는 남자
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 27, null, null, null, null, null, null, null, null);
--포커페이스    
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 28, 0, 0, 67, 33, 0, 67, 33, 557);
--어쩌면 우린 헤어졌는지 모른다
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 29, 3, 24, 31, 28, 14, 79, 21, 18238);
--더 웨일
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 30, 0, 34, 38, 19, 9, 62, 38, 48864);
--스파이 코드명 포춘    
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 31, null, null, null, null, null, null, null, null);    
--어떤 영웅    
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 32, 0, 15, 50, 26, 9, 70, 30, 3206);    
--곰돌이 푸: 피와꿀
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 33, null, null, null, null, null, null, null, null);    
--바빌론    
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 34, 1, 36, 39, 16, 8, 60, 40, 209455);
--아기공룡 둘리: 얼음별 대모험 4K 리마스터링
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 35, null, null, null, null, null, null, null, null);
--거울 속 외딴 성
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 36, null, null, null, null, null, null, null, null);
--에어
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 37, null, null, null, null, null, null, null, null);
--물안에서    
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 38, null, null, null, null, null, null, null, null);
--존윅4   
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 39, null, null, null, null, null, null, null, null);
--서부 전선 이상 없다
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 40, null, null, null, null, null, null, null, null);
--그대 어이가리    
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 41, 5, 33, 29, 5, 29, 67, 33, 6906);
--에브리씽 에브리웨어 올 앳 원스
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 42, 3, 47, 34, 12, 4, 53, 47, 364766);
--팔로우드
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 43, 17, 0, 50, 33, 0, 50, 50, 944);
--날씨의 아이
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 44, 14, 54, 19, 9, 4, 71, 29, 742203);
--너의 이름은.    
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 45, 10, 55, 16, 16, 3, 54, 46, 3808383);
--아바타: 물의 길    
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 46, 2, 30, 39, 23, 6, 63, 37, 10799855);
--교섭    
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 47, 2, 26, 38, 22, 11, 55, 45, null);
--가디언즈 오브 갤럭시: Volume 3    
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 48, null, null, null, null, null, null, null, null);
--인디아나 존스: 운명의 다이얼
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 49, null, null, null, null, null, null, null, null);
--리벤져
insert into tblviewer (seq, movie_seq, gen_10, gen_20, gen_30, gen_40, gen_50, gender_m, gender_w, viewer_sum)
    values (v_seq.nextval, 50, 0, 57, 29, 14, 0, 33, 67, null);


/*tblNation_List*/ --완료
insert into tblNation_List values (1,1);
insert into tblNation_List values (2,2);
insert into tblNation_List values (3,2);
insert into tblNation_List values (4,1);
insert into tblNation_List values (5,3);
insert into tblNation_List values (6,3);
insert into tblNation_List values (7,1);
insert into tblNation_List values (8,2);
insert into tblNation_List values (9,3);
insert into tblNation_List values (10,3);
insert into tblNation_List values (10,4);
insert into tblNation_List values (11,2);
insert into tblNation_List values (12,2);
insert into tblNation_List values (13,2);
insert into tblNation_List values (14,3);
insert into tblNation_List values (15,3);
insert into tblNation_List values (16,3);
insert into tblNation_List values (17,3);
insert into tblNation_List values (18,2);
insert into tblNation_List values (19,3);
insert into tblNation_List values (19,4);
insert into tblNation_List values (19,5);
insert into tblNation_List values (20,3);
insert into tblNation_List values (21,2);
insert into tblNation_List values (22,2);
insert into tblNation_List values (23,3);
insert into tblNation_List values (24,3);
insert into tblNation_List values (25,2);
insert into tblNation_List values (26,2);
insert into tblNation_List values (27,3);
insert into tblNation_List values (27,6);
insert into tblNation_List values (28,3);
insert into tblNation_List values (29,2);
insert into tblNation_List values (30,3);
insert into tblNation_List values (31,3);
insert into tblNation_List values (32,7);
insert into tblNation_List values (32,8);
insert into tblNation_List values (33,4);
insert into tblNation_List values (34,3);
insert into tblNation_List values (35,2);
insert into tblNation_List values (36,1);
insert into tblNation_List values (37,3);
insert into tblNation_List values (38,2);
insert into tblNation_List values (39,3);
insert into tblNation_List values (40,9);
insert into tblNation_List values (41,2);
insert into tblNation_List values (42,3);
insert into tblNation_List values (43,3);
insert into tblNation_List values (44,1);
insert into tblNation_List values (45,1);
insert into tblNation_List values (46,3);
insert into tblNation_List values (47,2);
insert into tblNation_List values (48,3);
insert into tblNation_List values (49,3);
insert into tblNation_List values (50,2);


/*tblGenre_List*/ --완료
insert into tblGenre_List values (1,14);
insert into tblGenre_List values (2,10);
insert into tblGenre_List values (2,18);
insert into tblGenre_List values (3,1);
insert into tblGenre_List values (4,14);
insert into tblGenre_List values (5,5);
insert into tblGenre_List values (5,18);
insert into tblGenre_List values (6,1);
insert into tblGenre_List values (7,14);
insert into tblGenre_List values (8,1);
insert into tblGenre_List values (8,15);
insert into tblGenre_List values (9,10);
insert into tblGenre_List values (9,18);
insert into tblGenre_List values (10,6);
insert into tblGenre_List values (10,18);
insert into tblGenre_List values (11,1);
insert into tblGenre_List values (12,9);
insert into tblGenre_List values (12,25);
insert into tblGenre_List values (13,1);
insert into tblGenre_List values (14,2);
insert into tblGenre_List values (14,6);
insert into tblGenre_List values (14,12);
insert into tblGenre_List values (15,2);
insert into tblGenre_List values (15,5);
insert into tblGenre_List values (15,18);
insert into tblGenre_List values (16,6);
insert into tblGenre_List values (16,12);
insert into tblGenre_List values (17,6);
insert into tblGenre_List values (17,12);
insert into tblGenre_List values (18,4);
insert into tblGenre_List values (18,12);
insert into tblGenre_List values (19,1);
insert into tblGenre_List values (19,10);
insert into tblGenre_List values (20,6);
insert into tblGenre_List values (21,1);
insert into tblGenre_List values (21,10);
insert into tblGenre_List values (22,4);
insert into tblGenre_List values (22,12);
insert into tblGenre_List values (23,1);
insert into tblGenre_List values (24,18);
insert into tblGenre_List values (25,1);
insert into tblGenre_List values (26,1);
insert into tblGenre_List values (27,1);
insert into tblGenre_List values (27,10);
insert into tblGenre_List values (28,6);
insert into tblGenre_List values (28,15);
insert into tblGenre_List values (29,1);
insert into tblGenre_List values (30,1);
insert into tblGenre_List values (31,18);
insert into tblGenre_List values (32,1);
insert into tblGenre_List values (33,4);
insert into tblGenre_List values (34,1);
insert into tblGenre_List values (35,5);
insert into tblGenre_List values (35,10);
insert into tblGenre_List values (35,11);
insert into tblGenre_List values (35,14);
insert into tblGenre_List values (35,16);
insert into tblGenre_List values (36,1);
insert into tblGenre_List values (36,2);
insert into tblGenre_List values (36,14);
insert into tblGenre_List values (37,1);
insert into tblGenre_List values (38,1);
insert into tblGenre_List values (39,18);
insert into tblGenre_List values (40,1);
insert into tblGenre_List values (41,1);
insert into tblGenre_List values (42,10);
insert into tblGenre_List values (42,18);
insert into tblGenre_List values (43,4);
insert into tblGenre_List values (43,6);
insert into tblGenre_List values (43,12);
insert into tblGenre_List values (44,14);
insert into tblGenre_List values (45,1);
insert into tblGenre_List values (45,14);
insert into tblGenre_List values (45,26);
insert into tblGenre_List values (46,5);
insert into tblGenre_List values (46,6);
insert into tblGenre_List values (46,17);
insert into tblGenre_List values (46,18);
insert into tblGenre_List values (47,1);
insert into tblGenre_List values (48,5);
insert into tblGenre_List values (48,17);
insert into tblGenre_List values (48,18);
insert into tblGenre_List values (49,5);
insert into tblGenre_List values (49,18);
insert into tblGenre_List values (50,18);


/*tblActor_List*/ --완료
insert into tblActor_List values (1,1);
insert into tblActor_List values (1,51);
insert into tblActor_List values (2,2);
insert into tblActor_List values (2,52);
insert into tblActor_List values (2,53);
insert into tblActor_List values (3,3);
insert into tblActor_List values (3,54);
insert into tblActor_List values (3,55);
insert into tblActor_List values (4,4);
insert into tblActor_List values (5,5);
insert into tblActor_List values (5,56);
insert into tblActor_List values (6,57);
insert into tblActor_List values (6,58);
insert into tblActor_List values (6,59);
insert into tblActor_List values (7,7);
insert into tblActor_List values (8,8);
insert into tblActor_List values (8,60);
insert into tblActor_List values (8,61);
insert into tblActor_List values (9,9);
insert into tblActor_List values (9,42);
insert into tblActor_List values (9,62);
insert into tblActor_List values (10,10);
insert into tblActor_List values (10,63);
insert into tblActor_List values (11,11);
insert into tblActor_List values (11,64);
insert into tblActor_List values (12,12);
insert into tblActor_List values (13,13);
insert into tblActor_List values (13,65);
insert into tblActor_List values (14,14);
insert into tblActor_List values (14,66);
insert into tblActor_List values (14,67);
insert into tblActor_List values (15,15);
insert into tblActor_List values (15,68);
insert into tblActor_List values (15,69);
insert into tblActor_List values (16,16);
insert into tblActor_List values (16,70);
insert into tblActor_List values (17,17);
insert into tblActor_List values (17,71);
insert into tblActor_List values (17,72);
insert into tblActor_List values (18,18);
insert into tblActor_List values (18,73);
insert into tblActor_List values (19,19);
insert into tblActor_List values (19,74);
insert into tblActor_List values (20,20);
insert into tblActor_List values (20,75);
insert into tblActor_List values (20,76);
insert into tblActor_List values (21,21);
insert into tblActor_List values (21,77);
insert into tblActor_List values (22,22);
insert into tblActor_List values (22,78);
insert into tblActor_List values (22,79);
insert into tblActor_List values (23,23);
insert into tblActor_List values (24,24);
insert into tblActor_List values (24,80);
insert into tblActor_List values (24,81);
insert into tblActor_List values (25,25);
insert into tblActor_List values (25,82);
insert into tblActor_List values (25,83);
insert into tblActor_List values (26,26);
insert into tblActor_List values (26,84);
insert into tblActor_List values (26,85);
insert into tblActor_List values (27,27);
insert into tblActor_List values (28,28);
insert into tblActor_List values (28,86);
insert into tblActor_List values (28,87);
insert into tblActor_List values (29,29);
insert into tblActor_List values (29,88);
insert into tblActor_List values (29,89);
insert into tblActor_List values (30,30);
insert into tblActor_List values (30,90);
insert into tblActor_List values (31,31);
insert into tblActor_List values (31,91);
insert into tblActor_List values (31,92);
insert into tblActor_List values (32,32);
insert into tblActor_List values (32,93);
insert into tblActor_List values (32,94);
insert into tblActor_List values (33,33);
insert into tblActor_List values (34,95);
insert into tblActor_List values (34,96);
insert into tblActor_List values (34,97);
insert into tblActor_List values (35,35);
insert into tblActor_List values (35,98);
insert into tblActor_List values (36,36);
insert into tblActor_List values (36,99);
insert into tblActor_List values (36,100);
insert into tblActor_List values (37,37);
insert into tblActor_List values (37,101);
insert into tblActor_List values (37,102);
insert into tblActor_List values (38,103);
insert into tblActor_List values (38,104);
insert into tblActor_List values (39,39);
insert into tblActor_List values (39,105);
insert into tblActor_List values (39,106);
insert into tblActor_List values (40,40);
insert into tblActor_List values (40,107);
insert into tblActor_List values (40,108);
insert into tblActor_List values (41,41);
insert into tblActor_List values (41,109);
insert into tblActor_List values (41,110);
insert into tblActor_List values (42,9);
insert into tblActor_List values (42,42);
insert into tblActor_List values (42,62);
insert into tblActor_List values (43,43);
insert into tblActor_List values (43,111);
insert into tblActor_List values (44,44);
insert into tblActor_List values (44,112);
insert into tblActor_List values (44,113);
insert into tblActor_List values (45,45);
insert into tblActor_List values (46,46);
insert into tblActor_List values (46,114);
insert into tblActor_List values (46,115);
insert into tblActor_List values (47,47);
insert into tblActor_List values (47,116);
insert into tblActor_List values (47,117);
insert into tblActor_List values (49,49);
insert into tblActor_List values (49,118);
insert into tblActor_List values (50,50);
insert into tblActor_List values (50,121);
insert into tblActor_List values (50,120);
insert into tblActor_List values (49,119);
insert into tblActor_List values (48,48);
insert into tblActor_List values (48,46);
insert into tblActor_List values (48,16);


/*tblDirector_List*/ --완료
insert into tblDirector_List values (1,1);
insert into tblDirector_List values (2,2);
insert into tblDirector_List values (3,3);
insert into tblDirector_List values (4,4);
insert into tblDirector_List values (5,5);
insert into tblDirector_List values (6,6);
insert into tblDirector_List values (7,7);
insert into tblDirector_List values (8,8);
insert into tblDirector_List values (9,9);
insert into tblDirector_List values (9,10);
insert into tblDirector_List values (10,11);
insert into tblDirector_List values (11,12);
insert into tblDirector_List values (12,13);
insert into tblDirector_List values (13,14);
insert into tblDirector_List values (14,15);
insert into tblDirector_List values (15,16);
insert into tblDirector_List values (15,17);
insert into tblDirector_List values (16,18);
insert into tblDirector_List values (17,19);
insert into tblDirector_List values (17,20);
insert into tblDirector_List values (18,21);
insert into tblDirector_List values (19,22);
insert into tblDirector_List values (20,23);
insert into tblDirector_List values (21,24);
insert into tblDirector_List values (22,25);
insert into tblDirector_List values (23,26);
insert into tblDirector_List values (24,27);
insert into tblDirector_List values (25,28);
insert into tblDirector_List values (26,29);
insert into tblDirector_List values (27,30);
insert into tblDirector_List values (28,31);
insert into tblDirector_List values (29,32);
insert into tblDirector_List values (30,33);
insert into tblDirector_List values (31,34);
insert into tblDirector_List values (32,35);
insert into tblDirector_List values (33,36);
insert into tblDirector_List values (34,37);
insert into tblDirector_List values (35,38);
insert into tblDirector_List values (35,39);
insert into tblDirector_List values (36,40);
insert into tblDirector_List values (37,41);
insert into tblDirector_List values (38,42);
insert into tblDirector_List values (39,43);
insert into tblDirector_List values (40,44);
insert into tblDirector_List values (41,45);
insert into tblDirector_List values (42,9);
insert into tblDirector_List values (42,10);
insert into tblDirector_List values (43,46);
insert into tblDirector_List values (44,1);
insert into tblDirector_List values (45,1);
insert into tblDirector_List values (46,47);
insert into tblDirector_List values (47,48);
insert into tblDirector_List values (48,49);
insert into tblDirector_List values (49,50);
insert into tblDirector_List values (50,51);



