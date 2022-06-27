package com.example.blogn.repository;

import com.example.blogn.model.Blogn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlognRepository extends JpaRepository<Blogn, Integer> {

}
