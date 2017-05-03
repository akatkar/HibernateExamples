/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akatkar.hibarnate4.inheritance;

import javax.persistence.*;

/**
 *
 * @author Ali-Katkar
 */
@Entity
//@DiscriminatorValue(value = "module")
public class Module extends Project{
    
    @Column(name="modules")
    private String moduleName;

    public Module() {
    }

    public Module(String moduleName, String name) {
        super(name);
        this.moduleName = moduleName;
    }

    
    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
       
}
