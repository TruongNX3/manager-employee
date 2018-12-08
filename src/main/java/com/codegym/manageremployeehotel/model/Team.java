package com.codegym.manageremployeehotel.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String discription;

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }

    @OneToMany(targetEntity = Employee.class)
    private Set<Employee> employeeSet;



    public Team() {
    }

    public Team(String name, String discription) {
        this.name = name;
        this.discription = discription;
    }
    @Override
    public String toString() {
        return String.format("Team[id='%d',name='%s',discription='%s']",id,name,discription);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
}

