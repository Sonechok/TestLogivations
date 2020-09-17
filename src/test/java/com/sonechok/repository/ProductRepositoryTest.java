package com.sonechok.repository;

import com.sonechok.entity.Case;
import com.sonechok.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {
    @Autowired
    ProductRepository productRepository;

    @Test
    void createProduct1(){
        Double sizeX = 1.0;
        Product productToInsert = new Product(sizeX, 1.0, 3.0);

        Assertions.assertEquals(sizeX, productRepository.save(productToInsert).getSizeX());
    }

    @Test
    void createProduct2(){
        Double sizeX = 1.0;
        Product productToInsert = new Product(sizeX, 2.0, 1.0);

        Assertions.assertEquals(sizeX, productRepository.save(productToInsert).getSizeX());
    }

    @Test
    void createProduct3(){
        Double sizeX = 2.0;
        Product productToInsert = new Product(sizeX, 8.0, 1.0);

        Assertions.assertEquals(sizeX, productRepository.save(productToInsert).getSizeX());
    }
}