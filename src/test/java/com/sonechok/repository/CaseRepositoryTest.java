package com.sonechok.repository;

import com.sonechok.entity.Case;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CaseRepositoryTest {
    @Autowired
    CaseRepository caseRepository;

    @Test
    void createCase1(){
        Double sizeX = 1.0;
        Case caseToInsert = new Case(sizeX, 3.0, 2.0);

        Assertions.assertEquals(sizeX, caseRepository.save(caseToInsert).getSizeX());
    }

    @Test
    void createCase2(){
        Double sizeX = 1.0;
        Case caseToInsert = new Case(sizeX, 4.0, 3.0);

        Assertions.assertEquals(sizeX, caseRepository.save(caseToInsert).getSizeX());
    }

    @Test
    void createCase3(){
        Double sizeX = 2.0;
        Case caseToInsert = new Case(sizeX, 4.4, 6.0);

        Assertions.assertEquals(sizeX, caseRepository.save(caseToInsert).getSizeX());
    }
}