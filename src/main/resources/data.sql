INSERT INTO admin (id, admin_id, admin_name, password) VALUES (1,'10001', '张三', 'zhangsan123');
INSERT INTO admin (id, admin_id, admin_name, password) VALUES (2,'10002', '李四', 'lisi123');
INSERT INTO admin (id, admin_id, admin_name, password) VALUES (3,'10003', '王五', 'wangwu123');

INSERT INTO room (id,room_id, room_name, building_id, seat_amount, open_time, close_time, overnight, max_booking_time, open) VALUES (1, 'R001', '第一会议室', 'B001', 50, 6, 20, FALSE, 6, TRUE);
INSERT INTO room (id,room_id, room_name, building_id, seat_amount, open_time, close_time, overnight, max_booking_time, open) VALUES (2,'R002', '第二教室', 'B002', 60, 6, 20, FALSE, 6, TRUE);
INSERT INTO room (id,room_id, room_name, building_id, seat_amount, open_time, close_time, overnight, max_booking_time, open) VALUES (3,'R003', '图书馆自习室', 'B003', 30, 6, 20, TRUE, 6, TRUE);
INSERT INTO room (id,room_id, room_name, building_id, seat_amount, open_time, close_time, overnight, max_booking_time, open) VALUES (4,'R004', '多功能厅', 'B001', 200, 6, 20, FALSE, 6, TRUE);

INSERT INTO seat (id, seat_id, room_id, socket) VALUES (1,'S001', 'R001', TRUE);
INSERT INTO seat (id, seat_id, room_id, socket) VALUES (2,'S002', 'R001', FALSE);
INSERT INTO seat (id, seat_id, room_id, socket) VALUES (3,'S003', 'R002', TRUE);
INSERT INTO seat (id, seat_id, room_id, socket) VALUES (4,'S004', 'R002', FALSE);
INSERT INTO seat (id, seat_id, room_id, socket) VALUES (5,'S005', 'R003', TRUE);
INSERT INTO seat (id, seat_id, room_id, socket) VALUES (6,'S006', 'R004', FALSE);
INSERT INTO seat (id, seat_id, room_id, socket) VALUES (7,'S007', 'R004', TRUE);

INSERT INTO student (id, stu_id, seat_id, name, email, phone, password) VALUES (1,'20240001', 'S001', '张伟', 'zhangwei@example.com', '13800138001', 'zhangwei123');
INSERT INTO student (id, stu_id, seat_id, name, email, phone, password) VALUES (2,'20240002', 'S002', '李娜', 'lina@example.com', '13800138002', 'lina123');
INSERT INTO student (id, stu_id, seat_id, name, email, phone, password) VALUES (3,'20240003', 'S003', '王芳', 'wangfang@example.com', '13800138003', 'wangfang123');
INSERT INTO student (id, stu_id, seat_id, name, email, phone, password) VALUES (4,'20240004', 'S004', '刘强', 'liuqiang@example.com', '13800138004', 'liuqiang123');
INSERT INTO student (id, stu_id, seat_id, name, email, phone, password) VALUES (5,'20240005', 'S005', '陈敏', 'chenmin@example.com', '13800138005', 'chenmin123');

INSERT INTO record (id, seat_id, room_id, stu_id, start_time, end_time, booking_date, status) VALUES (1, 'S001', 'R001', '20240001', 2, 6, '2024-04-10', 1);
INSERT INTO record (id, seat_id, room_id, stu_id, start_time, end_time, booking_date, status) VALUES (2, 'S002', 'R001', '20240002', 3, 7, '2024-04-11', 1);
INSERT INTO record (id, seat_id, room_id, stu_id, start_time, end_time, booking_date, status) VALUES (3, 'S005', 'R003', '20240003', 4, 8, '2024-04-12', 1);
INSERT INTO record (id, seat_id, room_id, stu_id, start_time, end_time, booking_date, status) VALUES (4, 'S006', 'R004', '20240004', 5, 9, '2024-04-13', 1);