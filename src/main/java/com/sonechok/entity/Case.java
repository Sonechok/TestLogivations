package com.sonechok.entity;

import javax.persistence.*;

@Entity
@Table(name = "box")
public class Case {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "size_x", nullable = false)
    private Double sizeX;

    @Column(name = "size_y", nullable = false)
    private Double sizeY;

    @Column(name = "size_z", nullable = false)
    private Double sizeZ;

    public Case(Double sizeX, Double sizeY, Double sizeZ) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.sizeZ = sizeZ;
    }

    public Case() {
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
}
