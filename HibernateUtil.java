package com.codeup;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Created by Calcious on 1/9/17.
 */
public class HibernateUtil {
    public static SessionFactory getSessionFactory() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
        .configure()
        .build();

        return new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
    }
}
