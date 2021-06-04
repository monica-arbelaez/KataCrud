package co.com.sofka.crud.controller;

import co.com.sofka.crud.DAOList;
import co.com.sofka.crud.entity.TodoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoListController {
    @Autowired
    private DAOList service;

    @GetMapping(value = "api/todoList")
    public Iterable<TodoList> list(){
        return service.List();
    }

    @PostMapping(value = "api/todoList")
    public TodoList save(@RequestBody TodoList todoList){
        return service.save(todoList);
    }

    @PutMapping(value = "api/todoList")
    public TodoList update(@RequestBody TodoList todoList){
        if(todoList.getId() != null){
            return service.save(todoList);
        }
        throw new RuntimeException("No existe el id para actualziar");
    }

    @DeleteMapping(value = "api/{id}/todoList")
    public void delete(@PathVariable("idList")Long idList){ service.delete(idList);}

    @GetMapping(value = "api/{idList}/todoList")
    public TodoList get(@PathVariable("idList") Long idList){ return service.get(idList);}

}

