// import React, { useContext, useRef, useState } from 'react';
// import Store from './Store';

// const HOST_API = "http://localhost:8080/api";

// const LogitForm = () => {
//     const formRef = useRef(null);
//     const { dispatch, state: { todoListUp} } = useContext(Store);
//     const item = todoListUp.item;
//     const [state, setState] = useState(item);

//     const onAdd = (event) => {
//         event.preventDefault();

//         const request = {
//             name: state.name,
//             id: null,

//         };

//         fetch(HOST_API + "/todo", {
//             method: "POST",
//             body: JSON.stringify(request),
//             headers: {
//                 'Content-Type': 'application/json'
//             }
//         })
//             .then(response => response.json())
//             .then((todoList) => {
//                 dispatch({ type: "todotUp", item: todo });
//                 setState({ todoList: "" });
//                 formRef.current.reset();
//             });

//     };

//     return (
//         <div>
//             <form ref={formRef}>
//                 <input
//                     type="text"
//                     name="name"
//                     placeholder="¿Lista de TO-DO"
//                     defaultValue={item}
//                     onChange={(event)=>{
//                         setState({...state name: event.target.value})
//                     }}
//                 ></input>
//                 <button onClick={onAdd}>Crear</button>
//             </form>
//         </div>
//     )
// }
// export default LogitForm;