/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akatkar.hibarnate4.annotation;

import com.akatkar.hibarnate4.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ali-Katkar
 */
public class TestStudent {
    public static void main(String[] args) {
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        
        Session session = sessionFactory.openSession();
        
        try{
            Student student = new Student("Ali", "Katkar", "Medical Sciende");
            Student student2 = new Student("Buse", "Tekin", "Computer Science");
            
            Student student3 = new Student();            
            student3.setFirstName("Alican");
            student3.setLastName("Işık"); 
            student3.setBranch("Su ürünleri");
            
            School school = new School("Galatasaray", "İstiklal cad.", "İstanbul", 20);
            Location location = new Location(40.10, 55.65);
            school.setLocation(location);
            
            session.beginTransaction();
            
            session.save(student);
            session.save(student2);
            session.save(school);
            Integer id = (Integer) session.save(student3);
            System.out.println(id);
            
            session.getTransaction().commit();
            
            
            student3.setId(id);
            student3.setFirstName("Jan Valjan");
            student3.setBranch("Computer Science");
            
            session.beginTransaction();
            session.save(student3);            
            session.getTransaction().commit();
            
        }finally{
            
            session.close();
            sessionFactory.close();
        }
    }
}
