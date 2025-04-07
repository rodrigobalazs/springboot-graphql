package com.rbalazs.graphql.storeapi.controller;

import com.rbalazs.graphql.storeapi.model.Product;
import com.rbalazs.graphql.storeapi.service.ProductService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Controller which act as the GraphQL Resolver with a couple of Mutations/Queries associated to the
 * {@link Product} entity
 *
 * @author Rodrigo Balazs
*/
@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(final ProductService productService) {
        this.productService = productService;
    }

    @MutationMapping
    public Product addProduct(@Argument String name, @Argument Double price) {
        Product product = new Product(name, price);
        return productService.save(product);
    }

    @QueryMapping
    public List<Product> allProducts() {
        return productService.getAll();
    }

    @QueryMapping
    public Product productByName(@Argument String name) {
        return productService.getByName(name).orElse(null);
    }
}
