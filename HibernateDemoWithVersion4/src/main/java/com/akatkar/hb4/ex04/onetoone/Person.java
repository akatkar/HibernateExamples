package com.akatkar.hb4.ex04.onetoone;

import javax.persistence.*;

/**
 *
 * @author Ali-Katkar
 */
@Entity
public class Person {
    @Id
    @GeneratedValue
    private int id;
    
    private String name;
    
    private int age;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detail_id")
    private PersonDetail detail;

    public Person() {
    }

    public Person(String name, PersonDetail detail) {
        this.name = name;
        this.detail = detail;
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

    public PersonDetail getDetail() {
        return detail;
    }

    public void setDetail(PersonDetail detail) {
        this.detail = detail;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    } 

    @Override
    public String toString() {
        return id + ", "+  name + ", age=" + age + ", detail=" + detail + '}';
    }
}
