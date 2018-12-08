package com.codegym.manageremployeehotel.formatter;

import com.codegym.manageremployeehotel.model.Team;
import com.codegym.manageremployeehotel.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class TeamFormatter implements Formatter<Optional<Team>> {
    private TeamService teamService;

    @Autowired
    public TeamFormatter(TeamService teamService) {
        this.teamService = teamService;
    }
    @Override
    public Optional<Team> parse(String text, Locale locale) throws ParseException {
        return teamService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Optional<Team> object, Locale locale) {
        return "[" + object.get().getId() + "," + object.get().getName() + "]";
    }
}
