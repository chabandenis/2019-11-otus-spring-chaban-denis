package ru.chaban.service;

import ru.chaban.repository.BookRepository;
import ru.chaban.repository.OpinionRepository;

public class OpinionServiceCustomImpl implements OpinionServiceCustom {
/*    private final BookRepository bookRepository;
    private final OpinionRepository opinionRepository;

    public OpinionServiceCustomImpl(BookRepository bookRepository, OpinionRepository opinionRepository) {
        this.bookRepository = bookRepository;
        this.opinionRepository = opinionRepository;
    }

    @Override
    public void customDelete() {
*//*        List<Book> books = bookRepository.findAll();
        books.forEach(x->{x.setComments(new ArrayList<>());});
        opinionRepository.deleteAll();
        opinionRepository.flush();*//*
    }*/
}
