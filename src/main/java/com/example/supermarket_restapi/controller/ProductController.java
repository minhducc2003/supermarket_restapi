package com.example.supermarket_restapi.controller;

import com.example.supermarket_restapi.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.supermarket_restapi.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product/")
public class ProductController {

    @Autowired
    private ProductService productService;

    //add product
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }
    //find add
    @GetMapping
    public List<Product> findAllProducts(){
        return productService.findAllProducts();
    }
    //find by id
    @GetMapping("/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Long id){
        return productService.findProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    //delete by id
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }

    //calculate Total amount
    @GetMapping("{id}/total")
    public double calculateTotalAmount(@PathVariable Long id){
        return productService.calculateTotalAmount(id);
    }
    //update product
    @PutMapping("{id}")
    public ResponseEntity<Product> repairProduct(@PathVariable Long id, @RequestBody Product updateProduct){
        Product product =  productService.repairProduct(id,updateProduct);
        return product != null ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
    }
}
