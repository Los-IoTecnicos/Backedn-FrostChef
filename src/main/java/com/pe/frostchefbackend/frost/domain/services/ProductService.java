package com.pe.frostchefbackend.frost.domain.services;

import com.pe.frostchefbackend.frost.domain.model.entities.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
    List<Product> getAllProducts();
    Product getProductById(Long id);
}

