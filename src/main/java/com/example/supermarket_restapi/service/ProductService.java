package com.example.supermarket_restapi.service;

import com.example.supermarket_restapi.entity.Product;
import com.example.supermarket_restapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }
    public Optional<Product> findProductById(Long id){
        return productRepository.findById(id);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
    public double calculateTotalAmount(Long id){
        Optional<Product> product = findProductById(id);
        return product.map(p -> p.getQuantity() * p.getUnit_price()).orElse(0.0);
    }
    public Product repairProduct(Long id, Product updateProduct){
        if (productRepository.existsById(id)){
            updateProduct.setId(id);
            return productRepository.save(updateProduct);
        }
        return null;
    }
}
