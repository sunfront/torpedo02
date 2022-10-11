create table member
{
    id int(8) primary key,
    user_id varchar(100) unique not null,
    password varchar(200) not null,
    name varchar(200) not null,
    email varchar(100) not null,
    refresh_token varchar(255),
    role varchar(255) 
};

comment on column member.id is '사용자 번호';
comment on column member.email is '사용자 이메일';
comment on column member.name is '사용자 이름';
comment on column member.password is '사용자 비밀번호';
comment on column member.regresh_token is 'regresh_token';
comment on column member.user_id is '사용자 아이디';