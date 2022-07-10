package com.example.ss6_blog.controller;

import com.example.ss6_blog.model.Blog;
import com.example.ss6_blog.model.Category;
import com.example.ss6_blog.service.IBlogService;
import com.example.ss6_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-blog")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService iCategoryService;

    @ModelAttribute
    public List<Category> getList() {
        return iCategoryService.findAll();
    }

    @GetMapping(value = "")
    public ResponseEntity<Page<Blog>> goList(@PageableDefault(size = 2) Pageable pageable) {
        Page<Blog> blogs = this.blogService.findAll(pageable);
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> save(@RequestBody Blog blog) {
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/detail")
    public ResponseEntity<Blog> findById(@RequestParam int id) {
        Optional<Blog> blogOptional = blogService.findById(id);
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogOptional.get(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Blog> update(@PathVariable int id, @RequestBody Blog blog) {
        Optional<Blog> blogOptional = blogService.findById(id);
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.save(blog);
        blog.setId(blogOptional.get().getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Blog> delete(@PathVariable int id) {
        Optional<Blog> blogOptional = blogService.findById(id);
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.delete(id);
        return new ResponseEntity<>(blogOptional.get(), HttpStatus.OK);
    }
}
