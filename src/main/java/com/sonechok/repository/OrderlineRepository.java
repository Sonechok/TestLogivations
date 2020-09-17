package com.sonechok.repository;

import com.sonechok.entity.Orderline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderlineRepository extends JpaRepository<Orderline, Long> {
}
