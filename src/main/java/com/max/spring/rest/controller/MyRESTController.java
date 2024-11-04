package com.max.spring.rest.controller;

import com.max.spring.rest.entity.Employee;
import com.max.spring.rest.exception_handing.EmployeeIncorrectData;
import com.max.spring.rest.exception_handing.NoSuchEmployeeException;
import com.max.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * @author ZuevMYu
 * @since 03.11.2024
 */
@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> shawAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee shawAllEmployee(@PathVariable int id) {
        Employee employee = getEmployeeWithException(id);

        return employee;
    }

    private Employee getEmployeeWithException(int id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with id = " + id + " in Database");
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        getEmployeeWithException(id);
        
        employeeService.deleteEmployee(id);
        return "Employee with id = " + id + " was deleted";
    }
}










