package com.sonechok.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "size_x", nullable = false)
    private Double sizeX;

    @Column(name = "size_y", nullable = false)
    private Double sizeY;

    @Column(name = "size_z", nullable = false)
    private Double sizeZ;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Orderline> orderline = new ArrayList<>();

    public Product(Long id, Double sizeX, Double sizeY, Double sizeZ) {
        this.id = id;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.sizeZ = sizeZ;
    }

    public Product(Long id, Double sizeX, Double sizeY, Double sizeZ, List<Orderline> orderline) {
        this.id = id;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.sizeZ = sizeZ;
        this.orderline = orderline;
    }

    public Product(Double sizeX, Double sizeY, Double sizeZ, List<Orderline> orderline) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.sizeZ = sizeZ;
        this.orderline = orderline;
    }

    public Product(Double sizeX, Double sizeY, Double sizeZ) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.sizeZ = sizeZ;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSizeX() {
        return sizeX;
    }

    public void setSizeX(Double sizeX) {
        this.sizeX = sizeX;
    }

    public Double getSizeY() {
        return sizeY;
    }

    public void setSizeY(Double sizeY) {
        this.sizeY = sizeY;
    }

    public Double getSizeZ() {
        return sizeZ;
    }

    public void setSizeZ(Double sizeZ) {
        this.sizeZ = sizeZ;
    }

    public List<Orderline> getOrderline() {
        return orderline;
    }

    public void setOrderline(List<Orderline> orderline) {
        this.orderline = orderline;
    }
}
