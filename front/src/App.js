import React from 'react';
import Form from './components/Form';
import List from './components/List';
import TodoListForm from'./components/TodoListForm';
import { StoreProvider } from "./components/Store"

function App() {
  return <StoreProvider>
    <div className="container">
      <h1>To-Do List</h1>
      <Form />
      <List />
      <h1>Listas Tareas</h1>
      <TodoListForm />
    </div>
  </StoreProvider>
}

export default App;
