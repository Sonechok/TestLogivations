package com.sonechok.service.impl;

import com.sonechok.entity.Case;
import com.sonechok.error.ResourceNotFoundException;
import com.sonechok.repository.CaseRepository;
import com.sonechok.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaseServiceImpl implements CaseService {
    private final CaseRepository caseRepository;

    @Autowired
    public CaseServiceImpl(CaseRepository caseRepository) {
        this.caseRepository = caseRepository;
    }

    @Override
    public List<Case> findAll() {
        return caseRepository.findAll();
    }

    @Override
    public Case findById(Long id) {
        return caseRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("id",id.toString()));
    }
}
