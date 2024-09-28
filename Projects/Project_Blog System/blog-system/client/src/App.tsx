import React, { useEffect } from 'react';
import { useState } from 'react';
import logo from './logo.svg';
import './App.css';
import axios from '../node_modules/axios/index';

import User from './model/User';


function App() {

  let [users, setUsers] = useState<User[]>([]);
  let [message, setMessage] = useState("");

  useEffect(() => {
    console.log(users);

    if (users.length > 0) {
      setMessage(JSON.stringify(users));
    }

  }, [users])

  useEffect(() => {
    console.log(message);
  }, [message])

  return (
    <div className="App">
      <button onClick={() => {
        axios.get('http://localhost:9000/users').then(response => {
          const users = response.data.filter((user: User) => user.status === "active");
          setUsers(users);

        }).catch(error => {
          console.error('Error fetching data:', error);
          setMessage('Error fetching data'); // 设置错误消息
        });
      }}>
        Get Message
      </button>
      <div>{message}</div>
    </div>
  );
}

export default App;
