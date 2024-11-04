package com.max.spring.rest.dao;


import com.max.spring.rest.entity.Employee;

import java.util.List;

/**
 * @author ZuevMYu
 * @since 17.07.2024
 */
public interface EmployeeDAO {
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);
    public Employee getEmployee(int id);
    public void deleteEmployee(int id);
}
