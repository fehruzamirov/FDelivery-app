package com.deliverybusiness.model;

import javax.persistence.*;

@Entity
@Table(name = "Payment")
public class Payment {
    @Id
    @Column(name = "ID")
    private int id;
    @Column(name = "Amount")
    private double amount;
    @ManyToOne
    @JoinColumn(name = "Custimer_ID", referencedColumnName = "ID")
    private Customer customer;

    public Payment() {
    }

    public Payment(int id, double amount, Customer customer) {
        this.id = id;
        this.amount = amount;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", amount=" + amount +
                ", customer=" + customer +
                '}';
    }
}
