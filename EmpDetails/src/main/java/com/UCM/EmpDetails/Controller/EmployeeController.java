package com.UCM.EmpDetails.Controller;

import com.UCM.EmpDetails.Entity.Employee;
import com.UCM.EmpDetails.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/EmpDetails")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
   
    
    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/employee")
    public List<Employee> getAllEmployees() {
        return employeeService.fetchAllEmployees();
    }

   @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id) {
        return employeeService.getEmployeeById(id);
    }
    
   @PutMapping("/employee/{id}")
   public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
       return employeeService.updateEmployeeById(id, employee);
   }
   
   @DeleteMapping("/employee/{id}")
   public String deleteEmployee(@PathVariable("id") Long id) {
       return employeeService.deleteByEmployeeId(id);
   }


}
