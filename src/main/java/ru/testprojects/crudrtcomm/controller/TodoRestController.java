package ru.testprojects.crudrtcomm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.testprojects.crudrtcomm.model.ToDo;
import ru.testprojects.crudrtcomm.repository.ToDoRepository;

import java.net.URI;
import java.time.LocalDateTime;
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
    public ResponseEntity<ToDo> createOrUpdate
            (@RequestParam("id") Integer id,
             @RequestParam("description") String description,
             @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
             @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        if (description == null || startDate == null || endDate == null) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        ToDo toDo = new ToDo(id, description, startDate, endDate);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(toDo.getId()).toUri();
        repository.save(toDo);
        return ResponseEntity.created(uriOfNewResource).body(toDo);
    }
}
