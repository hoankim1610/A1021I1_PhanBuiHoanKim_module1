create database QuanLiSinhVien;

use QuanliSinhVien;

CREATE TABLE Class
(
    ClassID   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ClassName VARCHAR(60) NOT NULL,
    StartDate DATETIME    NOT NULL,
    `Status`    BIT
);
CREATE TABLE Student (
    StudentId   INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    StudentName VARCHAR(30) NOT NULL,
    Address     VARCHAR(50),
    Phone       VARCHAR(20),
    `Status`    BIT,
    ClassId     INT NOT NULL,
    FOREIGN KEY (ClassId) REFERENCES Class (ClassID)
);

CREATE TABLE `Subject` (
    SubId   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    SubName VARCHAR(30) NOT NULL,
    Credit  TINYINT     NOT NULL DEFAULT 1 CHECK ( Credit >= 1 ),
    `Status`  BIT                  DEFAULT 1
);

CREATE TABLE Mark (
    MarkId    INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    SubId     INT NOT NULL,
    StudentId INT NOT NULL,
    Mark      FLOAT   DEFAULT 0 CHECK ( Mark BETWEEN 0 AND 100),
    ExamTimes TINYINT DEFAULT 1,
    FOREIGN KEY (SubId) REFERENCES `Subject` (SubId),
    FOREIGN KEY (StudentId) REFERENCES Student (StudentId)
);

use QuanLiSinhVien;

INSERT INTO Class VALUES (1, 'A1', '2008-12-20', 1);
INSERT INTO Class VALUES (2, 'A2', '2008-12-22', 1);
INSERT INTO Class VALUES (3, 'B3', current_date, 0);

INSERT INTO Student (StudentName, Address, Phone, Status, ClassId) VALUES ('Hung', 'Ha Noi', '0912113113', 1, 1);
INSERT INTO Student (StudentName, Address, Status, ClassId) VALUES ('Hoa', 'Hai phong', 1, 1);
INSERT INTO Student (StudentName, Address, Phone, Status, ClassId) VALUES ('Manh', 'HCM', '0123123123', 0, 2);

INSERT INTO Subject 
VALUES (5, 'CF', 5, 1),
       (6, 'C', 6, 1),
       (7, 'HDJ', 5, 1),
       (8, 'RDBMS', 10, 1);

INSERT INTO Mark (SubId, StudentId, Mark, ExamTimes)
VALUES (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 12, 1);

SELECT * FROM Student WHERE StudentName like 'h%';

SELECT * FROM Class where StartDate;

SELECT * FROM `Subject` WHERE Credit between 3 AND 5;

UPDATE Student SET ClassId = 2 WHERE StudentName = 'Hung';
