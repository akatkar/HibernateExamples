package com.akatkar.hb4.ex04.onetoone;

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
