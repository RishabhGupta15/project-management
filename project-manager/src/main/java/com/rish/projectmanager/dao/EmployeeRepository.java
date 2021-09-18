package com.rish.projectmanager.dao;

import com.rish.projectmanager.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
