insert into genres (name)
values ('Сказки'),
       ('Стихи'),
       ('Техническое')
;
insert into authors (first_name, last_name)
values ('Александр','Пушкин'),
       ('Роберт','Мартин')
;
insert into books (title, author_id, genre_id)
values ('Сказка о царе Салтане', 1, 1),
       ('Медный всадник', 1, 2),
       ('Чистый код', 2, 3)
;