package com.codegym.manageremployeehotel.service;

import com.codegym.manageremployeehotel.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);

    Optional<Employee> finById(Long id);

    void save(Employee employee);

    void remove(Long id);

    Page<Employee> findByFullNameContaining(String fullName, Pageable pageable);
}
