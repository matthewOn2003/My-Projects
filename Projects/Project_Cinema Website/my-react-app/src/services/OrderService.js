import axios from 'axios';

const baseURL = 'http://localhost:8080/api/orders'; // Replace with your actual API endpoint

class OrderService {

    // GET
    static async getOrderById(orderId) {
        return (await axios.get(`${baseURL}/getOrder/${orderId}`)).data;
    }

    static async getOrderByOrderNumber(orderNumber) {
        return (await axios.get(`${baseURL}/getOrderByOrderNumber/${orderNumber}`)).data;
    }

    static async getAllOrders() {
        return (await axios.get(`${baseURL}/getAllOrders`)).data;
    }

    // POST
    static async addOrder(newOrder) {
        return (await axios.post(`${baseURL}/addOrder`, newOrder)).data;
    }

    // PUT (Update)
    static async updateOrder(orderId, updatedOrder) {
        return (await axios.put(`${baseURL}/updateOrder/${orderId}`, updatedOrder)).data;
    }

    // DELETE
    static async deleteOrder(orderId) {
        return (await axios.delete(`${baseURL}/deleteOrder/${orderId}`)).data;
    }
}

export default OrderService;
