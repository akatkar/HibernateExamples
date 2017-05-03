/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akatkar.hibarnate4.onetoone;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Ali-Katkar
 */
@Entity
public class PersonDetail implements Serializable {
    @Id 
    @GeneratedValue
    private int id;
    
    @OneToOne(mappedBy = "detail")
    private Person person;
    
    private String placeOfBirth;

    public PersonDetail() {
    }

    public PersonDetail(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
    
    
}
