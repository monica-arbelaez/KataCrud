import React, { useContext, useEffect } from 'react';
import Store from './Store';

const HOST_API = "http://localhost:8080/api";

const List = () => {
    const { dispatch, state: { todo } } = useContext(Store);
    const currentList = todo.list;

    useEffect(() => {
        fetch(HOST_API + "/todos")
            .then(response => response.json())
            .then((list) => {
                dispatch({ type: "update-list", list });
            });
    }, [dispatch]);


    const onDelete = (id) => {
        fetch(HOST_API + "/" + id + "/todo", {
            method: "DELETE"
        }).then((list) => {
            dispatch({ type: "delete-item", id });
        });
    };

    const onEdit = (todo) => {
        dispatch({ type: "edit-item", item: todo });
    };

    const onChange = (event, todo) => {
        const request = {
            nombre: todo.nombre,
            id: todo.id,
            completado: event.target.checked
        };
        fetch(HOST_API + "/todo", {
            method: "PUT",
            body: JSON.stringify(request),
            headers: {
                'Content-Type': 'application/json'
            }
        })
            .then(response => response.json())
            .then((todo) => {
                dispatch({ type: "update-item", item: todo });
            });
    };

    const decorationDone = {
        textDecoration: 'line-through'
    };
    return <div>
        <table>
            <thead>
                <tr className="etiqueta">
                    <td className="etiqueta">ID</td>
                    <td className="etiqueta">Tarea</td>
                    <td className="etiqueta">¿Completado?</td>
                </tr>
            </thead>
            <tbody>
                {currentList.map((todo) => {
                    return <tr key={todo.id} style={todo.completado ? decorationDone : {}}>
                        <td>{todo.id}</td>
                        <td>{todo.nombre}</td>
                        <td><input type="checkbox" defaultChecked={todo.completado} onChange={(event) => onChange(event, todo)}></input></td>
                        <td><button className="button"  onClick={() => onDelete(todo.id)}>Eliminar</button></td>
                        <td><button className="button" onClick={() => onEdit(todo)}>Editar</button></td>
                    </tr>;
                })}
            </tbody>
        </table>
    </div>;
};

export default List;