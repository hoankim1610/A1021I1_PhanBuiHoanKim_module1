package com.example.ss6_blog.repository;

import com.example.ss6_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {

    @Query(value ="SELECT * FROM blog where title like :nameSearch and category_id like :category",
            countQuery="SELECT * FROM blog where title like :nameSearch and category_id like :category",
            nativeQuery =true)
    Page<Blog> findBySearch(@Param("nameSearch") String nameSearch, @Param("category") String categorySearch, Pageable pageable);
}

