/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akatkar.hibarnate4.manytomany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Ali-Katkar
 */
@Entity
public class Event implements Serializable{
    
    @Id
    @GeneratedValue
    private int id;
    
    private String name;

    public Event() {
    }

    public Event(String name) {
        this.name = name;
    }

    @ManyToMany
    @JoinTable(name="join_event_speaker",  
            joinColumns = {@JoinColumn(name="event_id")},
            inverseJoinColumns = {@JoinColumn(name="speaker_id")}
    )
    private List<Speaker> speakers = new ArrayList<>();

    public List<Speaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(List<Speaker> speakers) {
        this.speakers = speakers;
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
