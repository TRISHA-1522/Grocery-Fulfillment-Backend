package com.grocery.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocery.productservice.entity.Product;
import com.grocery.productservice.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository repo;

    public Product addProduct(Product p){

        return repo.save(p);

    }

    public List<Product> getAllProducts(){

        return repo.findAll();

    }

    public Product updateProduct(Long id,Product p){

        Product product=repo.findById(id).orElse(null);

        if(product!=null){

            product.setProductName(p.getProductName());
            product.setCategory(p.getCategory());
            product.setPrice(p.getPrice());
            product.setStock(p.getStock());

            return repo.save(product);

        }

        return null;

    }

    public String deleteProduct(Long id){

        repo.deleteById(id);

        return "Product Deleted Successfully";

    }

}