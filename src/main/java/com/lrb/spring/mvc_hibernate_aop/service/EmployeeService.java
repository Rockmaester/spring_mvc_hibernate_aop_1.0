package com.lrb.spring.mvc_hibernate_aop.service;

import com.lrb.spring.mvc_hibernate_aop.entity.Employee;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    @Transactional
    void deleteEmployee(int id);
}
