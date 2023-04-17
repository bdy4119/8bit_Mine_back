-- mine DB생성
create database mine;


-- mine DB 사용
use mine;
-----------------------태우----------------------------------
CREATE TABLE MY_FILEIOAD(
	MF_SEQ INT AUTO_INCREMENT PRIMARY KEY, -- 파일 번호
	MF_CATEGORY VARCHAR(10),  --카테고리
	MF_TITLE VARCHAR(200) NOT NULL, --  파일명
	MF_REGDATE TIMESTAMP DEFAULT NOW() NOT NULL, -- 작성일
	MF_MEMO  VARCHAR(200), -- 메모
	MF_FILE_ID VARCHAR(50) NOT NULL, -- 작성자	
	MF_FILENAME DECIMAL(10), --원본파일 
	MF_NEWFILENAME DECIMAL(10), -- 담아둘거
	REFERENCES MEMBER()  ON DELETE CASCADE,
);


CREATE TABLE GUEST_BOOK(
    GB_SEQ INT AUTO_INCREMENT PRIMARY KEY, -- 글 번호
    GB_ID VARCHAR(50) NOT NULL, -- 작성자
    GB_CONTENT VARCHAR(4000) NOT NULL, -- 글 내용
    GB_WRITEDATE TIMESTAMP DEFAULT NOW() NOT NULL, -- 작성일
   REFERENCES MEMBER()  ON DELETE CASCADE,
);


CREATE TABLE GUEST_COMMENT(
 	GC_SEQ INT, -- 댓글이 작성될 글의 번호
	GC_COMMENTSEQ INT AUTO_INCREMENT PRIMARY KEY, -- 댓글 고유 번호
    	GC_REF DECIMAL(8) NOT NULL,
   	GC_DEPTH DECIMAL(1) DEFAULT 0,
   	GC_STEP DECIMAL(8) DEFAULT 0, 
	GC_ID VARCHAR(50),
	GC_CONTENT VARCHAR(4000) NOT NULL, -- 댓글 내용
	GC_WRITEDATE TIMESTAMP NOT NULL, -- 댓글 작성 일자
	REFERENCES GB_FRIEND(GB_ID)  ON DELETE CASCADE,
);


CREATE TABLE GB_CARD(
	GBC_SEQ INT AUTO_INCREMENT PRIMARY KEY, -- 명함번호
	GBC_CATEGORY VARCHAR(10) --카테고리
	GBC_REGDATE TIMESTAMP DEFAULT NOW() NOT NULL, -- 작성일
	GBC_MEMO  VARCHAR(200), -- 메모
	GBC_ID VARCHAR(50) NOT NULL, -- 명함이름	
	REFERENCES MEMBER()  ON DELETE CASCADE,
);


CREATE TABLE IN_INSTT(
IN_SEQ INT AUTO_INCREMENT PRIMARY KEY, -- 번호
IN_ID VARCHAR(50) NOT NULL, -- 이름		
IN_REGDATE TIMESTAMP DEFAULT NOW() NOT NULL, -- 작성일
IN_MEMO  VARCHAR(200), -- 메모
IN_TEMP  VARCHAR(200), -- 음성담기
);



-----------------------태우----------------------------------

-- -------------------다연 ------------------------------------------------------------------------------------
-- Me(다이어리) DB -----------------------------------------------------------------
-- 일기?리스트 db
create table calendar(
	seq int auto_increment primary key,
	id varchar(50) not null, 
	title varchar(200) not null,
	content varchar(4000),
	rdate varchar(12) not null,
	wdate timestamp not null,
	del decimal(1) not null
);
-- id참조
alter table calender
add foreign key(id) references member(id);


-- todo리스트 db
create table todo(
	seq int auto_increment primary key,
	id varchar(50) not null, 
	title varchar(200) not null,
	content varchar(4000),
	rdate varchar(12) not null,
	wdate timestamp not null
);
-- id참조
alter table todo
add foreign key(id) references member(id);



-- 온라인 명함 DB -------------------------------------------
create table businesscard(
    seq int auto_increment primary key,
	id varchar(50) not null,
    name varchar(50) not null,
    email varchar(50) unique,
    url varchar(255),  -- 깃허브 블로그등 주소
    historydate varchar(200) not null, -- 수행했던 날짜
    wdate timestamp not null,
	content varchar(4000),
    thumbnail  varchar(1000) not null
);




-- 커스텀 DB -------------------------------------
create table style (
    hair  varchar(1000) not null,
    eyes  varchar(1000) not null,
    nose  varchar(1000) not null,
    eyebrow  varchar(1000) not null,
    mouth  varchar(1000) not null
);

-- 캐릭터 디폴트값
create table main (
    hair  varchar(1000) not null,
    eyes  varchar(1000) not null,
    nose  varchar(1000) not null,
    eyebrow  varchar(1000) not null,
    mouth  varchar(1000) not null
);

-- -------------------다연 ------------------------------------------------------------------------------------

-- mine 이미지와 텍스트 저장
create table mine_mine(
    seq int auto_increment primary key,
    id varchar(50) not null, 
    pagenumber int not null,
    position int not null,
    imgurl varchar(300) not null,
    imgtext varchar(500) not null
);















-- -------------------인서 ------------------------------------------------------------------------------------

create table user(
id varchar(20) primary key,
pwd varchar(50) not null,
name varchar(50) not null,
email varchar(100) not null,
phone varchar(12) not null,
regi_date timestamp not null,
user_auth int default 1,
user_state varchar(100),
cause varchar(100),
mail_auth int default 0,
mail_key varchar(50),
imagefilename varchar(50) default "profileimage.jpg",
newimagefilename varchar(50) default "profileimage.jpg"
);

create table report(
seq int primary key auto_increment
informant varchar(20) not null,
suspect varchar(20) not null,
report_cause varchar(100) not null,
report_content varchar(50) not null,
result varchar(50) default "choose",
report_date timestamp not null,
report_state varchar(50) default "checking"
);

-- -------------------인서 ------------------------------------------------------------------------------------

------------------------------------------준----------------------------------------------------------------
CREATE TABLE MINE_I(
		SEQ INT AUTO_INCREMENT PRIMARY KEY,
        ID VARCHAR(20) NOT NULL,
        CLASSIFY VARCHAR(30) NOT NULL,
        ITEM VARCHAR(50),
        DETAIL VARCHAR(50),
		REF INT
);

CREATE TABLE MINE_CLASSI(
		SEQ INT AUTO_INCREMENT PRIMARY KEY,
        ID VARCHAR(20) NOT NULL,
        CLASSIFY VARCHAR(30) NOT NULL,
        REF INT
);
-----------------------------------------------------------------------------------------------------------
