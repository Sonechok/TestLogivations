package com.sonechok.algorithm;

import com.sonechok.entity.Case;
import com.sonechok.entity.Orderline;
import com.sonechok.entity.Product;
import com.sonechok.service.CaseService;
import com.sonechok.service.OrderlineService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductsPackagingAlgorithmTest {
    @Autowired
    ProductPackagingAlgorithmInterface productPackagingAlgorithm;
    @Autowired
    OrderlineService orderlineService;
    @Autowired
    CaseService caseService;

    @Test
    void solve1(){
        Case correct = caseService.findById(8L);
        Orderline myOrder = orderlineService.findById(9L);
        Case res = productPackagingAlgorithm.findOptimalCase(myOrder);
        Assertions.assertEquals(correct.getId(), res.getId());
    }

    @Test
    void solve2(){
        Case correct = caseService.findById(2L);
        Orderline myOrder = orderlineService.findById(11L);
        Case res = productPackagingAlgorithm.findOptimalCase(myOrder);
        Assertions.assertEquals(correct.getId(), res.getId());
    }
}