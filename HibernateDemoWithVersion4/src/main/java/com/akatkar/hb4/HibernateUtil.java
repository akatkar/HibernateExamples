package com.akatkar.hb4;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Ali Katkar
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private static SessionFactory configureSessionFactory(Class... classes) throws HibernateException {

        Configuration configuration = new Configuration().configure();

        if (classes != null) {
            for (Class c : classes) {
                configuration.addAnnotatedClass(c);
            }
        }

        StandardServiceRegistryBuilder builder
                = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        
        new SchemaExport(configuration).create(true,true);
        
        sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }

    /**
     * This method must be used with xml mapping
     *
     */
    public static void initialize() {
        configureSessionFactory((Class) null);
    }

    /**
     * This method must be used with an annotated class
     *
     * @param annotatedClasses
     */
    public static void initialize(Class... annotatedClasses) {
        configureSessionFactory(annotatedClasses);
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void close() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}

