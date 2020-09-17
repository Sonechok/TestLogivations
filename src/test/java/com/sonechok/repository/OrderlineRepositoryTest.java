package com.sonechok.repository;

import com.sonechok.entity.Orderline;
import com.sonechok.entity.Product;
import com.sonechok.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderlineRepositoryTest {
    @Autowired
    OrderlineRepository orderlineRepository;
    @Autowired
    ProductService productService;

    @Test
    void createOrder1(){
        Orderline orderline = new Orderline();
        orderline.getProduct().add(productService.findById(4L));
        orderline.getProduct().add(productService.findById(5L));
        orderline.getProduct().add(productService.findById(6L));
        orderline.getProduct().add(productService.findById(6L));
        orderline.getProduct().add(productService.findById(6L));

        Assertions.assertEquals(5, orderlineRepository.save(orderline).getProduct().size());
    }

    @Test
    void createOrder2(){
        Orderline orderline = new Orderline();
        orderline.getProduct().add(productService.findById(4L));
        orderline.getProduct().add(productService.findById(4L));
        orderline.getProduct().add(productService.findById(4L));
        orderline.getProduct().add(productService.findById(4L));
        orderline.getProduct().add(productService.findById(4L));

        Assertions.assertEquals(5, orderlineRepository.save(orderline).getProduct().size());
    }

    @Test
    void createOrder3(){
        Orderline orderline = new Orderline();
        orderline.getProduct().add(productService.findById(4L));
        orderline.getProduct().add(productService.findById(5L));
        orderline.getProduct().add(productService.findById(5L));
        orderline.getProduct().add(productService.findById(10L));
        orderline.getProduct().add(productService.findById(10L));

        Assertions.assertEquals(5, orderlineRepository.save(orderline).getProduct().size());
    }

}