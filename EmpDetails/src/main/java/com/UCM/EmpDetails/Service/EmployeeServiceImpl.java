package com.UCM.EmpDetails.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UCM.EmpDetails.Entity.Employee;
import com.UCM.EmpDetails.Repository.EmployeeRepository;
import com.UCM.EmpDetails.Service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService{
  
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee saveEmployee(Employee employee)
	{
		return employeeRepository.save(employee);
	}
	
	
    @Override
    public List<Employee> fetchAllEmployees() {
        List<Employee> allEmployees = employeeRepository.findAll();
        return allEmployees;
    }

	@Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        }
        return null;
    }
    
    @Override
    public Employee updateEmployeeById(Long id, Employee employee) {
        Optional<Employee> employee1 = employeeRepository.findById(id);

        if (employee1.isPresent()) {
            Employee originalEmployee = employee1.get();

            if (Objects.nonNull(employee.getEmployeeName()) && !"".equalsIgnoreCase(employee.getEmployeeName())) {
                originalEmployee.setEmployeeName(employee.getEmployeeName());
            }
            if (Objects.nonNull(employee.getEmployeeSalary()) && employee.getEmployeeSalary() != 0) {
                originalEmployee.setEmployeeSalary(employee.getEmployeeSalary());
            }
            return employeeRepository.save(originalEmployee);
        }
        return null;
    }


	@Override
	public String deleteByEmployeeId(Long id) {
		// TODO Auto-generated method stub
		if(employeeRepository.findById(id).isPresent())
		{
			employeeRepository.deleteById(id);
			return "Employee record deleted successfully";
		}
		return "Employee record is not found for delete";
	}

}

