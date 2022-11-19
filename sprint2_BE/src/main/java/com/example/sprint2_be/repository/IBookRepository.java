package com.example.sprint2_be.repository;

import com.example.sprint2_be.entity.book.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IBookRepository extends JpaRepository<Book, Long> {
    @Query(value = "select * from book b join author on author.author_id = b.book_author_id", nativeQuery = true)
    List<Book> getAllBook();

    @Query(value = "select * from `book`\n" +
            "join `author` on author.author_id = `book`.book_author_id\n" +
            "join category on category.category_id = `book`.book_category_id\n" +
            "where category_name = :categoryName or book_name = :bookName\n" +
            "order by `book`.book_publish_date asc;", nativeQuery = true)
    String[] searchBook(@Param("categoryName") String categoryName,
                        @Param("bookName") String bookName);
}
