/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akatkar.winerydemoproject.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Ali Katkar
 */
@Entity
public class Item implements Serializable {
    
    @Id
    @GeneratedValue
    private int id;
    
    @Id
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name="order_id", referencedColumnName = "id"),
        @JoinColumn(name = "cust_id", referencedColumnName = "cust_id")           
    })
    private Orders orders;
    
    @OneToOne
    private Wine wine;
    private int quantity;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Wine getWine() {
        return wine;
    }

    public void setWine(Wine wine) {
        this.wine = wine;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
