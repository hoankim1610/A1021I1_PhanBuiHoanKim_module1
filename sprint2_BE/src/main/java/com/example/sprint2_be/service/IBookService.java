package com.example.sprint2_be.service;

import com.example.sprint2_be.entity.book.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBookService {
    List<Book> getAllBook();

    String[] searchBook(String categoryName, String bookName);

}
