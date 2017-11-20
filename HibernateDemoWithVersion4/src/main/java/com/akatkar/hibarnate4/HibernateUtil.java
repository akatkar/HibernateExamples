package com.akatkar.hibarnate4;

import com.akatkar.hibarnate4.annotation.School;
import com.akatkar.hibarnate4.annotation.Student;
import com.akatkar.hibarnate4.compound.Account;
import com.akatkar.hibarnate4.inheritance.Module;
import com.akatkar.hibarnate4.inheritance.Project;
import com.akatkar.hibarnate4.inheritance.Task;
import com.akatkar.hibarnate4.manytomany.Event;
import com.akatkar.hibarnate4.manytomany.Speaker;
import com.akatkar.hibarnate4.onetomany.MySchool;
import com.akatkar.hibarnate4.onetomany.MyStudent;
import com.akatkar.hibarnate4.onetoone.Person;
import com.akatkar.hibarnate4.onetoone.PersonDetail;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 *
 * @author Ali-Katkar
 */
public final class HibernateUtil {
    private static final SessionFactory SESSION_FACTORY;
    
    private HibernateUtil(){        
    }
    
    static{
        Configuration cfg = new Configuration();
        cfg.configure();
        
        cfg.addAnnotatedClass(Student.class)
           .addAnnotatedClass(School.class)
           .addAnnotatedClass(Account.class)
           .addAnnotatedClass(Person.class)
           .addAnnotatedClass(PersonDetail.class)
           .addAnnotatedClass(MySchool.class)
           .addAnnotatedClass(MyStudent.class)
           .addAnnotatedClass(Event.class)
                .addAnnotatedClass(Speaker.class)
                .addAnnotatedClass(Project.class)
                .addAnnotatedClass(Module.class)
                .addAnnotatedClass(Task.class);
        
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(cfg.getProperties());
        new SchemaExport(cfg).create(true,true);
        SESSION_FACTORY = cfg.buildSessionFactory(builder.build());
    }
    
    public static SessionFactory getSessionFactory(){
        return SESSION_FACTORY;
    }
}
