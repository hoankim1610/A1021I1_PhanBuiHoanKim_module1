package com.codegym.repository;

import com.codegym.model.Student;

import java.util.List;

public interface IStudentRepository {
    Student findById(Integer id);
    List<Student> findAll();
    void save(Student studentObj);
}
