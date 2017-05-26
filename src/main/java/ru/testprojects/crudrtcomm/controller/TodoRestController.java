package ru.testprojects.crudrtcomm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.testprojects.crudrtcomm.model.ToDo;
import ru.testprojects.crudrtcomm.repository.ToDoRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(TodoRestController.REST_URL)
public class TodoRestController {
    static final String REST_URL = "/rest";

    private final ToDoRepository repository;

    @Autowired
    public TodoRestController(ToDoRepository repository) {
        this.repository = repository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ToDo> getAll() {
        return repository.getAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ToDo get(@PathVariable("id") int id) {
        return repository.get(id);
    }

    @DeleteMapping(value = "/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return repository.delete(id);
    }

    @PostMapping
    public ResponseEntity<String> create(@Valid ToDo toDo, BindingResult result) {
        if (result.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            result.getFieldErrors().forEach(fe -> sb.append(fe.getField()).append(" ").append(fe.getDefaultMessage()).append("<br>"));
            return new ResponseEntity<>(sb.toString(), HttpStatus.UNPROCESSABLE_ENTITY);
        }

        repository.save(toDo);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
