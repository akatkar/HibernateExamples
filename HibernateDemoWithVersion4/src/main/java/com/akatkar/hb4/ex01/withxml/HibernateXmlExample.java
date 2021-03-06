package com.akatkar.hb4.ex01.withxml;

import com.akatkar.hb4.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ali-Katkar
 */
public class HibernateXmlExample {

    public static void main(String[] args) {
        System.out.println("running...");

        HibernateUtil.initialize();
                
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
       
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            CustomerInfo ci = new CustomerInfo("Carrefour", "Erenköy", "İstanbul", "02163445366");
            ci.setId(24);
            session.save(ci);
            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
