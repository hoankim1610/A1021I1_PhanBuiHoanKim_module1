package com.codegym.service;

import com.codegym.model.Student;

import java.util.List;

public interface IStudentService {
    Student findById(Integer id);
    List<Student> findAll();
    void save(Student studentObj);
}
