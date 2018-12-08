package com.codegym.manageremployeehotel.repository;

import com.codegym.manageremployeehotel.model.Team;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TeamRepository extends PagingAndSortingRepository<Team,Long> {
}
