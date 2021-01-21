package ru.chaban.white_magic.service;

import org.springframework.transaction.annotation.Transactional;
import ru.chaban.white_magic.domain.Book;
import ru.chaban.white_magic.repository.BookRepository;
import ru.chaban.white_magic.repository.OpinionRepository;

import java.util.ArrayList;
import java.util.List;

public class OpinionServiceCustomImpl implements OpinionServiceCustom {
    private final BookRepository bookRepository;
    private final OpinionRepository opinionRepository;

    public OpinionServiceCustomImpl(BookRepository bookRepository, OpinionRepository opinionRepository) {
        this.bookRepository = bookRepository;
        this.opinionRepository = opinionRepository;
    }

    @Override
    @Transactional
    public void customDelete() {
        List<Book> books = bookRepository.findAll();
        books.forEach(x->{x.setComments(new ArrayList<>());});
        opinionRepository.deleteAll();
        opinionRepository.flush();
    }
}
