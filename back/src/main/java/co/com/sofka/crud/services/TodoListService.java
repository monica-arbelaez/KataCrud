package co.com.sofka.crud.services;

import co.com.sofka.crud.DAOList;
import co.com.sofka.crud.entity.TodoList;
import co.com.sofka.crud.repository.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoListService implements DAOList {

    @Autowired
    private TodoListRepository repository;

    @Override
    public Iterable<TodoList> List() {
        return repository.findAll();
    }
    @Override
    public TodoList save(TodoList todoList){
        return repository.save(todoList);
    }
    @Override
    public void delete(Long id){
        repository.deleteById(id);
    }
    @Override
    public TodoList get(Long id){
        return repository.findById(id).orElseThrow() ;
    }
}