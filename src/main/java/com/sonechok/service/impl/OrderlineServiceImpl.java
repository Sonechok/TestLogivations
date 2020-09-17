package com.sonechok.service.impl;

import com.sonechok.entity.Orderline;
import com.sonechok.error.ResourceNotFoundException;
import com.sonechok.repository.OrderlineRepository;
import com.sonechok.service.OrderlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderlineServiceImpl implements OrderlineService {
    private final  OrderlineRepository orderlineRepository;

    @Autowired
    public OrderlineServiceImpl(OrderlineRepository orderlineRepository) {
        this.orderlineRepository = orderlineRepository;
    }

    @Override
    public Orderline findById(Long id) {
        return orderlineRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("id",id.toString()));
    }
}
