package com.deliverybusiness.model;

import com.deliverybusiness.model.view.View;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @JsonView(View.ShowName.class)
    @Column(name = "Name")
    private String name;
    @JsonView(View.ShowStatus.class)
    @Column(name = "is_active")
    private boolean isActive;
    @Column(name = "Description")
    private String description;
    @ManyToOne

    @JoinColumn(name = "City_ID", referencedColumnName = "ID")
    private City city;

    @OneToMany(mappedBy = "restaurant", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<OpeningHours> hoursOfWork = new ArrayList<>();

    public Restaurant() {
    }

    public Restaurant(int id, String name, boolean isActive, String description, City city) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.description = description;
        this.city = city;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<OpeningHours> getHoursOfWork() {
        return hoursOfWork;
    }

    public void setHoursOfWork(List<OpeningHours> hoursOfWork) {
        this.hoursOfWork = hoursOfWork;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isActive=" + isActive +
                ", description='" + description + '\'' +
                ", city=" + city +
                '}';
    }
}
