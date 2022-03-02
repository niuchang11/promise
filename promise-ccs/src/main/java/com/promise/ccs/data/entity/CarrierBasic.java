package com.promise.ccs.data.entity;


import javax.persistence.*;

@Entity
@Table(name = "CARRIER_BASIC")
public class CarrierBasic {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
