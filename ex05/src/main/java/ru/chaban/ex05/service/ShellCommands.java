package ru.chaban.ex05.service;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.chaban.ex05.dao.*;
import ru.chaban.ex05.domain.BookAuthors;
import ru.chaban.ex05.domain.BookGenres;
import ru.chaban.ex05.domain.MyBooks;

@ShellComponent
public class ShellCommands {

    MyBooksDao myBooksDao;
    BookDao bookDao;
    AuthorDao authorDao;
    BookAuthorsDao bookAuthorsDao;
    BookGenresDao bookGenresDao;
    GenreDao genreDao;

    public ShellCommands(MyBooksDao myBooksDao,
                         BookDao bookDao,
                         AuthorDao authorDao,
                         BookAuthorsDao bookAuthorsDao,
                         BookGenresDao bookGenresDao,
                         GenreDao genreDao) {
        this.myBooksDao = myBooksDao;
        this.bookDao = bookDao;
        this.authorDao = authorDao;
        this.bookAuthorsDao = bookAuthorsDao;
        this.bookGenresDao = bookGenresDao;
        this.genreDao = genreDao;
    }

    @ShellMethod("Приветствие")
    public String hi() {
        return "Доброго времени суток";
    }

    @ShellMethod("мои книги")
    public String mybooks() {
        String str = "";
        for (MyBooks myBooks : myBooksDao.getAll()) {
            str += "название книги: " + bookDao.getById(myBooks.getMyBookId()).getName() + "\n";

            for (BookAuthors author : bookAuthorsDao.allByBookId(bookDao.getById(myBooks.getMyBookId()).getId())) {
                str += "\t автор: " + authorDao.getById(author.getAuthorId()).getName() + "\n";
            }

            for (BookGenres bookGenres : bookGenresDao.allByBookId(genreDao.getById(myBooks.getMyBookId()).getId())){
                str += "\t жанр: " + genreDao.getById(bookGenres.getGenreId()).getName() + "\n";
            }

        }
        return str;
    }
}
