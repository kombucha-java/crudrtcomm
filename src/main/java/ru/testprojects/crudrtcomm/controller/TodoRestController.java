package ru.testprojects.crudrtcomm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.testprojects.crudrtcomm.model.ToDo;
import ru.testprojects.crudrtcomm.repository.ToDoRepository;

import java.net.URI;
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

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody ToDo toDo, @PathVariable("id") int id) {
        repository.save(toDo);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ToDo> create(@RequestBody ToDo toDo) {
        ToDo created = repository.save(toDo);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }
}
