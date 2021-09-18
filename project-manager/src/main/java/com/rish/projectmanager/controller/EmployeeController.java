package com.rish.projectmanager.controller;


import com.rish.projectmanager.dao.EmployeeRepository;
import com.rish.projectmanager.entities.Employee;
import com.rish.projectmanager.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/employees")
@Controller
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/new")
    public String createNewEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new-employee";
    }
    @PostMapping("/save")
    public String saveEmployee(Model model, Employee employee){
        employeeRepository.save(employee);
        return "redirect:/employees/new";
    }
}
