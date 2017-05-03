/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akatkar.hibarnate4.onetoone;

import com.akatkar.hibarnate4.HibernateUtil;
import com.akatkar.hibarnate4.compound.Account;
import com.akatkar.hibarnate4.compound.CoumpoundKey;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ali-Katkar
 */
public class TestOneToOne {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();

        Session session = sf.openSession();

        try {
            PersonDetail pd = new PersonDetail("Ankara");
            Person person = new Person("Ahmet", pd);
            
            
            PersonDetail pd2 = new PersonDetail("Balıkesir");
            Person person2 = new Person("Mehmet", pd2);
            
            
            session.beginTransaction();

            session.save(person);
            session.save(person2);

            session.getTransaction().commit();

        } finally {
            session.close();
            sf.close();
        }

    }
}
