package ru.chaban.service;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.transaction.annotation.Transactional;
import ru.chaban.domain.Genre;
import ru.chaban.repository.MyBooksRepository;
import ru.chaban.repository.OpinionRepository;
import ru.chaban.domain.Author;
import ru.chaban.domain.MyBooks;
import ru.chaban.domain.Opinion;

import java.util.List;
import java.util.Optional;

@ShellComponent
public class ShellCommands {

    private final MyBooksRepository myBooksRepository;
    private final OpinionRepository opinionRepository;
    private final OpinionService opinionService;

    public ShellCommands(MyBooksRepository myBooksRepository,
                         OpinionRepository opinionRepository,
                         OpinionService opinionService) {
        this.myBooksRepository = myBooksRepository;
        this.opinionRepository = opinionRepository;
        this.opinionService = opinionService;
    }

    @ShellMethod("Приветствие")
    public String hi() {
        return "Доброго времени суток";
    }

    @ShellMethod("мои книги")
    @Transactional
    public String mybooks() {
        StringBuilder str = new StringBuilder("");
        str.append("Книги:" + "\n");
        for (MyBooks myBooks : myBooksRepository.findAll()) {
            str.append("название книги: " + myBooks.getBook().getName() + "; (id=" + myBooks.getId() + ")\n");

            str.append("\t" + "Авторы:" + "\n");
            for (Author author : myBooks.getBook().getAuthors()) {
                str.append("\t\t" + author.getName() + "\n");
            }

            str.append("\t" + "Жанры:" + "\n");
            for (Genre genre : myBooks.getBook().getGenres()) {
                str.append("\t\t" + genre.getName() + "\n");
            }

            str.append("\t" + "Комментарии:" + "\n");
            for (Opinion opinion : myBooks.getBook().getComments()) {
                str.append("\t\t" + opinion.getComment() + "(id=" + opinion.getId() + ")\n");
            }
        }
        return str.toString();
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

    @ShellMethod(" Удалить все комментарии ")
    @Transactional
    public String dc() {
        opinionService.customDelete();
        return "Ok";
    }

    @ShellMethod(" поиск комментария ")
    @Transactional
    public String fc() {
        List<Opinion> opinions = opinionService.findByComment("%");
        StringBuilder str = new StringBuilder();
        str.append("Комментарии:" + "\n");
        for (Opinion opinion : opinions) {
            str.append("\t\t" + opinion.getComment() + "\n");
        }
        return str.toString();
    }

    @ShellMethod(" сортированные найденные комментарии ")
    @Transactional
    public String fcs() {
        List<Opinion> opinions = opinionService.findByCommentIsLikeOrderByCommentDesc("%");
        StringBuilder str = new StringBuilder();
        str.append("Комментарии:" + "\n");
        for (Opinion opinion : opinions) {
            str.append("\t\t" + opinion.getComment() + "\n");
        }
        return str.toString();
    }

}
