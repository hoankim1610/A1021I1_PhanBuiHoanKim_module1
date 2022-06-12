package com.example.ss6_blog.service;

import com.example.ss6_blog.model.Blog;
import com.example.ss6_blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IBlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public Optional<Blog> findById(int id) {
        return iBlogRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        iBlogRepository.deleteById(id);
    }

//    @Override
//    public void update(int id) {
//        iBlogRepository.;
//    }

}
