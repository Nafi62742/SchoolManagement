create database SchoolManagement


create table Test
(
ID int  PRIMARY KEY,
NAME varchar(50) NOT NULL,
AGE int NOT NULL,
ADDRESS varchar(200) NULL
)


create table Student
(
StudentID int primary key NOT NULL,
StudentName varchar(50) NOT NUll,
StudentAddress varchar(50) default 'Dhaka',
StudentEmail varchar(50) NULL,
Class int NOT NULL,
StudentPassword varchar(50) NOT NULL,
Section varchar(1) NOT NUll,
Fee int NULL
);



INSERT INTO Student(StudentID,StudentName,StudentAddress,StudentEmail,Class,Section,StudentPassword)
VALUES (3,'Rahim', 'Hudai', 'a@gmail.com',10,'B','MTIzNDU=');
    
select * from Student where StudentID=1and StudentPassword= 123;

UPDATE Student 
	SET StudentPassword='MTIzNDU=',StudentName ='Aziz', StudentAddress='Mirpur' , StudentEmail='aziz@gmail.com',  Class=6 ,Section='A'
	where StudentID=3

select * From Student


create table Teacher
(
TeacherID int primary key NOT NULL,
TeacherName varchar(50) NOT NUll,
TeacherAddress varchar(50) default 'Dhaka',
TeacherEmail varchar(50) NULL,
TeacherPassword varchar(50) NOT NULL,
SubjectName varchar(50) NOT NULL,
Designation varchar(50) NOT NUll,
Salary int NULL
);

INSERT INTO Teacher(TeacherID,TeacherName,TeacherAddress,TeacherEmail,SubjectName,Designation,TeacherPassword)
VALUES (3,'Rahim', 'Hudai', 'a@gmail.com',10,'B','1234');
    
select * from Teacher where TeacherID=1and TeacherPassword= 123;

UPDATE Teacher 
	SET TeacherPassword='MTIzNDU=',
		TeacherName ='Aziz',
		TeacherAddress='Mirpur' ,
		TeacherEmail='aziz@gmail.com', 
		Designation='6' ,
		SubjectName='A'
	where TeacherID=3

select * From Teacher

create table LoginInfo
(
ID varchar(50) NOT NULL,
IpAddress varchar(50) NOT NUll,
LoginSatus int default 0
);


INSERT INTO LoginInfo(ID,IpAddress,LoginSatus)
VALUES ('100.3','Rahim', 0);

Delete from LoginInfo where ID='100' and LoginSatus= 1;

select * From LoginInfo

create table Attendance(
	MonthNo int primary key NOT NULL,
	TeacherID int foreign key REFERENCES Teacher (TeacherID),
	StudentID int foreign key REFERENCES Student (StudentID),
	WorkingDays int NOT NULL,
	AbsentDays int NOT NUll
);
create table Class(
	Class int primary key NOT NULL,
	TeacherID int foreign key REFERENCES Teacher (TeacherID),
	Section int  NOT NULL CHECK (Section <= 3),
	StudentID int foreign key REFERENCES Student (StudentID)
);
create table Subject(
	SubjectID int primary key NOT NULL,
	Class int foreign key REFERENCES Class (Class),
	TeacherID int foreign key REFERENCES Teacher (TeacherID),
	SubjectName varchar(50) NOT NUll
);

--create table Section(
--	Section int primary key NOT NULL CHECK (Section <= 3),
--	Class int foreign key REFERENCES Class (Class)
--);

INSERT INTO Student(StudentID,StudentName,StudentAddress,StudentEmail,Class,Section,StudentPassword)
VALUES (3,'Rahim', 'Hudai', 'a@gmail.com',10,'B','1234');
    
select * from Student where StudentID=1and StudentPassword= 123;


select * From Student

Drop Table Student