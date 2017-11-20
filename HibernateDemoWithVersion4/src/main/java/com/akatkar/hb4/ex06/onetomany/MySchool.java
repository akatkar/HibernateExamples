package com.akatkar.hb4.ex06.onetomany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;


/**
 *
 * @author Ali-Katkar
 */
@Entity
public class MySchool implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    
    private String name;

    @OneToMany(mappedBy = "mySchool", 
            cascade = CascadeType.ALL)
    private List<MyStudent> students = new ArrayList<>();

    public List<MyStudent> getStudents() {
        return students;
    }

    public void setStudents(List<MyStudent> students) {
        this.students = students;
    }
        
    public MySchool() {
    }

    public MySchool(String name) {
        this.name = name;
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
    
    
    
}
