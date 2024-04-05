package com.deliverybusiness.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
@Entity
@Table(name = "Orders")
public class Orders {
    @Id
    @Column(name = "ID")
    private int id;
    @Column(name = "OrderDate")
    private LocalDate orderDate;
    @Column(name = "PreparedDate")
    private LocalDate preparedDate;
    @Column(name = "TakenOverDate")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate takenOverDate;
    @Column(name = "isPaid")
    private boolean isPaid;
    @Column(name = "Price")
    private double price;
    @Column(name = "Note")
    private String note;
    @ManyToOne
    @JoinColumn(name = "restaurant_ID", referencedColumnName = "ID")
    private Restaurant restaurant;
    @ManyToOne
    @JoinColumn(name = "Customer_ID", referencedColumnName = "ID")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "Coupons_ID", referencedColumnName = "ID")
    private Coupons coupons;
    @ManyToOne
    @JoinColumn(name = "OrderStatus_ID", referencedColumnName = "ID")
    private OrderStatus orderStatus;

    public Orders() {
    }

    public Orders(int id, LocalDate orderDate, LocalDate preparedDate, LocalDate takenOverDate, boolean isPaid, double price, String note, Restaurant restaurant, Customer customer, Coupons coupons, OrderStatus orderStatus) {
        this.id = id;
        this.orderDate = orderDate;
        this.preparedDate = preparedDate;
        this.takenOverDate = takenOverDate;
        this.isPaid = isPaid;
        this.price = price;
        this.note = note;
        this.restaurant = restaurant;
        this.customer = customer;
        this.coupons = coupons;
        this.orderStatus = orderStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getPreparedDate() {
        return preparedDate;
    }

    public void setPreparedDate(LocalDate preparedDate) {
        this.preparedDate = preparedDate;
    }

    public LocalDate getTakenOverDate() {
        return takenOverDate;
    }

    public void setTakenOverDate(LocalDate takenOverDate) {
        this.takenOverDate = takenOverDate;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Coupons getCoupons() {
        return coupons;
    }

    public void setCoupons(Coupons coupons) {
        this.coupons = coupons;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", preparedDate=" + preparedDate +
                ", takenOverDate=" + takenOverDate +
                ", isPaid=" + isPaid +
                ", price=" + price +
                ", note='" + note + '\'' +
                ", restaurant=" + restaurant +
                ", customer=" + customer +
                ", coupons=" + coupons +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
