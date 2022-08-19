package com.example.beforeexam.repository;

import com.example.beforeexam.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(value ="SELECT * FROM student where `name` like :nameSearch",
            countQuery="SELECT * FROM student where `name` like :nameSearch",
            nativeQuery =true)
    Page<Student> findBySearch(@Param("nameSearch") String nameSearch, Pageable pageable);
}

