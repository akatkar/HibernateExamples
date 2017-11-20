package com.akatkar.hibarnate4.manytomany;

import com.akatkar.hibarnate4.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ali-Katkar
 */
public class TestManyToMany {

    public static void main(String[] args) {

        SessionFactory sf = HibernateUtil.getSessionFactory();

        Session session = sf.openSession();

        try {

            Event e1 = new Event("Java");
            Event e2 = new Event("C++");
            Event e3 = new Event("JavaScript");

            Speaker s1 = new Speaker("John");
            Speaker s2 = new Speaker("Michael");
            Speaker s3 = new Speaker("Steve");

            e1.getSpeakers().add(s1);
            e2.getSpeakers().add(s1);
            e2.getSpeakers().add(s2);
            e3.getSpeakers().add(s3);

            s1.getEvents().add(e1);
            s1.getEvents().add(e2);
            s2.getEvents().add(e2);
            s3.getEvents().add(e3);

            session.beginTransaction();

            session.save(e1);
            session.save(e2);
            session.save(e3);

            session.save(s1);
            session.save(s2);
            session.save(s3);

            session.getTransaction().commit();

        } finally {
            session.close();
            sf.close();
        }

    }
}
