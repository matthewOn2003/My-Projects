import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Login from './pages/Login';



function App() {

  const [message, setMessage] = useState('');
  const [count, setCount] = useState(0);

  // Define the async function to fetch data
  // const getResponse = async () => {
  //   try {
  //     const response = await axios.get('http://localhost:5000/');
  //     setMessage(response.data + count);
  //     setCount(a => a + 1);
  //   } catch (error) {
  //     console.error(error);
  //   }
  // };

  // useEffect(() => {
  //   console.log(message);
  // }, [message])


  return (
    <div className="App">
      <Login />
    </div>
  );
}

export default App;
