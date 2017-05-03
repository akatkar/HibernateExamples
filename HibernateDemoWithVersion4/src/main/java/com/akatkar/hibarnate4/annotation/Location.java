/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akatkar.hibarnate4.annotation;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Ali-Katkar
 */
@Embeddable
public class Location implements Serializable {
    
    @Column(name = "lat")
    private double lattitude;
    @Column(name = "att")
    private double attitude;

    public Location() {
    }

    public Location(double lattitude, double attitude) {
        this.lattitude = lattitude;
        this.attitude = attitude;
    }

    public double getLattitude() {
        return lattitude;
    }

    public void setLattitude(double lattitude) {
        this.lattitude = lattitude;
    }

    public double getAttitude() {
        return attitude;
    }

    public void setAttitude(double attitude) {
        this.attitude = attitude;
    }
}
