package com.allegiancemd.springdemo.dao;

import com.allegiancemd.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer order by lastName", Customer.class);
        List<Customer> customers = query.getResultList();
        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int customerId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class, customerId);
    }

    @Override
    public void removeCustomer(int customerId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Customer where id =: customerId").setParameter("customerId",customerId);
        query.executeUpdate();
//        session.delete(getCustomer(customerId));
    }
}
