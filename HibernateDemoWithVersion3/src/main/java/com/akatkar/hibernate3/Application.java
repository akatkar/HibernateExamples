/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akatkar.hibernate3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 *
 * @author Ali-Katkar
 */
public class Application {
    
    
    public static void main(String[] args) {
        System.out.println("running...");
        AnnotationConfiguration cfg = new AnnotationConfiguration();
        cfg.configure();
        
        new SchemaExport(cfg).create(true, true);
                
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        CustomerInfo ci = new CustomerInfo("Carrefour", "Erenköy", "İstanbul", "02163445366");
        
        session.save(ci);
        session.getTransaction().commit();
        session.close();
        
    }
}
