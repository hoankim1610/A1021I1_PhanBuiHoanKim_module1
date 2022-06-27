package com.example.blogn.service;

import com.example.blogn.model.Blogn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.concurrent.BlockingDeque;

public interface IBlognService {
    Page<Blogn> findAll(Pageable pageable);

    void save(Blogn blogn);

    Optional<Blogn> findById(int id);

    void delete(int id);
}
