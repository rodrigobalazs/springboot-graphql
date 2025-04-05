package com.rbalazs.graphql.storeapi.service;

import com.rbalazs.graphql.storeapi.model.Product;
import com.rbalazs.graphql.storeapi.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Product Service.
 */
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Optional<Product> getByName(String name) {
        return productRepository.findByName(name);
    }
}