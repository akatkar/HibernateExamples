package com.akatkar.hibarnate4.annotation;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author Ali-Katkar
 */
@Entity
@Table(name="Students")
public class Student implements Serializable {
    
    @Id
    @TableGenerator(             
	name="StudentIdGen",              	
        table="Student_Id_Table",              	
        pkColumnName="Student_Id_PK",              	
        valueColumnName="Student_Id_value",              	
        pkColumnValue="StudentID",            
	initialValue=250,             
	allocationSize=10) 
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "StudentIdGen")
    private int id;
    
    @Column(name="first_name")
    private String firstName;
    
    @Column(name="last_name")
    private String lastName;
    
    @Column(name="branch", nullable = true, updatable = false)
    private String branch;
    
    public Student(){        
    }

    public Student(String firstName, String lastName, String branch) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.branch = branch;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }   
}
