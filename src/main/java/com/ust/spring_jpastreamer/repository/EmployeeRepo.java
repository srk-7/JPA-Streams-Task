package com.ust.spring_jpastreamer.repository;

import com.ust.spring_jpastreamer.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
}
