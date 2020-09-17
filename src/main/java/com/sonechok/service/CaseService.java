package com.sonechok.service;

import com.sonechok.entity.Case;

import java.util.List;

public interface CaseService {
    List<Case> findAll();

    Case findById(Long id);

}
