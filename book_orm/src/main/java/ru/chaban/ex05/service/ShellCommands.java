package ru.chaban.ex05.service;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.transaction.annotation.Transactional;
import ru.chaban.ex05.domain.Author;
import ru.chaban.ex05.domain.Genre;
import ru.chaban.ex05.domain.MyBooks;
import ru.chaban.ex05.domain.Opinion;
import ru.chaban.ex05.repository.MyBooksRepositoryJpa;
import ru.chaban.ex05.repository.OpinionRepositoryJpa;

@ShellComponent

public class ShellCommands {

    private final MyBooksRepositoryJpa myBooksRepositoryJpa;
    private final OpinionRepositoryJpa opinionRepositoryJpa;
    private final MyBooksService myBooksService;

   public ShellCommands(MyBooksRepositoryJpa myBooksRepositoryJpa,
                        OpinionRepositoryJpa opinionRepositoryJpa,
                        MyBooksService myBooksService
   ) {
        this.myBooksRepositoryJpa = myBooksRepositoryJpa;
        this.opinionRepositoryJpa = opinionRepositoryJpa;
        this.myBooksService = myBooksService;
    }

    @ShellMethod("Приветствие")
    public String hi() {
        return "Доброго времени суток";
    }

    @ShellMethod("мои книги")
    @Transactional
    public String mybooks() {
        String str = "";
        str += "Книги:" + "\n";
        for (MyBooks myBooks : myBooksService.findAll()) {
            str += "название книги: " + myBooks.getBook().getName() + "; (id=" + myBooks.getId() + ")\n";

            str += "\t" + "Авторы:" + "\n";
            for (Author author : myBooks.getBook().getAuthors()) {
                str += "\t\t" + author.getName() + "\n";
            }

            str += "\t" + "Жанры:" + "\n";
            for (Genre genre : myBooks.getBook().getGenres()) {
                str += "\t\t" + genre.getName() + "\n";
            }

            str += "\t" + "Комментарии:" + "\n";
            for (Opinion opinion : myBooks.getBook().getComments()) {
                str += "\t\t" + opinion.getComment() + "(id=" + opinion.getId() + ")\n";
            }

        }
        return str;
    }

    @ShellMethod("Добавить комментарий ")
    @Transactional
    public String addcomment(long bookId, String comment) {
        System.out.println("bookId " + bookId);
        System.out.println("comment " + comment);
        MyBooks myBooks = myBooksRepositoryJpa.findById(bookId).get();
        opinionRepositoryJpa.save(new Opinion(comment, myBooks.getBook()));
        return "Ok";
    }

    @ShellMethod(" Удалить комментарий ")
    @Transactional
    public String delcomment(long commentId) {

        Opinion opinion = opinionRepositoryJpa.findById(commentId).get();
        opinionRepositoryJpa.deleteById(opinion);
        return "Ok";
    }

}
