insert into authors(id, name) values (1, 'автор 1');
insert into authors(id, name) values (2, 'автор 2');
insert into authors(id, name) values (3, 'автор 3');
insert into authors(id, name) values (4, 'автор 4');
insert into authors(id, name) values (5, 'автор 5');

insert into books(id, name) values (1, 'книга 1');
insert into books(id, name) values (2, 'книга 2');
insert into books(id, name) values (3, 'книга 3');
insert into books(id, name) values (4, 'книга 4');
insert into books(id, name) values (5, 'книга 5');

insert into genres(id, name) values (1, 'жанр 1');
insert into genres(id, name) values (2, 'жанр 2');
insert into genres(id, name) values (3, 'жанр 3');
insert into genres(id, name) values (4, 'жанр 4');
insert into genres(id, name) values (5, 'жанр 5');

insert into my_books (my_book_id) values (1);
insert into my_books (my_book_id) values (2);
insert into my_books (my_book_id) values (3);

insert into book_authors (book_id, author_id) values (1, 1);
insert into book_authors (book_id, author_id) values (2, 2);
insert into book_authors (book_id, author_id) values (3, 3);
insert into book_authors (book_id, author_id) values (4, 4);
insert into book_authors (book_id, author_id) values (5, 5);

insert into book_genres (book_id, genre_id) values (1, 1);
insert into book_genres (book_id, genre_id) values (2, 2);
insert into book_genres (book_id, genre_id) values (3, 3);
insert into book_genres (book_id, genre_id) values (4, 4);
insert into book_genres (book_id, genre_id) values (5, 5);