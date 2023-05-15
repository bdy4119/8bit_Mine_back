drop table MY_FILELOAD;
drop table calendar;
drop table todo;
drop table businesscard;
drop table businesscardBack;
drop table mine_mine;
drop table mine_answer;
drop table user;
drop table report;
drop table MINE_I;
drop table BGM;
drop table MINE_CLASSI;
drop table MINE_7QNA;
drop table GUESTBOOK;
drop table friend;
drop table notification;

CREATE TABLE notification(
	seq int auto_increment primary key,
	id varchar(100), 
    minenotice int,
    guestnotice int
);

CREATE TABLE friend(
	seq int auto_increment primary key,
	id varchar(100), 
    friendid varchar(100)
);


CREATE TABLE MY_FILELOAD(
  MF_SEQ INT AUTO_INCREMENT PRIMARY KEY, -- 파일 번호
  MF_CATEGORY VARCHAR(20),  -- 카테고리
  MF_TITLE VARCHAR(200) NOT NULL, --  파일명
  MF_REGDATE TIMESTAMP DEFAULT NOW() NOT NULL, -- 작성일
  MF_MEMO  VARCHAR(200), -- 메모
  MF_FILE_ID VARCHAR(50) NOT NULL, -- 작성자	
  MF_FILENAME varchar(500), -- 원본파일 
  MF_NEWFILENAME varchar(500) -- 업로드파일
);


-- -------------------다연 ------------------------------------------------------------------------------------
-- 다이어리 리스트 db
create table calendar(
	seq int auto_increment primary key,
	id varchar(100), 
	title varchar(200) not null,
	thumbnail varchar(4000), -- 안되면 지우기
	content varchar(4000),
	rdate varchar(256) not null,
	wdate timestamp not null,
    del decimal(1) not null
);


create table todo(
	seq int auto_increment primary key,
	id varchar(100), 
	title varchar(200) not null,
	content varchar(4000),
	rdate varchar(256) not null,
	wdate timestamp not null,
    del decimal(1) not null
);


-- 온라인 명함 DB -------------------------------------------
create table businesscard(
    seq int auto_increment primary key,
	id varchar(100),
    thumbnail varchar(4000) not null,
    introduce varchar(4000) not null,
    phoneNum varchar(255) not null,
    name varchar(50) not null,
    email varchar(50) unique,
    url varchar(255),  -- 깃허브 블로그등 주소
    wdate timestamp not null
);


-- 명함 뒷면-----
create table businesscardBack(
	seq int auto_increment primary key,
    id varchar(100),
	historyDate varchar(200) not null, -- 수행날짜
    historyTitle varchar(2000) not null, -- 수행제목
    historyContent varchar(4000) not null, -- 수행내용
    historyUrl varchar(255),
    wdate timestamp not null
);



-- mine 이미지와 텍스트 저장
create table mine_mine(
    seq int auto_increment primary key,
    id varchar(100) not null, 
    position int not null,
    filename varchar(500) not null,	-- 원본 파일명
    newfilename varchar(500) not null, -- 업로드 파일명
    imgtext varchar(500) not null
);

-- mine 방명록
create table mine_answer(
    seq int auto_increment primary key,
    userid varchar(100) not null, -- 작성자
    mineid varchar(100) not null, -- 마인 주인
    question1 varchar(500) not null,
    question2 varchar(500) not null,
	question3 varchar(500) not null,    
    answer1 varchar(500) not null,
    answer2 varchar(500) not null,
    answer3 varchar(500) not null
);

create table user(
	email varchar(100) primary key,
	name varchar(50) not null,
	regidate timestamp not null,
	id varchar(100),
	social varchar(50),
	auth int,
	cause varchar(100),
	token varchar(200),
    profPic varchar(50),
    profMsg varchar(100),
    job varchar(100),
    birthdate varchar(20),
    address varchar(100)
);

create table report(
seq int primary key auto_increment,
informant varchar(20) not null,
suspect varchar(20) not null,
report_cause varchar(100) not null,
report_content varchar(50) not null,
result varchar(50) default "choose",
report_date timestamp not null,
report_state varchar(50) default "checking"
);

CREATE TABLE MINE_I(
SEQ INT AUTO_INCREMENT PRIMARY KEY,
ID VARCHAR(100) NOT NULL,
CLASSIFY VARCHAR(30) NOT NULL,
ITEM VARCHAR(50),
DETAIL VARCHAR(50),
REF INT
);

CREATE TABLE BGM(
SEQ INT AUTO_INCREMENT PRIMARY KEY,
ID VARCHAR(100),
ARTIST VARCHAR(30),
TITLE VARCHAR(30),
URL VARCHAR(50)
);

CREATE TABLE MINE_CLASSI(
SEQ INT AUTO_INCREMENT PRIMARY KEY,
ID VARCHAR(100) NOT NULL,
CLASSIFY VARCHAR(30) NOT NULL,
REF INT
);

CREATE TABLE MINE_10QNA(
ID VARCHAR(100) PRIMARY KEY,
Q1 VARCHAR(100),
Q2 VARCHAR(100),
Q3 VARCHAR(100),
Q4 VARCHAR(100),
Q5 VARCHAR(100),
Q6 VARCHAR(100),
Q7 VARCHAR(100),
Q8 VARCHAR(100),
Q9 VARCHAR(100),
Q10 VARCHAR(100)
);

CREATE TABLE GUESTBOOK(
SEQ INT AUTO_INCREMENT PRIMARY KEY,
TOID VARCHAR(100),
TONAME VARCHAR(50),
FROMID VARCHAR(100),
FROMNAME VARCHAR(50),
COMMENT VARCHAR(50),
REF INT,
STEP INT,
ISVOICE INT,
FILENAME VARCHAR(30),
REGDATE TIMESTAMP
);
