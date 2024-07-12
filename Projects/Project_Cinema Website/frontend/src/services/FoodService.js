import axios from "axios";

const baseURL = 'http://localhost:8080/api/foods'; // Replace with your actual API endpoint

class FoodService {

    // GET
    static async getFoodById(foodId) {
        return (await axios.get(`${baseURL}/getFood/${foodId}`)).data;
    }

    static async getAllFoods() {
        return (await axios.get(`${baseURL}/getAllFoods`)).data;
    }

    static async getAllCategories() {
        return (await axios.get(`${baseURL}/getAllCategories`)).data;
    }

    // POST
    static async addFood(newFood) {
        return (await axios.post(`${baseURL}/addFood`, newFood)).data;
    }

    // PUT (Update)
    static async updateFoodById(foodId, updatedFood) {
        return (await axios.put(`${baseURL}/updateFood/${foodId}`, updatedFood)).data;
    }

    // DELETE
    static async deleteFoodById(foodId) {
        return (await axios.delete(`${baseURL}/deleteFood/${foodId}`)).data;
    }
}

export default FoodService;
