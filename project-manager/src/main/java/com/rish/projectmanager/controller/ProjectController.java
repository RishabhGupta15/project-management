package com.rish.projectmanager.controller;

import com.rish.projectmanager.dao.ProjectRepository;
import com.rish.projectmanager.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/projects")
@Controller
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping("/new")
    public String addNewProject(Model model){
        Project project = new Project();
        model.addAttribute("project", project);
        return "new-project";
    }

    @PostMapping("/save")
    public String saveproject(Model model, Project project){
        projectRepository.save(project);
        return "redirect:/projects/new";
    }
}
