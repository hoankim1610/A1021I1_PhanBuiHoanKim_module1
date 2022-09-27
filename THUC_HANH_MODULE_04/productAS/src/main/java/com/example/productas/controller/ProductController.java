package com.example.productas.controller;

import com.example.productas.model.Product;
import com.example.productas.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.dsig.keyinfo.PGPData;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("")
    public ResponseEntity<List<Product>> showList() {
        List<Product> productList = iProductService.findAll();
        if (productList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }
    }

//    **********
    @PostMapping("")
    public ResponseEntity<Product> create(@RequestBody Product product) {
        System.out.println(product);
        Product productCreate = iProductService.save(product);
        return new ResponseEntity<>(productCreate, HttpStatus.CREATED);
    }

//    *********
    @DeleteMapping("{id}")
    public ResponseEntity<Product> delete(@PathVariable("id") Integer id) {
        Optional<Product> product = iProductService.findById(id);
        if (!product.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            iProductService.delete(id);
            return new ResponseEntity<>(product.get(), HttpStatus.NO_CONTENT);
        }
    }
}
