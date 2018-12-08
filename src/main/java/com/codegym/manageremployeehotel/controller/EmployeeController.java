package com.codegym.manageremployeehotel.controller;

import com.codegym.manageremployeehotel.model.Employee;
import com.codegym.manageremployeehotel.model.Team;
import com.codegym.manageremployeehotel.service.EmployeeService;
import com.codegym.manageremployeehotel.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private TeamService teamService;

    @ModelAttribute("teams")
    public Iterable<Team> provinces() {
        return teamService.findAll();
    }

    @GetMapping("create-employee")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("employee/create");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    @PostMapping("create-employee")
    public ModelAndView create(@Validated @ModelAttribute("employee") Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("employee/create");
        }
        employeeService.save(employee);
        ModelAndView modelAndView = new ModelAndView("employee/create");
        modelAndView.addObject("employee", employee);
        modelAndView.addObject("message","Create new employee sussesfully!");
        return modelAndView;
    }

    //    @GetMapping("employees")
//    public ModelAndView listEmployee(@ModelAttribute("s") String s, Pageable pageable) {
//        Page<Employee> employees;
//        if (s.isEmpty()) {
//            employees = employeeService.findAll(pageable);
//        } else {
//            employees = employeeService.findByFullNameContaining(s,pageable);
//        }
//        ModelAndView modelAndView = new ModelAndView("employee/list");
//        modelAndView.addObject("employees", employees);
//        return modelAndView;
//    }
    @GetMapping("employees")
    public ModelAndView list(Pageable pageable) {
        Page<Employee> employees = employeeService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("employee/list");
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @GetMapping("edit-employee/{id}")
    public ModelAndView editForm(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.finById(id);
        ModelAndView modelAndView = new ModelAndView("employee/edit");
        modelAndView.addObject("employee",employee);
        return modelAndView;
    }
    @PostMapping("edit-employee")
    public ModelAndView edit(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        ModelAndView modelAndView = new ModelAndView("employee/edit");
        modelAndView.addObject("employee",employee);
        modelAndView.addObject("message","Edit employee sussesfully!");
        return modelAndView;
    }
    @GetMapping("delete-employee/{id}")
    public ModelAndView deleteForm(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.finById(id);
        ModelAndView modelAndView = new ModelAndView("employee/delete");
        modelAndView.addObject("employee",employee);
        return modelAndView;
    }
    @PostMapping("delete-employee")
    public ModelAndView delete(@ModelAttribute("employee") Employee employee) {
        employeeService.remove(employee.getId());
        ModelAndView modelAndView = new ModelAndView("employee/list");
        return modelAndView;
    }
}
