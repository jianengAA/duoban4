
create database duoban4;

drop table book;
create table book(
	bid int primary key auto_increment,
	bname varchar(500),
	isbn int,
	author varchar(100),
	price double,
	tid int,
	
	pdfs varchar(5000),
	
	description varchar(5000)
	
)


create table category(
	tid int primary key auto_increment,
	name varchar(500)
)


create table bookrank(
	rid int primary key auto_increment,
	ip varchar(500),
	bid int,
	scores int
)
insert into bookrank (ip,bid,scores) values('192.168.14.18',1,9);

--   ALTER TABLE book DROP FOREIGN KEY pf_bookrank_book;
alter table book
add constraint pf_category_book1
foreign key(tid) references category(tid);

--UPDATE persondata SET age=age*2, age=age+1;
update category  set name='算法' where tid=4;

insert into category(name) values('数学');
insert into category(name) values('java');
insert into category(name) values('PHP');
insert into category(name) values('PHP');



select * from book;
select * from category;
select * from bookrank;

