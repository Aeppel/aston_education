package com.pervishkond.hibernateshawarmamenu;

import com.pervishkond.hibernateshawarmamenu.entities.TopSales;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import java.util.List;


public class TopSalesTest {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<TopSales> cq = cb.createQuery(TopSales.class);
        Root<TopSales> root = cq.from(TopSales.class);
        cq.select(root);

        Query query = session.createQuery(cq);
        List<TopSales> topSales = query.getResultList();
        System.out.println(topSales);
        session.close();


    }
}

