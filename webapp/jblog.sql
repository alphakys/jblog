--테이블 생성
create table users(
    
    userNo      number  primary key,
    id          varchar2(50) not null unique,
    userName    varchar2(100) not null,
    password    varchar2(50) not null,
    joinDate    date     not null

);

create table blog(

    id      varchar2(50) primary key,
    blogTitle   varchar2(200) not null,
    logoFile    varchar2(200),
    
    constraint  fk_users_id foreign key(id)
    references  users(id) on delete cascade
);


create table category(
    cateNo      number primary key,
    id          varchar2(50),
    cateName    varchar2(200) not null,
    description varchar2(500),
    regDate     date not null,

    constraint fk_blog_id foreign key(id)
    references blog(id) on delete cascade

);

--insert
insert into category
values(seq_category_no.nextval, 'gys6', 'c언어', 'c언어 어렵겠지만 해볼만 할듯!', sysdate);

insert into category
values(seq_category_no.nextval, 'gys6', '자바', '자바언어 어렵겠지만 ', sysdate);

insert into category
values(seq_category_no.nextval, 'gys6', '파이선', '배워야지', sysdate);

insert into category
values(seq_category_no.nextval, 'gys6', 'c++', '왠지 안땡김', sysdate);


create table post(
    postNo      number primary key,
    cateNO      number,
    postTitle   varchar2(300) not null,
    postContent varchar2(4000),
    regDate     date not null,
    
    constraint  fk_category_cateNo foreign key(cateNo)
    references  category(cateNo) on delete cascade

);
update post
set    postTitle = ''
where  postNo = '8';

--insert
insert into post
values(seq_post_no.nextval, '32', 'c++ 난이도는 얼마나일까?', '왠지 안땡김 그냥 안땡김 ㅇㅇ', sysdate);

insert into post
values(seq_post_no.nextval, '32', 'c++ 재미는?', '123왠지 안땡김 그냥 안땡김 ㅇㅇ', sysdate);

insert into post
values(seq_post_no.nextval, '32', 'c++ 활용도는?', '456왠지 안땡김 그냥 안땡김 ㅇㅇ', sysdate);


insert into post
values(seq_post_no.nextval, '32', 'c++ 재미는 우하하하?', '123왠지 안땡김 그냥 우우우우웅땡김 ㅇㅇ', sysdate);

insert into post
values(seq_post_no.nextval, '32', 'c++ 활용도는 쿠카카카?', '456왠지 안땡김 우우우카카카그냥 안땡김 ㅇㅇ', sysdate);


create table comments(
    cmtNo   number primary key,
    postNo  number,
    userNo  number,
    cmtContent  varchar2(1000) not null,
    regDate     date not null,
    
    constraint  fk_post_postNo foreign key(postNo)
    references  post(postNo) on delete cascade,
    
    constraint fk_users_userNo foreign key(userNo)
    references users(userNo) on delete cascade
);

--시퀀스
create sequence seq_users_no
start with 1
increment by 1
nocache;

create sequence seq_category_no
start with 1
increment by 1
nocache;

create sequence seq_post_no
start with 1
increment by 1
nocache;

create sequence seq_comments_no
start with 1
increment by 1
nocache;


--main에 뿌려줄 data --> mainDTO에 담음
select u.id,
       userName,
       blogTitle,
       logoFile,
       c.cateNo,
       catename,
       postNo,
       postTitle,
       postContent,    
       p.regDate
from users u, blog b, category c, post p
where u.id = b.id and c.id = u.id --and c.cateno = p.cateno
and u.id = 'gys6' and c.cateNo = (select max(cateNo) from category where id = 'gys6')
and postNo = (select max(postNo) from post p, category c 
where (select max(cateNo) from category where id = 'gys6') = p.cateNo)
;


--카테고리 리스트 쿼리
select		cateName
from		category			
where   	id = 'gys1025'
order by 	cateNo desc;


-- main에 뿌려줄 가장 상위 카테고리의 글 리스트
select  postNo,
        postTitle,
        regDate
        
from post
where cateNo = (select max(cateNo) from category where id = 'gys6');


select  postNo,
        postTitle,
        p.regDate,
        c.cateNo
        
from post p, category c
where id = 'gys6' and c.cateno = '32'
and c.cateNo = p.cateNO;


--카테코리 info에 뿌려줄 정보
select      cateNo,
            cateName,
            description        
from category
where id = 'gys6'; 


select		userName,
            blogTitle,
            logoFile
			
from 		blog b, users u
where		b.id = 'gys6' and b.id = u.id;




select count(postNo)
from post
where cateNo = '32';




select  postNo,
        postTitle,
        p.regDate
        
from post p
where p.cateNo in (select cateNo from category where id = 'gys6');






select max(cateNo)
from category
where id = 'gys1120';




select  b.id,
        userName,
        blogTitle,
        logoFile,
        c.cateNo,
        c.catename,
        p.postno,
        p.posttitle,
        p.postcontent
from users u, blog b, category c, post p
where b.id = 'gys6' and b.id = u.id
and c.id = b.id and c.cateno = p.cateno
order by c.cateNo desc;



select *
from users
where id = 'gys6';

select *
from blog
where id = 'gys6';

select *
from category
where id = 'gys6';

select count(postNo)
from post
where cateNo = '32';

select *
from post;

select *
from category;



		select		postTitle,
						postContent
		
			from		post
			where		postNo = '12';




