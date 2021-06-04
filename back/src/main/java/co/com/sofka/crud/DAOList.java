package co.com.sofka.crud;


import co.com.sofka.crud.entity.TodoList;

public interface DAOList {

    Iterable<TodoList> List();
    public TodoList save(TodoList todoList);
    public  void delete(Long idList);
    public TodoList get (Long idList);

}
