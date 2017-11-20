package com.akatkar.hb4.ex01.withxml;

import com.akatkar.hb4.*;

/**
 *
 * @author Ali-Katkar
 */
public class CustomerInfo {
    
    private int id;
    private String custName;
    private String address;
    private String town;
    private String city;
    private String phone;
    private String newField;

    public String getNewField() {
        return newField;
    }

    public void setNewField(String newField) {
        this.newField = newField;
    }
    
    

    public CustomerInfo() {
    }

    public CustomerInfo(String custName, String town, String city, String phone) {
        this.custName = custName;
        this.town = town;
        this.city = city;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
    
}
