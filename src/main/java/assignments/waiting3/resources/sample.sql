drop database if exists waiting;
create database waiting;
use waiting;

create table list (
	num int auto_increment,
    constraint primary key(num),
    phone varchar(20),
    count int,
    date datetime default now()
);

INSERT INTO list (num, phone, count, date) VALUES
(1, '010-1234-5678', 5, '2025-08-01 10:15:00'),
(2, '010-2345-6789', 3, '2025-08-02 11:30:00'),
(3, '010-3456-7890', 7, '2025-08-03 09:45:00'),
(4, '010-4567-8901', 2, '2025-08-04 14:20:00'),
(5, '010-5678-9012', 9, '2025-08-05 16:00:00'),
(6, '010-6789-0123', 4, '2025-08-06 08:10:00'),
(7, '010-7890-1234', 6, '2025-08-07 12:25:00'),
(8, '010-8901-2345', 1, '2025-08-08 13:40:00'),
(9, '010-9012-3456', 8, '2025-08-09 15:55:00'),
(10, '010-0123-4567', 10, '2025-08-10 17:05:00');

select * from list;