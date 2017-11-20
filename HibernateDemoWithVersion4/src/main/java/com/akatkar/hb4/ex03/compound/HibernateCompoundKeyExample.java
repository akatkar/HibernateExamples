package com.akatkar.hb4.ex03.compound;

import com.akatkar.hb4.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ali-Katkar
 */
public class HibernateCompoundKeyExample {

    public static void main(String[] args) {
        HibernateUtil.initialize(Account.class, CompoundKey.class);

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        
        Session session = sessionFactory.openSession();

        try {
            CompoundKey ck = new CompoundKey(1, "USD");
            Account account = new Account(ck, 15000.54);

            CompoundKey ck2 = new CompoundKey(2, "EURO");
            Account account2 = new Account(ck2, 250.54);

            session.beginTransaction();

            session.save(account);
            session.save(account2);

            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
