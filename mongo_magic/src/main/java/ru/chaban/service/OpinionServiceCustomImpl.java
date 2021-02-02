package ru.chaban.service;

import ru.chaban.domain.Book;
import ru.chaban.repository.OpinionRepository;
import ru.chaban.repository.BookRepository;

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
    public void customDelete() {
        List<Book> books = bookRepository.findAll();
        books.forEach(x->{x.setComments(new ArrayList<>());});
        opinionRepository.deleteAll();
        opinionRepository.flush();
    }
}
