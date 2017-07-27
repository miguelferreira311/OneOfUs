package org.academiadecodigo.bootcamp.persistence.hibernate;

import org.academiadecodigo.bootcamp.persistence.TransactionException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;


/**
 * Created by codecadet on 19/07/2017.
 */
public class HibernateSessionManager {


    private static SessionFactory sessionFactory;

    static {
        try {
            // Hold services needed by Hibernate
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .configure("persistence/hibernate.cfg.xml") // Load settings from hibernate.cfg.xml
                    .build();

            sessionFactory = new MetadataSources(serviceRegistry)
                    .buildMetadata()
                    .buildSessionFactory();

        } catch (HibernateException ex) {
            throw new TransactionException(ex);
        }
    }

    public static Session getSession() {
        // Hibernate will automatically open a new session if needed
        // Closing the session is not required
        return sessionFactory.getCurrentSession();
    }

    // Required to stop hibernate and allow the application to terminate
    public static void close() {
        sessionFactory.close();
    }

    //returns a session already with a transaction
    public static Session beginTransaction() {

        Session session = getSession();
        session.beginTransaction();
        return session;
    }

    public static void commitTransaction() {
        getSession().getTransaction().commit();
    }

    public static void rollbackTransaction() {
        getSession().getTransaction().rollback();
    }
}
