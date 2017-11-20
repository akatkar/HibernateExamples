package com.akatkar.hb4.ex04.onetoone;

import com.akatkar.hb4.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ali-Katkar
 */
public class HibernateOneToOneExample {

    public static void main(String[] args) {
        
        HibernateUtil.initialize(Person.class, PersonDetail.class);

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        
        Session session = sessionFactory.openSession();

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
            sessionFactory.close();
        }
    }
}
