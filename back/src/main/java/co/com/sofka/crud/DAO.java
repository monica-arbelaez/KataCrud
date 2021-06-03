package co.com.sofka.crud;

import co.com.sofka.crud.dto.TodoDTO;
import co.com.sofka.crud.entity.Todo;

public interface DAO {

 public Todo save(TodoDTO todo);
 public  void delete(Long id);
 public Todo get (Long id);
}
