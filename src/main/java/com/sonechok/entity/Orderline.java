package com.sonechok.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "orderline")
public class Orderline {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Product> product = new ArrayList<>();

    public Orderline(Long id, List<Product> product) {
        this.id = id;
        this.product = product;
    }

    public Orderline(List<Product> product) {
        this.product = product;
    }

    public Orderline() {
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public List<Product> getProduct() {
        return product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
