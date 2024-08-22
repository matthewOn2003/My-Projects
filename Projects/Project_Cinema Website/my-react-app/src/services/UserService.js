import axios from "axios";

const baseURL = 'http://localhost:8080/api/users'; // Replace with your actual API endpoint

class UserService {

    // GET
    static async getUserById(userId) {
        const response = await axios.get(`${baseURL}/getUser/${userId}`);
        return response.data;
    }

    static async getAllUsers() {
        const response = await axios.get(`${baseURL}/getAllUsers`);
        return response.data;
    }

    // POST
    static async addUser(newUser) {
        const response = await axios.post(`${baseURL}/addUser`, newUser);
        return response.data;
    }

    // PUT (Update)
    static async updateUserById(userId, updatedUser) {
        const response = await axios.put(`${baseURL}/updateUser/${userId}`, updatedUser);
        return response.data;
    }

    // DELETE
    static async deleteUserById(userId) {
        const response = await axios.delete(`${baseURL}/deleteUser/${userId}`);
        return response.data; // Assuming backend returns status 200 for success
    }

    // Authentication
    static async authenticateUser(userCredentials) {
        const response = await axios.post(`${baseURL}/authenticate`, userCredentials);
        return response.data;
    }
}

export default UserService;