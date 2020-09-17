package com.sonechok.service.impl;

import com.sonechok.entity.Product;
import com.sonechok.error.ResourceNotFoundException;
import com.sonechok.repository.ProductRepository;
import com.sonechok.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("id",id.toString()));
    }
}
