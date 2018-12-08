package com.codegym.manageremployeehotel.service;

import com.codegym.manageremployeehotel.model.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TeamService{
    Page<Team> findAll(Pageable pageable);

    Iterable<Team> findAll();

    Optional<Team> findById(Long id);

    void save(Team team);

    void remove(Long id);
}
