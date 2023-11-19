package com.pervishkond.hibernateshawarmamenu;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class HibernateUtil {
    private static final SessionFactory sessionFactory= initSessionFactory();


    private static SessionFactory initSessionFactory(){
        try{
            return new Configuration().configure(new File("hibernateshawarmamenu\\src\\main\\resources\\hibernate.cfg.xml")).buildSessionFactory();
        }catch (Throwable ex){
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static void close(){
        sessionFactory.close();
    }
}

