package com.UCM.EmpDetails.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.UCM.EmpDetails.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{ 

}
