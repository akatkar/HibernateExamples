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
public class Winery implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "winery_key_gen")
    @TableGenerator(name = "winery_key_gen", table = "winery_pk_gen")
    private int id;
    
    private String name;
    @OneToOne
    @JoinColumn(name = "region_id")
    private Region region;
    private String description;
    private String phone;
    private String fax;    

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

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    } 
}
