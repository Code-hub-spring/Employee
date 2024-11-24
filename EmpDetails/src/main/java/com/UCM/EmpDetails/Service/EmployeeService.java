package com.UCM.EmpDetails.Service;

import java.util.List;

import com.UCM.EmpDetails.Entity.Employee;

public interface EmployeeService {
	

    Employee saveEmployee(Employee employee);

    List<Employee> fetchAllEmployees();

    Employee getEmployeeById(Long id);

    Employee updateEmployeeById(Long id, Employee employee);

    String deleteByEmployeeId(Long id);
}