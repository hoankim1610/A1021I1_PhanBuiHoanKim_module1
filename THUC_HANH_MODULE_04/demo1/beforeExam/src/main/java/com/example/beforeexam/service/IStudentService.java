package com.example.beforeexam.service;

import com.example.beforeexam.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IStudentService {

    Page<Student> findAll(Pageable pageable);

    Page<Student> findAll(Pageable pageable, String nameSearch);

    void save(Student blog);

    Optional<Student> findById(int id);

    void delete(int id);
}
