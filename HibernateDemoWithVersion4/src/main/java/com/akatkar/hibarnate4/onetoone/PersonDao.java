/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akatkar.hibarnate4.onetoone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ali-Katkar
 */
public class PersonDao {

    private final SessionFactory sessionFactory;

    public PersonDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void close() {
        sessionFactory.close();
    }

    public void create(Person person) {

        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.save(person);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    public void update(Person person) {

        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.saveOrUpdate(person);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    public void delete(Person person) {

        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.delete(person);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    public Person find(int id) {
        Person result = null;
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            result = (Person)session.get(Person.class, id);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
        return result;
    }
    
    public List<Person> findAll(){
        List<Person> result = Collections.EMPTY_LIST;
        
        Session session = sessionFactory.openSession();
        String sql = "From Person";
        try {
            session.beginTransaction();
            Query query = session.createQuery(sql);
            result = query.list();
                    
            session.getTransaction().commit();
        } finally {
            session.close();
        }
        return result;
    } 

}
