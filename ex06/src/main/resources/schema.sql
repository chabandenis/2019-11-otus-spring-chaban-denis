DROP TABLE IF EXISTS authors;
CREATE TABLE authors(
  ID   BIGSERIAL PRIMARY KEY,
  NAME VARCHAR(255));

DROP TABLE IF EXISTS book_authors;
CREATE TABLE book_authors(
  ID        BIGSERIAL PRIMARY KEY,
  book_id   bigint,
  author_id bigint);

DROP TABLE IF EXISTS books;
CREATE TABLE books(
  ID   BIGSERIAL PRIMARY KEY,
  NAME VARCHAR(255));

DROP TABLE IF EXISTS book_genres;
CREATE TABLE book_genres(
  ID       BIGSERIAL PRIMARY KEY,
  book_Id  bigint,
  genre_Id bigint);

DROP TABLE IF EXISTS genres;
CREATE TABLE genres(
  ID   BIGSERIAL PRIMARY KEY,
  NAME VARCHAR(255));

DROP TABLE IF EXISTS my_books;
CREATE TABLE my_books(
  id         BIGSERIAL PRIMARY KEY,
  my_book_id bigint);