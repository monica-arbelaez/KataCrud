package co.com.sofka.crud.entity;

import javax.persistence.*;

@Table(name = "todo")
@Entity()
public class Todo {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private boolean completed;
    private String grouplist;

    public String getGrouplist() {
        return grouplist;
    }

    public void setGrouplist(String grouplist) {
        this.grouplist = grouplist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
