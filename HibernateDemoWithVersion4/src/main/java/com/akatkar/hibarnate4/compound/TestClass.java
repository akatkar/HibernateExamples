package com.akatkar.hibarnate4.compound;

import com.akatkar.hibarnate4.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ali-Katkar
 */
public class TestClass {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        
        Session session = sf.openSession();
        
        try{
            CoumpoundKey ck = new CoumpoundKey(1, "USD");
            Account account = new Account(ck, 15000.54);
            
            CoumpoundKey ck2 = new CoumpoundKey(2, "EURO");
            Account account2 = new Account(ck2, 250.54);
            
            session.beginTransaction();
            
            session.save(account);
            session.save(account2);
            
            session.getTransaction().commit();
            
        }finally{
            session.close();
            sf.close();
        }
        
        
    }
}
