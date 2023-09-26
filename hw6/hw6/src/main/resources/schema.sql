drop table if exists genres;
create table genres
(
    id   BIGINT auto_increment primary key,
    name varchar(255)
);

drop table if exists authors;
create table authors
(
    id   BIGINT auto_increment primary key,
    first_name varchar(255),
    last_name varchar(255)
);

drop table if exists books;
create table books
(
    id        BIGINT auto_increment primary key,
    title      varchar(255),
    author_id BIGINT,
    genre_id BIGINT,
    foreign key (author_id) references authors(id),
    foreign key (genre_id) references genres(id)
);

drop table if exists comments;
create table comments
(
    id        BIGINT auto_increment primary key,
    text    varchar(255),
    book_id long
)