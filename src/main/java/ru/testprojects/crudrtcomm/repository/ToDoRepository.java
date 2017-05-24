package ru.testprojects.crudrtcomm.repository;

import ru.testprojects.crudrtcomm.model.ToDo;

import java.util.List;

public interface ToDoRepository {

    ToDo get(int id);

    List<ToDo> getAll();

    boolean delete(int id);

    ToDo save(ToDo toDo);

}
