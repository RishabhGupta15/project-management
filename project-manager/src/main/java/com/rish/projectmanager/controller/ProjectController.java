package com.rish.projectmanager.controller;

import com.rish.projectmanager.dao.EmployeeRepository;
import com.rish.projectmanager.dao.ProjectRepository;
import com.rish.projectmanager.entities.Employee;
import com.rish.projectmanager.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/projects")
@Controller
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping()
    public String displayProjects(Model model){
        List<Project> projects = (List<Project>) projectRepository.findAll();
        model.addAttribute("projects", projects);
        return "project/list-projects";
    }

    @GetMapping("/new")
    public String addNewProject(Model model){
        Project project = new Project();
        List<Employee> employees = (List<Employee>) employeeRepository.findAll();
        model.addAttribute("project", project);
        model.addAttribute("allEmployees", employees);
        return "project/new-project";
    }

    @PostMapping("/save")
    public String saveproject(Project project, @RequestParam List<Long> employees){
        projectRepository.save(project);
        Iterable<Employee> chosenEmployee = employeeRepository.findAllById(employees);
        for(Employee e: chosenEmployee){
            e.setProject(project);
            employeeRepository.save(e);
        }
        return "redirect:/projects/new";
    }
}
