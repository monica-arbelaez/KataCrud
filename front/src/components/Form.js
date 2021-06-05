import React, { useContext, useRef, useState } from 'react';
import Store from './Store';

const HOST_API = "http://localhost:8080/api";

const Form = () => {
    const formRef = useRef(null);
    const { dispatch, state: { todo } } = useContext(Store);
    const item = todo.item;
    const [state, setState] = useState(item);

    const onAdd = (event) => {
        event.preventDefault();

        const request = {
            nombre: state.nombre,
            id: null,
            completado: false
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
                dispatch({ type: "add-item", item: todo });
                setState({ nombre: "" });
                formRef.current.reset();
            });
    };

    const onEdit = (event) => {
        event.preventDefault();

        const request = {
            nombre: state.nombre,
            id: item.id,
            iscompletado: item.iscompletado
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
                setState({ nombre: "" });
                formRef.current.reset();
            });
    };

    return <form ref={formRef}>
        <input
            type="text"
            nombre="nombre"
            placeholder="¿Qué piensas hacer hoy?"
            defaultValue={item.nombre}
            onChange={(event) => {
                setState({ ...state, nombre: event.target.value });
            }}></input>
        {item.id && <button onClick={onEdit}>Actualizar</button>}
        {!item.id && <button onClick={onAdd}>Crear</button>}
    </form>;
};
export default Form;