package com.example.beforeexam.service.impl;

import com.example.beforeexam.model.Student;
import com.example.beforeexam.repository.StudentRepository;
import com.example.beforeexam.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public Page<Student> findAll(Pageable pageable, String nameSearch) {
        return studentRepository.findBySearch("%" + nameSearch + "%", pageable);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Optional<Student> findById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        studentRepository.deleteById(id);
    }

}
