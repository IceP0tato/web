 drop database if exists exam9;
 create database exam9;
 use exam9;
 
create table member (
	mno int auto_increment,
    mid varchar(20) not null unique,
    mpwd varchar(20) not null,
    constraint primary key (mno)
);
# drop table member;
# drop table memberimg;
 -- ---------------------- memberimg ---------------------------------- --
    CREATE TABLE memberimg (
        mimgno    INT AUTO_INCREMENT,              -- 회원 이미지 번호 (기본키)
        mimgname  VARCHAR(255) NOT NULL,           -- 파일명
        mno       INT NOT NULL,                    -- 회원 번호 (FK)
        CONSTRAINT PRIMARY KEY (mimgno),
        CONSTRAINT FOREIGN KEY (mno) REFERENCES member(mno) ON DELETE CASCADE
    );
    
select * from member;
select * from memberimg;