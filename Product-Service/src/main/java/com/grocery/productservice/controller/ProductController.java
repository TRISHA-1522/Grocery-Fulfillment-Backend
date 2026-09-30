package com.grocery.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.grocery.productservice.entity.Product;
import com.grocery.productservice.service.ProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:5176")
public class ProductController {

    @Autowired
    ProductService service;

    @PostMapping
    public Product add(@RequestBody Product p){
        return service.addProduct(p);
    }

    @GetMapping
    public List<Product> getAll(){
        return service.getAllProducts();
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product p){
        return service.updateProduct(id, p);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return service.deleteProduct(id);
    }
}