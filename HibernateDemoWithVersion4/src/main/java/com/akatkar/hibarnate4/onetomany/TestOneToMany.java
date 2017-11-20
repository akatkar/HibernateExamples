package com.akatkar.hibarnate4.onetomany;

import com.akatkar.hibarnate4.HibernateUtil;
import com.akatkar.hibarnate4.compound.Account;
import com.akatkar.hibarnate4.compound.CoumpoundKey;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ali-Katkar
 */
public class TestOneToMany {

    public static void main(String[] args) {

        SessionFactory sf = HibernateUtil.getSessionFactory();

        Session session = sf.openSession();

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
            sf.close();
        }
    }
}
