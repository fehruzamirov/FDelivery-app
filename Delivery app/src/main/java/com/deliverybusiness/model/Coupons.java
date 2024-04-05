package com.deliverybusiness.model;

import javax.persistence.*;

@Entity
@Table(name = "Coupons")
public class Coupons {
    @Id
    @Column(name = "ID")
    private int id;
    @Column(name = "Code")
    private int code;
    @Column(name = "Name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "restaurant_ID", referencedColumnName = "ID")
    private Restaurant restaurant;

    public Coupons() {
    }

    public Coupons(int id, int code, String name, Restaurant restaurant) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.restaurant = restaurant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Coupons{" +
                "id=" + id +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", restaurant=" + restaurant +
                '}';
    }
}
