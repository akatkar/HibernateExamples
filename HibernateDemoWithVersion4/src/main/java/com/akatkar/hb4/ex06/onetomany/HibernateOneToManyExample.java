package com.akatkar.hb4.ex06.onetomany;

import com.akatkar.hb4.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ali-Katkar
 */
public class HibernateOneToManyExample {

    public static void main(String[] args) {

        HibernateUtil.initialize(MySchool.class, MyStudent.class);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        try {

            MySchool school = new MySchool("Pertevniyal");
            MyStudent s1 = new MyStudent("ali", school);
            MyStudent s2 = new MyStudent("veli", school);
            MyStudent s3 = new MyStudent("ahmet", school);
            MyStudent s4 = new MyStudent("mehmet", school);

            school.getStudents().add(s1);
            school.getStudents().add(s2);
            school.getStudents().add(s3);
            school.getStudents().add(s4);

            session.beginTransaction();

            session.save(school);

            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
