package com.example.beforeexam.service.impl;

import com.example.beforeexam.model.Instructor;
import com.example.beforeexam.repository.InstructorRepository;
import com.example.beforeexam.service.IInstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl implements IInstructorService {

    @Autowired
    InstructorRepository instructorRepository;
    @Override
    public List<Instructor> findAll() {
        return instructorRepository.findAll();
    }
}
