package com.akatkar.winerydemoproject.config;

import com.akatkar.winerydemoproject.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Ali Katkar
 */
public class HibernateUtil {
    
    private static final SessionFactory SESSION_FACTORY;
    
    static {
        Configuration cfg = new Configuration();
        cfg.configure();
        cfg.addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Inventory.class)
                .addAnnotatedClass(Region.class)
                .addAnnotatedClass(Users.class)
                .addAnnotatedClass(Wine.class)
                .addAnnotatedClass(Winery.class)
                .addAnnotatedClass(Orders.class)
                .addAnnotatedClass(Item.class);
        
        
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(cfg.getProperties());
        SESSION_FACTORY = cfg.buildSessionFactory(builder.build());
    }
    
    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }
}
