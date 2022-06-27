package com.example.blogn.service.impl;

import com.example.blogn.model.Blogn;
import com.example.blogn.repository.BlognRepository;
import com.example.blogn.service.IBlognService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlognServiceImpl implements IBlognService {
    @Autowired
    private BlognRepository blognRepository;

    @Override
    public Page<Blogn> findAll(Pageable pageable) {
        return blognRepository.findAll(pageable);
    }

    @Override
    public void save(Blogn blog) {
        blognRepository.save(blog);
    }

    @Override
    public Optional<Blogn> findById(int id) {
        return blognRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        blognRepository.deleteById(id);
    }

}
