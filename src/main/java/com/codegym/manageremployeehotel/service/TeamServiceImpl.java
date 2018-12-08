package com.codegym.manageremployeehotel.service;

import com.codegym.manageremployeehotel.model.Team;
import com.codegym.manageremployeehotel.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamRepository teamRepository;
    @Override
    public Page<Team> findAll(Pageable pageable) {
        return teamRepository.findAll(pageable);
    }

    @Override
    public Iterable<Team> findAll() {
        return teamRepository.findAll();
    }

    @Override
    public Optional<Team> findById(Long id) {
        return teamRepository.findById(id);
    }

    @Override
    public void save(Team team) {
        teamRepository.save(team);
    }

    @Override
    public void remove(Long id) {
        teamRepository.deleteById(id);
    }
}
