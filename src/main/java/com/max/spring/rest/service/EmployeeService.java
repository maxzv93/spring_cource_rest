package com.max.spring.rest.service;

import com.max.spring.rest.entity.Employee;

import java.util.List;

/**
 * @author ZuevMYu
 * @since 25.07.2024
 */
public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);
}
