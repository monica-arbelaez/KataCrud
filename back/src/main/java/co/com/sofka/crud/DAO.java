package co.com.sofka.crud;

import co.com.sofka.crud.dto.TodoDTO;
import co.com.sofka.crud.entity.Todo;

public interface DAO {

 Iterable<TodoDTO> list();
 public TodoDTO save(TodoDTO todo);
 public  void delete(Long id);
 public TodoDTO get(Long id);
}
