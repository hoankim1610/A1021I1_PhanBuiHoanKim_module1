package com.codegym.service.impl;

import com.codegym.model.Student;
import com.codegym.repository.IStudentRepository;
import com.codegym.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private IStudentRepository iStudentRepository;

    @Override
    public Student findById(Integer id) {
        return this.iStudentRepository.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return this.iStudentRepository.findAll();
    }

    @Override
    public void save(Student studentObj) {
        this.iStudentRepository.save(studentObj);
    }
}
