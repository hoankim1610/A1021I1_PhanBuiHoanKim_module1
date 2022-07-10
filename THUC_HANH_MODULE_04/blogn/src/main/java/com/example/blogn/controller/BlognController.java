package com.example.blogn.controller;

import com.example.blogn.model.Blogn;
import com.example.blogn.model.Category;
import com.example.blogn.service.IBlognService;
import com.example.blogn.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api-blogn")
public class BlognController {

    public class BlogRestController {

        @Autowired
        private IBlognService blogService;

        @Autowired
        private ICategoryService iCategoryService;

        @ModelAttribute
        public List<Category> getList() {
            return iCategoryService.findAll();
        }

        @GetMapping(value = "")
        public ResponseEntity<Page<Blogn>> goBlogList(@PageableDefault(size = 2) Pageable pageable) {
            Page<Blogn> blogs = this.blogService.findAll(pageable);
            return new ResponseEntity<>(blogs, HttpStatus.OK);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Blogn> findById(@PathVariable int id) {
            Optional<Blogn> blognOptional = blogService.findById(id);
            if (!blognOptional.isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(blognOptional.get(), HttpStatus.OK);
        }

        @PostMapping(value = "/save")
        public ResponseEntity<?> saveBlog(@RequestBody Blogn blogn) {
            blogService.save(blogn);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Blogn> deleteCustomer(@PathVariable int id) {
            Optional<Blogn> blognOptional = blogService.findById(id);
            if (!blognOptional.isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            blogService.delete(id);
            return new ResponseEntity<>(blognOptional.get(), HttpStatus.NO_CONTENT);
        }
    }
}
