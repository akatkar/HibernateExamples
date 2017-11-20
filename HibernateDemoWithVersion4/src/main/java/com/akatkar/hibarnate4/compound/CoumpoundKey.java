package com.akatkar.hibarnate4.compound;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 *
 * @author Ali-Katkar
 */
@Embeddable
public class CoumpoundKey implements Serializable {
    private int accountNo;
    
    private String currency;

    public CoumpoundKey() {
    }

    public CoumpoundKey(int accountNo, String currency) {
        this.accountNo = accountNo;
        this.currency = currency;
    }

    
    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.accountNo;
        hash = 97 * hash + Objects.hashCode(this.currency);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CoumpoundKey other = (CoumpoundKey) obj;
        if (this.accountNo != other.accountNo) {
            return false;
        }
        return Objects.equals(this.currency, other.currency);
    }   
}
