/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akatkar.winerydemoproject.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Ali Katkar
 */
@Entity
public class Inventory implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    @Id
    @OneToOne
    private Wine wine;
    private boolean onHand;
    private double cost;
    private double caseCost;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateAdded;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Wine getWine() {
        return wine;
    }

    public void setWine(Wine wine) {
        this.wine = wine;
    }

    public boolean isOnHand() {
        return onHand;
    }

    public void setOnHand(boolean onHand) {
        this.onHand = onHand;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getCaseCost() {
        return caseCost;
    }

    public void setCaseCost(double caseCost) {
        this.caseCost = caseCost;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }
 
}
