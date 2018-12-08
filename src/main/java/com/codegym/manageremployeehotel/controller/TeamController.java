package com.codegym.manageremployeehotel.controller;

import com.codegym.manageremployeehotel.model.Team;
import com.codegym.manageremployeehotel.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @GetMapping("create-team")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("team/create");
        modelAndView.addObject("team", new Team());
        return modelAndView;
    }

    @PostMapping("create-team")
    public ModelAndView create(@ModelAttribute("team") Team team) {
        teamService.save(team);
        ModelAndView modelAndView = new ModelAndView("team/create");
        modelAndView.addObject("team", team);
        modelAndView.addObject("message", "Create new team sussesfully!");
        return modelAndView;
    }

    @GetMapping("teams")
    public ModelAndView listTeam(Pageable pageable) {
        Page<Team> teams = teamService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("team/list");
        modelAndView.addObject("teams", teams);
        return modelAndView;
    }

    @GetMapping("edit-team/{id}")
    public ModelAndView editForm(@PathVariable Long id) {
        Optional<Team> team = teamService.findById(id);
        ModelAndView modelAndView = new ModelAndView("team/edit");
        modelAndView.addObject("team", team);
        return modelAndView;
    }

    @PostMapping("edit-team")
    public ModelAndView edit(@ModelAttribute("team") Team team) {
        teamService.save(team);
        ModelAndView modelAndView = new ModelAndView("team/edit");
        modelAndView.addObject("team", team);
        modelAndView.addObject("message", "Edit team sussesfully!");
        return modelAndView;
    }

    @GetMapping("delete-team/{id}")
    public ModelAndView deleteForm(@PathVariable Long id) {
        Optional<Team> team = teamService.findById(id);
        ModelAndView modelAndView = new ModelAndView("team/delete");
        modelAndView.addObject("team", team);
        return modelAndView;
    }

    @PostMapping("delete-team")
    public ModelAndView delete(@ModelAttribute("team") Team team) {
        teamService.remove(team.getId());
        ModelAndView modelAndView = new ModelAndView("team/list");
        return modelAndView;
    }
}