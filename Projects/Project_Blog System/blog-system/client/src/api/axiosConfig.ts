import axios from '../../node_modules/axios/index';

const client = axios.create({
  baseURL: 'http://localhost:9000/api', // Replace with your actual API endpoint
  timeout: 10000, // Adjust the timeout as needed
  headers: {
    'Content-Type': 'application/json'
  }
});

export default client;