create database HeThongKhuNghiDuong;

use HeThongKhuNghiDuong;

create table vi_tri (
ma_vi_tri int primary key auto_increment,
ten_vi_tri varchar(45)
);

create table trinh_do (
ma_trinh_do int primary key auto_increment,
te_trinh_do varchar(45)
);

create table bo_phan (
ma_bo_phan int primary key auto_increment,
te_bo_phan varchar(45)
);

create table nhan_vien (
ma_nhan_vien int primary key auto_increment,
ho_ten varchar(45),
ngzy_sinh date,
so_cmnd varchar(45),
luong double,
so_dien_thoai varchar(45),
email varchar(45),
dia_chi varchar(45),
ma_vi_tri int,
ma_trinh_do int,
ma_bo_phan int,
foreign key (ma_vi_tri) references vi_tri(ma_vi_tri),
foreign key (ma_trinh_do) references trinh_do(ma_trinh_do),
foreign key (ma_bo_phan) references bo_phan(ma_bo_phan)
);


create table loai_khach (
ma_loai_khach int primary key auto_increment,
ten_loai_khach varchar(45)
);

create table khach_hang (
ma_khach_hang int primary key auto_increment,
ma_loai_khach int,
ho_ten varchar(45),
ngay_sinh date,
gioi_tinh bit(1),
so_cmnd varchar(45),
email varchar(45),
dia_chi varchar(45),
foreign key (ma_loai_khach) references loai_khach(ma_loai_khach)
);

create table dich_vu_di_kem (
ma_dich_vu_di_kem int primary key auto_increment,
ten_dich_vu_di_kem varchar(45),
gia double,
don_vi varchar(45),
trang_thai varchar(45)
);

create table loai_dich_vu (
ma_loai_dich_vu int primary key auto_increment,
ten_loai_dich_vu varchar(45)
);

create table kieu_thue (
ma_kieu_thue int primary key auto_increment,
ten_kieu_thue varchar(45)
);

create table dich_vu (
ma_dich_vu int primary key auto_increment,
ten_dich_vu varchar(45),
dien_tich int,
chi_phi_thue double,
so_nguoi_bi_da int,
ma_kieu_thue int,
ma_loai_dich_vu int,
tieu_chuan_phong varchar(45),
mo_ta_tien_nghi_khac varchar(45),
dien_tich_ho_boi double,
so_tang int,
foreign key (ma_kieu_thue) references kieu_thue(ma_kieu_thue),
foreign key (ma_loai_dich_vu) references loai_dich_vu(ma_loai_dich_vu)
);

create table hop_dong (
ma_hop_dong int primary key auto_increment,
ngay_lam_hop_dong datetime,
ngay_ket_thuc datetime,
tien_dat_coc double,
ma_nhan_vien int,
ma_khach_hang int,
ma_dich_vu int,
foreign key (ma_nhan_vien) references nhan_vien(ma_nhan_vien),
foreign key (ma_khach_hang) references khach_hang(ma_khach_hang),
foreign key (ma_dich_vu) references dich_vu(ma_dich_vu)
);

create table hop_dong_chi_tiet (
ma_hop_dong_chi_tiet int primary key auto_increment,
ma_hop_dong int,
ma_dich_vu_di_kem int,
so_luong int,
foreign key (ma_hop_dong) references hop_dong(ma_hop_dong),
foreign key (ma_dich_vu_di_kem) references dich_vu_di_kem(ma_dich_vu_di_kem)
);

insert into vi_tri (ma_vi_tri, ten_vi_tri)
VALUE(1, 'Quản Lý'),
	 (2, 'Nhân Viên');
SELECT * FROM vi_tri;
     
INSERT INTO trinh_do (ma_trinh_do, te_trinh_do)
VALUE(1, 'Trung Cấp'),
     (2, 'Cao Đẳng'),
     (3, 'Đại Học'),
     (4, 'Sau Đại Học');
SELECT * FROM trinh_do;
     
INSERT INTO bo_phan (ma_bo_phan, te_bo_phan)
VALUE(1, 'Sale-Marketing'),
	 (2, 'Hành chính'),
     (3, 'Phục vụ'),
     (4, 'Quản lý');
SELECT * FROM bo_phan;

insert into nhan_vien
VALUE(1, 'Nguyễn Văn An', '1970-11-07',	'456231786', 10000000, '0901234121', 'annguyen@gmail.com', '295 Nguyễn Tất Thành, Đà Nẵng',	1, 3, 1),
     (2, 'Lê Văn Bình', '1997-04-09', '654231234', 7000000, '0934212314', 'binhlv@gmail.com', '22 Yên Bái, Đà Nẵng', 1, 2, 2),
     (3, 'Hồ Thị Yến', '1995-12-12', '999231723', 14000000, '0412352315', 'thiyen@gmail.com', 'K234/11 Điện Biên Phủ, Gia Lai', 1, 3, 2),
     (4, 'Võ Công Toản', '1980-04-04', '123231365', 17000000, '0374443232', 'toan0404@gmail.com', '77 Hoàng Diệu, Quảng Trị', 1, 4, 4),
     (5, 'Nguyễn Bỉnh Phát', '1999-12-09', '454363232', 6000000, '0902341231', 'phatphat@gmail.com', '43 Yên Bái, Đà Nẵng', 2, 1, 1),
     (6, 'Khúc Nguyễn An Nghi', '2000-11-08', '964542311', 7000000, '0978653213', 'annghi20@gmail.com', '294 Nguyễn Tất Thành, Đà Nẵng', 2, 2, 3),
     (7, 'Nguyễn Hữu Hà', '1993-01-01', '534323231', 8000000, '0941234553', 'nhh0101@gmail.com', '4 Nguyễn Chí Thanh, Huế', 2, 3, 2),
     (8, 'Nguyễn Hà Đông', '1989-09-03', '234414123', 9000000, '0642123111', 'donghanguyen@gmail.com', '111 Hùng Vương, Hà Nội', 2, 4, 4),
     (9, 'Tòng Hoang', '1982-09-03', '256781231', 6000000, '0245144444', 'hoangtong@gmail.com', '213 Hàm Nghi, Đà Nẵng', 2, 4, 4),
     (10, 'Nguyễn Công Đạo', '1994-01-08', '755434343', 8000000, '0988767111', 'nguyencongdao12@gmail.com', '6 Hoà Khánh, Đồng Nai', 2, 3, 2);
 select * from nhan_vien;
 
INSERT INTO loai_khach (ma_loai_khach, ten_loai_khach)
VALUE(1, 'Diamond'),
     (2, 'Platinium'),
     (3, 'Gold'),
     (4, 'Silver'),
     (5, 'Member');
SELECT * FROM loai_khach;
     
INSERT INTO khach_hang
VALUE(1, 5, 'Nguyễn Thị Hào', '11/07/1970', 0, '643431213','thihao07@gmail.com', '23 Nguyễn Hoàng, Đà Nẵng'),
     (2, 3, 'Phạm Xuân Diệu', '08/08/1990', 1, '865342123','xuandieu92@gmail.com', 'K77/22 Thái Phiên, Quảng Trị'),
     (3, 1, 'Trương Đình Nghệ', '02-271990', 1, '488645199','nghenhan2702@gmail.com', 'K323/12 Ông Ích Khiêm, Vinh'),
     (4, 1, 'Dương Văn Quan', '07-08-1981', 1, '543432111','duongquan@gmail.com', 'K453/12 Lê Lợi, Đà Nẵng'),
     (5, 4, 'Hoàng Trần Nhi Nhi', '12-091995', 0, '795453345', 'nhinhi123@gmail.com', '224 Lý Thái Tổ, Gia Lai');
SELECT * FROM khach_hang;

INSERT INTO kieu_thue (ma_kieu_thue, ten_kieu_thue)
VALUE(1, 'year'),
     (2, 'month'),
     (3, 'day'),
     (4, 'hour');
SELECT * FROM kieu_thue;
     
INSERT INTO loai_dich_vu (ma_loai_dich_vu, ten_loai_dich_vu)
VALUE(1, 'Villa'),
     (2, 'House'),
     (3, 'Room');
SELECT * FROM loai_dich_vu;
    
INSERT INTO dich_vu
VALUE(1, 'Villa Beach Front', 25000, 10000000, 10, 3, 1, 'vip', 'Có hồ bơi', 500, 4),
     (2, 'House Princess 01', 14000, 5000000, 7, 2, 2, 'vip', 'Có thêm bếp nướng', null, 3),
     (3, 'Room Twin 01', 5000, 1000000, 2, 4, 3, 'normal', 'Có tivi', null, null),
     (4, 'Villa No Beach Front', 22000, 9000000, 8, 3, 1, 'normal', 'Có hồ bơi', 300, 3),
     (5, 'House Princess 02', 10000, 4000000, 5, 3, 2, 'normal', 'Có thêm bếp nướng', null, 2),
     (6, 'Room Twin 02', 3000, 900000, 2, 4, 3, 'normal', 'Có tivi', null, null);
SELECT * FROM dich_vu;

INSERT INTO dich_vu_di_kem
VALUE(1, 'Karaoke', 10000, 'giờ', 'tiện nghi, hiện tại'),
     (2, 'Thuê xe máy', 10000, 'chiếc', 'hỏng 1 xe'),
     (3, 'Thuê xe đạp', 20000, 'chiếc', 'tốt'),
     (4, 'Buffet buổi sáng', 15000, 'suất', 'đầy đủ đồ ăn, tráng miệng'),
     (5, 'Buffet buổi trưa', 90000, 'suất', 'đầy đủ đồ ăn, tráng miệng'),
     (6, 'Buffet buổi tối', 16000, 'suất', 'đầy đủ đồ ăn, tráng miệng');
SELECT * FROM dich_vu_di_kem;
     
INSERT INTO hop_dong
VALUE(1, '2020-12-08', '2020-12-08', 0, 3, 1, 3),
     (2, '2020-07-14', '2020-07-21', 200000, 7, 3, 1),
     (3, '2021-03-15', '2021-03-17', 50000, 3, 4, 2),
     (4, '2021-01-14', '2021-01-18', 100000, 7, 5, 5),
     (5, '2021-07-14', '2021-07-15', 0, 7, 2, 6),
     (6, '2021-06-01', '2021-06-03', 0, 7, 7, 6),
     (7, '2021-09-02', '2021-09-05', 100000, 7, 4, 4),
     (8, '2021-06-17', '2021-06-18', 150000, 3, 4, 1),
     (9, '2020-11-19', '2020-11-19', 0, 3, 4, 3),
     (10, '2021-04-12', '2021-04-14', 0, 10, 3, 5),
     (11, '2021-04-25', '2021-04-25', 0, 2, 2, 1),
     (12, '2021-05-25', '2021-05-27', 0, 7, 10, 1);
SELECT * FROM hop_dong;
     
INSERT INTO hop_dong_chi_tiet
VALUE(1,  2, 4, 5),
     (2, 2, 5, 8),
     (3, 2, 6, 15),
     (4, 3, 1, 1),
     (5, 3, 2, 11),
     (6, 1, 3, 1),
     (7, 1, 2, 2),
     (8, 12, 2, 2);
SELECT * FROM hop_dong_chi_tiet;
 
--  2 
select * from nhan_vien
where (ho_ten like "%h" or ho_ten like "%k" or ho_ten like "%t" ) AND LENGTH(ho_ten) < 15;

-- 3
SELECT * FROM khach_hang
WHERE
	YEAR(now()) - YEAR(ngay_sinh) BETWEEN 18 AND 50
	and(dia_chi = 'Quang Tri' OR dia_chi = 'Quang Nam');

-- 4	
select khach_hang.ho_ten, count(hop_dong.ma_hop_dong) as so_luong from khach_hang inner join hop_dong on khach_hang.ma_khach_hang=hop_dong.ma_hop_dong 
inner join loai_khach on khach_hang.ma_loai_khach=loai_khach.ma_loai_khach where loai_khach.ten_loai_khach="Diamond"
group by khach_hang.ma_khach_hang order by so_luong;

-- 5 
select khach_hang.ma_khach_hang, khach_hang.ho_ten, loai_khach.ten_loai_khach, hop_dong.ma_hop_dong, hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc, dich_vu.ten_dich_vu,
sum(dich_vu.chi_phi_thue + hop_dong_chi_tiet.so_luong*dich_vu_di_kem.gia) as tong_tien from khach_hang
left join loai_khach on khach_hang.ma_khach_hang=loai_khach.ma_loai_khach
left join hop_dong on khach_hang.ma_khach_hang=hop_dong.ma_khach_hang
left join dich_vu on hop_dong.ma_dich_vu=dich_vu.ma_dich_vu
left join hop_dong_chi_tiet on hop_dong.ma_hop_dong=hop_dong_chi_tiet.ma_hop_dong
left join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem=dich_vu_di_kem.ma_dich_vu_di_kem
group by hop_dong.ma_hop_dong;

-- 6 
SELECT
	se.id,
	se. `name`,
	se.area,
	se.price,
	st. `name`
FROM
	service se
	JOIN service_type st ON st.id = se.service_type_id
WHERE
	NOT EXISTS (
		SELECT
			*
		FROM
			contract
		WHERE
			service_id = se.id
			AND start_date BETWEEN '2021-01-01'
			AND '2021-03-31');

-- 7.	Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 nhưng chưa từng được khách hàng đặt phòng trong năm 2021.

SELECT
	se.id,
	se. `name`,
	se.area,
	se.price,
	se.max_people,
	st. `name`
FROM
	service se
	JOIN service_type st ON st.id = se.service_type_id
WHERE
	EXISTS (
		SELECT
			*
		FROM
			contract
		WHERE
			service_id = se.id
			AND YEAR(start_date) = '2020')
		AND NOT EXISTS (
			SELECT
				*
			FROM
				contract
			WHERE
				service_id = se.id
				AND YEAR(start_date) = '2021');


 
SELECT DISTINCT
	fullname
FROM
	customer;

SELECT
	fullname
FROM
	customer
GROUP BY
	fullname;

SELECT
	fullname
FROM
	customer
UNION
SELECT
	fullname
FROM
	customer;

-- 9
select temp.month , count(month(hop_dong.ngay_lam_hop_dong)) as so_luong, sum(hop_dong.tien_dat_coc) as tien_dat_coc from
	(SELECT 1 AS `month`
	UNION SELECT 2 AS `month`
	UNION SELECT 3 AS `month`
	UNION SELECT 4 AS `month`
	UNION SELECT 5 AS `month`
	UNION SELECT 6 AS `month`
	UNION SELECT 7 AS `month`
	UNION SELECT 8 AS `month`
	UNION SELECT 9 AS `month`
	UNION SELECT 10 AS `month`
	UNION SELECT 11 AS `month`
	UNION SELECT 12 AS `month`) AS temp
	LEFT JOIN hop_dong on month (hop_dong.ngay_lam_hop_dong) = temp.month
    left join khach_hang on khach_hang.ma_khach_hang=hop_dong.ma_khach_hang
    where year(hop_dong.ngay_lam_hop_dong) = '2019' or year(hop_dong.ngay_lam_hop_dong) is null or month(hop_dong.ngay_lam_hop_dong) is null
    group by temp.month
    order by temp.month;
-- 10
SELECT hop_dong.ma_hop_dong, hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc, hop_dong.tien_dat_coc, count(hop_dong_chi_tiet.ma_dich_vu_di_kem);
-- 11.	Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng có ten_loai_khach là “Diamond” và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.

SELECT
	cu.fullname,
	a. `name`,
	a.price,
	a.status,
	a.unit
FROM
	service se
	JOIN contract co ON co.service_id = se.id
	JOIN contract_detail cd ON cd.contract_id = co.id
	JOIN attach_service a ON a.id = cd.attach_service_id
	JOIN customer cu ON cu.id = co.customer_id
	JOIN customer_type ct ON ct.id = cu.customer_type_id
WHERE
	ct. `name` = 'Diamond'
	AND cu.address in('Vinh', 'Quang Ngai');

-- 12.	Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng), ten_dich_vu, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem), tien_dat_coc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.

SELECT
	co.id,
	ep.fullname,
	cu.fullname,
	cu.phone,
	se. `name`,
	sum(cd.attach_service_id),
	co.down_payment
FROM
	service se
	JOIN contract co ON co.service_id = se.id
	JOIN employee ep ON ep.id = co.empployee_id
	JOIN customer cu ON cu.id = co.customer_id
	JOIN contract_detail cd ON cd.contract_id = co.id
	JOIN attach_service a ON a.id = cd.attach_service_id
WHERE (co.start_date BETWEEN '2020-10-01'
	AND '2020-12-30')
and(co.start_date NOT BETWEEN '2021-01-01'
	AND '2021-06-30')
GROUP BY
	co.id
-- 13.  Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).

	-- CREATE TEMPORARY TABLE if not EXISTS tmp
	-- SELECT  a.`name`, count(cd.attach_service_id) numOfAttachServer FROM attach_service a
	-- JOIN contract_detail cd on cd.attach_service_id= a.id
	-- GROUP BY cd.attach_service_id;
	-- SELECT * from tmp;
	-- CREATE TEMPORARY TABLE if not EXISTS tmp1
	-- SELECT max(numOfAttachServer) numOfAttachServer FROM tmp;
	-- SELECT * FROM tmp1;
	-- SELECT tmp.name, tmp.numOfAttachServer FROM tmp
	-- JOIN tmp1 on tmp1.numOfAttachServer= tmp.numOfAttachServer;
	-- SELECT * FROM tmp
	-- WHERE numOfAttachServer in (select max(numOfAttachServer) from tmp);
	CREATE TABLE IF NOT EXISTS mostused AS
		SELECT
			a.name,
			a.id,
			count(
			*) AS amount
		FROM
			attach_service a
			JOIN contract_detail cd ON cd.attach_service_id = a.id
		GROUP BY
			a.name;

SELECT
	m.name,
	amount
FROM
	mostused m
WHERE
	m.amount = (
		SELECT
			max(amount)
		FROM
			mostused);

DROP TABLE mostused;

-- 14.  Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung (được tính dựa trên việc count các ma_dich_vu_di_kem).
SELECT
	co.id,
	se. `name`,
	a. `name`,
	count(cd.attach_service_id) amount
FROM
	attach_service a
	JOIN contract_detail cd ON cd.attach_service_id = a.id
	JOIN contract co ON co.id = cd.contract_id
	JOIN service se ON se.id = co.service_id
GROUP BY
	a. `name`
HAVING
	amount = 1;

-- 15.  Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.
SELECT
	ep.fullname,
	de. `name`,
	dp. `name`,
	ep.phone,
	ep.address,
	count(ep.id) amount
FROM
	employee ep
	JOIN `degree` de ON de.id = ep.degree_id
	JOIN department dp ON dp.id = ep.department_id
	JOIN contract co ON co.empployee_id = ep.id
WHERE
	YEAR(co.start_date) BETWEEN '2020'
	AND '2021'
GROUP BY
	ep.id
HAVING
	amount <= 3;

-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.
DELETE FROM employee
WHERE id NOT in(
		SELECT
			-- can't specify target table
			tmp.id FROM ( SELECT DISTINCT
					ep.id FROM employee ep
					JOIN contract co ON co.empployee_id = ep.id
				WHERE
					YEAR(co.start_date) BETWEEN 2019 AND 2021) AS tmp);

DELETE FROM employee
WHERE NOT EXISTS (
		SELECT
			*
		FROM
			contract
		WHERE
			empployee_id = employee.id
			AND YEAR(contract.start_date) BETWEEN 2019 AND 2021);




