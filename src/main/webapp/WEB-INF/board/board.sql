select * from boardTest;
show tables;


-- boardTest 테이블 설계
create table boardTest(
	idx int not null auto_increment,  /* 게시글의 고유 번호 */
	name varchar(20) not null,				/* 게시글 올린이 성명 */
	title varchar(100) not null,			/* 게시글 제목 */
	content text not null, 						/* 게시글 내용 */
	hostIp varchar(40) not null, 			/* 글 올린이의 접속 IP */
	readNum int default 0,						/* 글 조회수 */
	wDate datetime default now(),			/* 글쓴 날짜(기본값은 현재 날짜/시간) */
	primary key(idx)									/* 기본키 : 고유번호(idx) */
);

desc boardTest;

insert into boardTest values(default, '관리자', '게시판 서비스를 시작합니다.', '즐거운 게시판 생활하기', '192.168.50.57', default, default);

select * from boardTest order by idx desc;