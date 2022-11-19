package com.example.sprint2_be.controller;

import com.example.sprint2_be.entity.book.Book;
import com.example.sprint2_be.service.IAuthorService;
import com.example.sprint2_be.service.IBookService;
import com.example.sprint2_be.service.ICategoryService;
import com.example.sprint2_be.service.IPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin
@RequestMapping("api/book")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping("/book-customer/no-login/book-list")
    public ResponseEntity<List<Book>> getAllBook() {
        List<Book> list = bookService.getAllBook();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/book-customer/no-login/book-search")
    public ResponseEntity<String[]> searchBook(@RequestParam String categoryName, @RequestParam String bookName) {
        String[] listSearch = bookService.searchBook(categoryName, bookName);
        return new ResponseEntity<>(listSearch, HttpStatus.OK);
    }
}
