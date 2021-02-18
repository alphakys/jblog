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

create table post(
    postNo      number primary key,
    cateNO      number,
    postTitle   varchar2(300) not null,
    postContent varchar2(4000),
    regDate     date not null,
    
    constraint  fk_category_cateNo foreign key(cateNo)
    references  category(cateNo) on delete cascade

);

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


select *
from users;


















