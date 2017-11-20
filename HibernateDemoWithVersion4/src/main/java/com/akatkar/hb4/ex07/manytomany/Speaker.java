package com.akatkar.hb4.ex07.manytomany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Ali-Katkar
 */
@Entity
public class Speaker implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    
    private String name;

    @ManyToMany
     @JoinTable(name="join_event_speaker",  
            joinColumns = {@JoinColumn(name="speaker_id")},
            inverseJoinColumns = {@JoinColumn(name="event_id")}
    )
   private List<Event> events = new ArrayList<>();

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public Speaker(String name) {
        this.name = name;
    }

    public Speaker() {
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
