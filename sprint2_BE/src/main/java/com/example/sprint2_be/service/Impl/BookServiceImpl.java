package com.example.sprint2_be.service.Impl;

import com.example.sprint2_be.entity.book.Book;
import com.example.sprint2_be.repository.IBookRepository;
import com.example.sprint2_be.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<Book> getAllBook() {
        return bookRepository.getAllBook();
    }

    @Override
    public String[] searchBook(String categoryName, String bookName) {
        System.out.println(1);
        System.out.println(categoryName);
        return bookRepository.searchBook(categoryName, bookName);
    }

//    @Override
//    public String[] findBookByName(String bookName) {
//        return bookRepository.findBookByName(bookName);
//    }
//
//    @Override
//    public String[] findBookByCategory(String categoryName) {
//        return bookRepository.findBookByCategory(categoryName);
//    }
//
//    @Override
//    public String[] findBookByAuthor(String authorName) {
//        return bookRepository.findBookByAuthor(authorName);
//    }

}
