package co.com.sofka.crud.mapper;

import co.com.sofka.crud.dto.TodoDTO;
import co.com.sofka.crud.entity.Todo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

//Esta etiqueta dice que la interfaz sera un mapper y es de spring
@Mapper(componentModel = "spring")
public interface TodoMapper {

    @Mappings({
            @Mapping(source = "grouplist", target = "grupo"),
            @Mapping(source = "name", target = "nombre"),
            @Mapping(source = "completed", target = "completado"),
    })
    TodoDTO aTodoDto(Todo todo);

    Iterable<TodoDTO> toTodoDTOs (Iterable<Todo> todos);

    @InheritInverseConfiguration
    Todo aTodo(TodoDTO todoDTO);

}
