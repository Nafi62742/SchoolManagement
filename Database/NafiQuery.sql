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
StudentPhoneNo varchar NULL
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
TeacherPhoneNo varchar(50) NULL
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
	MonthNo int NOT NULL,
	TeacherID int foreign key REFERENCES Teacher (TeacherID),
	StudentID int foreign key REFERENCES Student (StudentID),
	WorkingDays int NOT NULL,
	PresentDays int NOT NUll
);

Select Sum(WorkingDays) as 'Total Working Days',Count(StudentID) as 'Total Months' 
From Attendance Group by StudentID Having StudentID=1

select * from Attendance

INSERT INTO Attendance(MonthNo,TeacherID,StudentID,WorkingDays,PresentDays)
VALUES (1,1, 1,25,20);

--drop table Attendance


create table Class(
	Class int primary key NOT NULL,
	
	Section varchar(1) not Null,
	StudentID int foreign key REFERENCES Student (StudentID)
);



create table Subject(
	SubjectID int primary key NOT NULL,
	Class int foreign key REFERENCES Class (Class),
	TeacherID int foreign key REFERENCES Teacher (TeacherID),
	SubjectName varchar(50) NOT NUll
);
Drop Table Subject
--create table Section(
--	Section int primary key NOT NULL CHECK (Section <= 3),
--	Class int foreign key REFERENCES Class (Class)
--);

create table Notice(
	Datee varchar(20),
	TeacherID int foreign key REFERENCES Teacher (TeacherID),
	Class int ,
	Notice varchar(1000) NOT NULL

);

select * from Class
INSERT INTO Student(StudentID,StudentName,StudentAddress,StudentEmail,Class,Section,StudentPassword)
VALUES (3,'Rahim', 'Dhaka', 'a@gmail.com',10,'B','1234');
    
select * from Student where StudentID=1and StudentPassword= 123;

select * From Student
select * From Teacher
select * From Notice

--Drop Table Student

INSERT INTO Class(Class,TeacherID,Section,StudentID)
VALUES(7,1,'a',1);

INSERT INTO Notice(Datee,TeacherID, Class, Notice)
VALUES('3.10.2021',17,7,'asd asd adasda ffhhj jhkh ');

select * From Class
select * From Notice
select * from Notice where Class=7
--Drop Table Notice


Create Table Message(
    StudentID int foreign key REFERENCES Student (StudentID),
    TeacherID int foreign key REFERENCES Teacher (TeacherID),
    MessageText varchar(1000) not null

);
Create Table Result(
    StudentID int foreign key REFERENCES Student(StudentID),
    bangla1st int null,
	bangla2nd int null,
	english1st int null,
	english2nd int null,
	math int null,
	science int null,
	religion int null,
	bgs int null,
	ict int null
);
Select * From Result



INSERT INTO Attendance(MonthNo,TeacherID,StudentID,WorkingDays,PresentDays)
VALUES (1,1, 1,25,20);

SELECT 
	*
FROM 
	Student 
WHERE 
	StudentID IN (SELECT StudentID 
	FROM Result 
	WHERE   bangla1st<=80 or bangla2nd<=50 )

SELECT StudentID,
	(bangla1st + bangla2nd+english1st+english2nd) as AddedValues
FROM Result


SELECT  *, (bangla1st + bangla2nd+english1st+english2nd+math+science+religion+bgs+ict) as 'Total Marks'
FROM    Result  Where StudentID=1

SELECT 
	Postcode 
FROM 
	branch 
WHERE 
	BranchNo IN (SELECT BranchNo 
	FROM Staff 
	WHERE   DateOfBirth>='1980-01-01')


INSERT INTO Result(StudentID,bangla1st)
VALUES (1,50);


update Result set bangla1st = 100 where StudentID = 1;


select * From Result Where StudentID = 1;

INSERT INTO Result(StudentID,bangla1st)
VALUES (3,2);
-- drop table Result



create table homework(
	homeworkNo int IDENTITY(1,1) PRIMARY KEY,
	Class int not null foreign key REFERENCES Class (Class),
	TeacherID int not null foreign key REFERENCES Teacher (TeacherID),
	sec varchar(1) NOT NULL,
	totalMark int NOT NULL ,
	dueDate Date NULL,
	work varchar(1000)  NOT NUll
);
--find the teacher who gave the homework

select * from Teacher ia where exists (select 1 from homework id where TeacherID='1' and id.TeacherID=ia.TeacherID)



select * from homework ia join Teacher id on ia.TeacherID=id.TeacherID where ia.TeacherID='1' 


select t.Teachername , i.homeworkNo, i.class, i.TeacherID , i.sec,i.totalMark, i.dueDate,i.work from
Teacher t join homework i on t.TeacherID=i.TeacherID where i.class='1' order by totalMark

INSERT INTO homework(Class,TeacherID,sec,totalMark,dueDate,work) values(7,1,'a',45,'12/17/2024','fgfg')


select * from homework 
--drop table homework
select * from homework where Class=4

drop table Class
