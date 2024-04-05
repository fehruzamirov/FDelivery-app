package com.deliverybusiness.model;

import javax.persistence.*;

@Entity
@Table(name = "OrderItem")
public class OrderItem {
    @Id
    @Column(name = "ID")
    private int id;
    @ManyToOne
    @JoinColumn(name = "Order_ID", referencedColumnName = "ID")
    private Orders order;
    @ManyToOne
    @JoinColumn(name = "MenuItem_ID", referencedColumnName = "ID")
    private MenuItem menuItem;
    @Column(name = "Quantity")
    private int quantity;

    public OrderItem() {
    }

    public OrderItem(int id, Orders order, MenuItem menuItem, int quantity) {
        this.id = id;
        this.order = order;
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", order=" + order +
                ", menuItem=" + menuItem +
                ", quantity=" + quantity +
                '}';
    }
}
