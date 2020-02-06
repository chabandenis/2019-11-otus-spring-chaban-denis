insert into authors(name) values ('автор 1');
insert into authors(name) values ('автор 2');
insert into authors(name) values ('автор 3');
insert into authors(name) values ('автор 4');
insert into authors(name) values ('автор 5');

insert into books(name) values ('книга 1');
insert into books(name) values ('книга 2');
insert into books(name) values ('книга 3');
insert into books(name) values ('книга 4');
insert into books(name) values ('книга 5');

insert into genres(name) values ('жанр 1');
insert into genres(name) values ('жанр 2');
insert into genres(name) values ('жанр 3');
insert into genres(name) values ('жанр 4');
insert into genres(name) values ('жанр 5');

insert into my_books(my_book_id) values (1);
insert into my_books(my_book_id) values (2);
insert into my_books(my_book_id) values (3);

insert into book_authors(book_id, author_id) values (1, 1);
insert into book_authors(book_id, author_id) values (2, 2);
insert into book_authors(book_id, author_id) values (3, 3);
insert into book_authors(book_id, author_id) values (4, 4);
insert into book_authors(book_id, author_id) values (5, 5);

insert into book_genres(book_id, genre_id) values (1, 1);
insert into book_genres(book_id, genre_id) values (2, 2);
insert into book_genres(book_id, genre_id) values (3, 3);
insert into book_genres(book_id, genre_id) values (4, 4);
insert into book_genres(book_id, genre_id) values (5, 5);