package co.com.sofka.crud.services;

import co.com.sofka.crud.dto.TodoDTO;
import co.com.sofka.crud.entity.Todo;
import co.com.sofka.crud.mapper.TodoMapper;
import co.com.sofka.crud.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;
    @Autowired
    private TodoMapper mapper;

    public Iterable<TodoDTO> list(){
        Iterable<Todo> todos= repository.findAll();
        return mapper.toTodoDTOs(todos);
    }

    public TodoDTO save(TodoDTO todoDTO){
        Todo todo = mapper.aTodo(todoDTO);
        return mapper.aTodoDto(repository.save(todo));
    }

    public void delete(Long id){
        repository.delete(mapper.aTodo(get(id)));
    }

    public TodoDTO get(Long id){
         return mapper.aTodoDto(repository.findById(id).orElseThrow()) ;
    }

}
