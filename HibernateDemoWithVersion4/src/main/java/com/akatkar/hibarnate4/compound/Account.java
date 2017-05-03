/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akatkar.hibarnate4.compound;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 *
 * @author Ali-Katkar
 */
@Entity
public class Account implements Serializable {
    
    @EmbeddedId
    private CoumpoundKey key;
    
    private double balance;

    public Account() {
    }

    public Account(CoumpoundKey key, double balance) {
        this.key = key;
        this.balance = balance;
    }
    
    public CoumpoundKey getKey() {
        return key;
    }

    public void setKey(CoumpoundKey key) {
        this.key = key;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    
}
