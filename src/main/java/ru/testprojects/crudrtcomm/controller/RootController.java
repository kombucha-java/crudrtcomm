package ru.testprojects.crudrtcomm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.testprojects.crudrtcomm.repository.ToDoRepository;

@Controller
public class RootController {
    private ToDoRepository repository;

    @Autowired
    public RootController(ToDoRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/main")
    public String root(Model model) {
        model.addAttribute("todos", repository.getAll());
        return "main";
    }
}
