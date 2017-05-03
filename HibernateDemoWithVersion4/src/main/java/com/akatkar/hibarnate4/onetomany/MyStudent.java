/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akatkar.hibarnate4.onetomany;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Ali-Katkar
 */
@Entity
public class MyStudent implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    
    private String name;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "school_id")
    private MySchool mySchool;

    public MyStudent(String name, MySchool school) {
        this.name = name;
        this.mySchool =school;
    }

    public MyStudent() {
    }

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

    public MySchool getMySchool() {
        return mySchool;
    }

    public void setMySchool(MySchool mySchool) {
        this.mySchool = mySchool;
    }
    
    
    
}
