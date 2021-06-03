package co.com.sofka.crud.mapper;

import co.com.sofka.crud.Todo;
import co.com.sofka.crud.dto.TodoDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

//Esta etiqueta dice que la interfaz sera un mapper y es de spring
@Mapper(componentModel = "spring")
public interface TodoMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "completed", target = "completed"),
            @Mapping(source = "groupListId", target ="groupListId")

    })
    TodoDTO aTodoDto(Todo todo);

    Iterable<TodoDTO> toTodoDTOs (Iterable<Todo> todos);

    @InheritInverseConfiguration
    Todo aTodo(TodoDTO todoDTO);
}
