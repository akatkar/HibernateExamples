/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akatkar.winerydemoproject;

import com.akatkar.winerydemoproject.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ali Katkar
 */
public class Application {
    public static void main(String[] args) {
        System.out.println("running ...");
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try{
            
        }finally{
            session.close();
            sessionFactory.close();
        }
    }
}
