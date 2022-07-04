drop table if exists t_user, t_blog;

create table t_user
(
    id              serial primary key,
    username        varchar(64) unique not null,
    pwd             varchar(100)       not null,
    avatar          varchar(255) default null,
    email           varchar(64)  default null,
    status          integer            not null,
    created_time     date               not null,
    last_login_time date     default null
);

create table t_blog(
  id serial primary key ,
  user_id integer not null ,
  title varchar(255) not null ,
  description varchar(255) not null ,
  content text,
  created_time date not null ,
  status integer not null ,
  visited_num integer
);
