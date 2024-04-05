package com.deliverybusiness.model;

import javax.persistence.*;

@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @Column(name = "ID")
    private int id;
    @Column(name = "Name")
    private String name;
    @Column(name = "isActive")
    private boolean isActive;
    @ManyToOne
    @JoinColumn(name = "restaurant_id", referencedColumnName = "ID")
    private Restaurant restaurant;

    public Menu() {
    }

    public Menu(int id, String name, boolean isActive, Restaurant restaurant) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.restaurant = restaurant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isActive=" + isActive +
                ", restaurant=" + restaurant +
                '}';
    }
}
