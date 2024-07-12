import axios from 'axios';

const client = axios.create({
    baseURL: 'http://localhost:8080/api', // Replace with your actual API endpoint
    timeout: 10000, // Adjust the timeout as needed
    headers: {
        'Content-Type': 'application/json'
    }
});

export default client;