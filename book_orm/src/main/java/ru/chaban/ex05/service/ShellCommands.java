package ru.chaban.ex05.service;

//import org.springframework.shell.standard.ShellComponent;

//@ShellComponent
public class ShellCommands {

    /*
    private final MyBooksDao myBooksDao;
    private final BookDao bookDao;
    private final AuthorDao authorDao;
    private final BookAuthorsDao bookAuthorsDao;
    private final BookGenresDao bookGenresDao;
    private final GenreDao genreDao;

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

            for (BookComments bookComments : bookGenresDao.allByBookId(genreDao.getById(myBooks.getMyBookId()).getId())) {
                str += "\t жанр: " + genreDao.getById(bookComments.getGenreId()).getName() + "\n";
            }

        }
        return str;
    }

     */
}
