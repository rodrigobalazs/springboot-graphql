package com.rbalazs.graphql.storeapi.service;

import com.rbalazs.graphql.storeapi.enums.AppConstants;
import com.rbalazs.graphql.storeapi.model.Product;
import com.rbalazs.graphql.storeapi.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.apache.commons.collections4.CollectionUtils;

/**
 * Populates the database with sample data related to Products.
 *
 * @author Rodrigo Balazs
 */
@Service
public class PopulateSampleDataService implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(PopulateSampleDataService.class);

    @Autowired
    ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        if ( CollectionUtils.isNotEmpty(productRepository.findAll())){
            return;
        }
        LOGGER.info("populates the database with some initial sample data for Products ..");
        productRepository.save(new Product(AppConstants.PRODUCT_OFFICE_CHAIR_NAME, AppConstants.PRODUCT_OFFICE_CHAIR_PRICE));
        productRepository.save(new Product(AppConstants.PRODUCT_SOFA_NAME, AppConstants.PRODUCT_SOFA_PRICE));
    }
}