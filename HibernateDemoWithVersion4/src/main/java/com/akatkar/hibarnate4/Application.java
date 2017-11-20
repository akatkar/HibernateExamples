package com.akatkar.hibarnate4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ali-Katkar
 */
public class Application {

    public static void main(String[] args) {
        System.out.println("running...");

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
