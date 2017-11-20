package com.akatkar.hibarnate4.inheritance;

import com.akatkar.hibarnate4.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Ali-Katkar
 */
public class TestInheritance {
    
    public static void main(String[] args) {
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        
        Session session = sessionFactory.openSession();
        
        try{
            Project project = new Project("project 1");
            Module module = new Module("module 1", "proje 2");
            Task task = new Task ("task 1", "module 1", "proje 2");
            
            Transaction tx = session.beginTransaction();
            
            session.save(project);
            session.save(module);
            session.save(task);
            
            tx.commit();
        }finally{
            session.close();
            sessionFactory.close();
        }        
    }    
}
