import React from 'react';
import Form from './components/Form';
import List from './components/List';
import { StoreProvider } from "./components/Store"

function App() {
  return <StoreProvider>
    <div className="container">
      <h3>To-Do List</h3>
      <Form />
      <List />
      <h3>Listas Tareas</h3>
    </div>
  </StoreProvider>
}

export default App;
