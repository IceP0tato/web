drop database if exists waiting;
create database waiting;
use waiting;
create table list (
	num int auto_increment,
    phone varchar(20) not null,
    count int not null,
    constraint primary key(num)
);

# Sample
INSERT INTO list (phone, count) VALUES
('010-1234-5678', 3),
('010-2345-6789', 1),
('010-3456-7890', 5),
('010-4567-8901', 2),
('010-5678-9012', 4),
('010-6789-0123', 6),
('010-7890-1234', 2),
('010-8901-2345', 7),
('010-9012-3456', 3),
('010-0123-4567', 1);

select * from list;