import React, { useContext, useRef, useState } from 'react';
import Store from './Store';

const HOST_API = "http://localhost:8080/api";

const TodoListForm = () => {

    const formRef = useRef(null);
    const { dispatch, state: { todo} } = useContext(Store);
    const item = todo.item;
    const [state, setState] = useState(item);

    const onAdd = (event) => {
        event.preventDefault();
        const request = {
            nombre: state.nombre,
            id: null,

        };

        fetch(HOST_API + "/todo", {
            method: "POST",
            body: JSON.stringify(request),
            headers: {
                'Content-Type': 'application/json'
            }
        })
            .then(response => response.json())
            .then((todo) => {
                dispatch({ type: "add-todo-list", item: {todo} });
                setState({ nombre: "" });
                formRef.current.reset();
            });

    };

    return (
        <div>
            <form ref={formRef}>
                <input className="inputTodo"
                    type="text"
                    nombre="nombre"
                    placeholder="Listas de Tareas"
                    defaultValue={item.nombre}
                    onChange={(event)=>{
                        setState({...state, nombre: event.target.value})
                    }}
                ></input>
                <button className="button" onClick={onAdd}>Crear</button>
            </form>
        </div>
    )
}
export default TodoListForm;