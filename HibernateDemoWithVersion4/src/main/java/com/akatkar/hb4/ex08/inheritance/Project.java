package com.akatkar.hb4.ex08.inheritance;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Ali-Katkar
 */
@Entity
@Table(name="project")
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "DTYPE")
//@DiscriminatorValue(value = "project")
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    @Column(name = "project")
    private String name;

    public Project() {
    }

    public Project(String name) {
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
