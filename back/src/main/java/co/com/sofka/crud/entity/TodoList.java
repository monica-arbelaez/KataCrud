package co.com.sofka.crud.entity;

import co.com.sofka.crud.dto.TodoDTO;

import javax.persistence.*;
import java.util.List;

@Entity()
@Table(name = "todoList")
public class TodoList {
    @Id
    @GeneratedValue
    @Column(unique = true, nullable = false)
    private Long id;
    private String nameList;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "grouplist")
    private List<Todo> todos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameList() {
        return nameList;
    }

    public void setNameList(String nameList) {
        this.nameList = nameList;
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }
}
