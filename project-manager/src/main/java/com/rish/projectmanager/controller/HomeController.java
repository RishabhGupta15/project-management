package com.rish.projectmanager.controller;

import com.rish.projectmanager.dao.EmployeeRepository;
import com.rish.projectmanager.dao.ProjectRepository;
import com.rish.projectmanager.entities.Employee;
import com.rish.projectmanager.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String displayHome(Model model){
        List<Project> projects = (List<Project>) projectRepository.findAll();
        List<Employee> employees = (List<Employee>) employeeRepository.findAll();
        model.addAttribute("projects", projects);
        model.addAttribute("employees", employees);
        return "home";
    }
}
