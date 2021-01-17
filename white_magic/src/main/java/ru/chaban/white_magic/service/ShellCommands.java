package ru.chaban.white_magic.service;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.transaction.annotation.Transactional;
import ru.chaban.white_magic.domain.Author;
import ru.chaban.white_magic.domain.Genre;
import ru.chaban.white_magic.domain.MyBooks;
import ru.chaban.white_magic.domain.Opinion;
import ru.chaban.white_magic.repository.MyBooksRepository;
import ru.chaban.white_magic.repository.OpinionRepository;

import java.util.Optional;

@ShellComponent
public class ShellCommands {

    private final MyBooksRepository myBooksRepository;
    private final OpinionRepository opinionRepository;

    public ShellCommands(MyBooksRepository myBooksRepository,
                         OpinionRepository opinionRepository
    ) {
        this.myBooksRepository = myBooksRepository;
        this.opinionRepository = opinionRepository;
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
        for (MyBooks myBooks : myBooksRepository.findAll()) {
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
        Optional<MyBooks> optionalMyBooks = myBooksRepository.findById(bookId);

        if (optionalMyBooks.isPresent()) {
            MyBooks myBooks = optionalMyBooks.get();
            opinionRepository.save(new Opinion(comment, myBooks.getBook()));
            return "Ok";
        }
        return "error";
    }

    @ShellMethod(" Удалить комментарий ")
    @Transactional
    public String delcomment(long commentId) {
        Optional<Opinion> optionalOpinion = opinionRepository.findById(commentId);
        if (optionalOpinion.isPresent()) {
            Opinion opinion = optionalOpinion.get();
            opinionRepository.deleteById(opinion);
            return "Ok";
        }
        return "error";
    }

}
