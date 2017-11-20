package com.akatkar.hibarnate4.inheritance;

import javax.persistence.*;

/**
 *
 * @author Ali-Katkar
 */
@Entity
//@DiscriminatorValue(value = "task")
public class Task extends Module{
    
    @Column(name ="task")
    private String taskName;

    public Task() {
    }

    public Task(String taskName, String moduleName, String name) {
        super(moduleName, name);
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}
