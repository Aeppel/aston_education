package com.pervishkond.myapp.DAO;

import com.pervishkond.myapp.entity.Customer;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerDAOImpl implements CustomerDAO {

    SessionFactory sessionFactory;

    public CustomerDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        if (customer.getId() == null) session.persist(customer);
        else session.merge(customer);
    }

    @Override
    public List<Customer> listAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
        Root<Customer> root = cq.from(Customer.class);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public Customer get(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class, id);
    }

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        String del = "DELETE FROM Customer where id=:id";
        Query query = session.createQuery(del);
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
