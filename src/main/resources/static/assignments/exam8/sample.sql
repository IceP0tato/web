drop database if exists exam8;
create database exam8;
use exam8;

create table member (
	mno int auto_increment,
    mid varchar(20) not null unique,
    mpwd varchar(20) not null,
    mpoint int default 1000,
    constraint primary key(mno)
);
drop table member;
drop table pointlog;

-- ---------------------- pointlog ---------------------------------- --
CREATE TABLE pointlog (
    plno      INT AUTO_INCREMENT,
    mno       INT NOT NULL,
    plpoint   INT NOT NULL,
    plcomment VARCHAR(100) NOT NULL,
    pldate    DATETIME DEFAULT NOW(),
    CONSTRAINT PRIMARY KEY (plno),
    CONSTRAINT FOREIGN KEY (mno) REFERENCES member(mno) ON DELETE CASCADE
);
-- ---------------------- 포인트 적립 샘플 ---------------------- --
-- 회원 1이 회원가입 포인트 지급 (+1000)
INSERT INTO pointlog (mno, plpoint, plcomment) VALUES (1, 1000, '회원가입');
-- 회원 1이 로그인 포인트 지급 (+100) 3회
INSERT INTO pointlog (mno, plpoint, plcomment) VALUES (1, 100, '로그인');
INSERT INTO pointlog (mno, plpoint, plcomment) VALUES (1, 100, '로그인');
INSERT INTO pointlog (mno, plpoint, plcomment) VALUES (1, 100, '로그인');
-- ---------------------- 포인트 충전/차감 샘플 ---------------------- --
-- 회원 1이 포인트 충전 (+5000)
INSERT INTO pointlog (mno, plpoint, plcomment) VALUES (1, 5000, '포인트충전');
-- 회원 1이 제품 구매로 포인트 차감 (-6000)
INSERT INTO pointlog (mno, plpoint, plcomment) VALUES (1, -6000, '상품구매');
-- 회원 1이 이벤트 참여로 포인트 적립 (+500)
INSERT INTO pointlog (mno, plpoint, plcomment) VALUES (1, 500, '이벤트적립');

select * from member;
select * from pointlog;