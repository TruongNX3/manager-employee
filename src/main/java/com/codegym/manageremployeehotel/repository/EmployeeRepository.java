package com.codegym.manageremployeehotel.repository;

import com.codegym.manageremployeehotel.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Long> {
    Page<Employee> findByFullNameContaining(String fullName, Pageable pageable);
}
