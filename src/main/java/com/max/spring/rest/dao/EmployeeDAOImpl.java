package com.max.spring.rest.dao;

import com.max.spring.rest.entity.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.MutationQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ZuevMYu
 * @since 17.07.2024
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
        List<Employee> allEmployees = session.createQuery("from Employee", Employee.class).getResultList();

//        Query<Employee> query = session.createQuery("from Employee", Employee.class);
//        List<Employee> resultList = query.getResultList();

        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }

        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            Employee employee = session.get(Employee.class, id);
            return employee;
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }

        return null;
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        MutationQuery query = session.createMutationQuery("delete from Employee " + "where id = :employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
