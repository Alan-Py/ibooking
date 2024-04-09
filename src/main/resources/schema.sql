-- ----------------------------
-- Table structure for admin
-- ----------------------------
drop table if exists admin;
create table admin
(
    id         int         not null auto_increment,
    admin_id   varchar(16) not null,
    admin_name varchar(16) not null,
    password   varchar(16) not null,
    primary key (id),
    unique (admin_id)
);

drop table if exists student;
create table student
(
    id       int         not null auto_increment,
    stu_id   varchar(16) not null,
    name     varchar(16) not null,
    email    varchar(32) not null,
    phone    varchar(16) not null,
    password varchar(16) not null,
    primary key (id),
    unique (stu_id)
);

drop table if exists room;
create table room
(
    id               int         not null auto_increment,
    room_id          varchar(16) not null,
    room_name        varchar(16) not null,
    building_id      varchar(16) not null,
    seat_amount      int         not null,
    open_time        int         not null,
    close_time       int         not null,
    overnight        BOOLEAN     not null,
    max_booking_time int         not null,
    open             BOOLEAN     not null,
    primary key (id),
    unique (room_id)
);

drop table if exists seat;
create table seat
(
    id      int         not null auto_increment,
    seat_id varchar(16) not null,
    room_id varchar(16) not null,
    socket  BOOLEAN     not null,
    open    BOOLEAN     not null,
    today_book  varchar(25) not null,
    next_book   varchar(25) not null,
    primary key (id, room_id)
);

drop table if exists record;
create table record
(
    id           int         not null auto_increment,
    seat_id      varchar(16) not null,
    room_id      varchar(16) not null,
    stu_id       varchar(16) not null,
    start_time   int         not null,
    end_time     int         not null,
    booking_date DATE        not null,
    status       int         not null,
    primary key (id)
);