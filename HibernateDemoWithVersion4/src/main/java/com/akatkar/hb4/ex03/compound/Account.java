package com.akatkar.hb4.ex03.compound;

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
    private CompoundKey key;
    
    private double balance;

    public Account() {
    }

    public Account(CompoundKey key, double balance) {
        this.key = key;
        this.balance = balance;
    }
    
    public CompoundKey getKey() {
        return key;
    }

    public void setKey(CompoundKey key) {
        this.key = key;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    
}
