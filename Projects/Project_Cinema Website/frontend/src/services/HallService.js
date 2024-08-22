import axios from "axios";

const baseURL = 'http://localhost:8080/api/halls'; // Replace with your actual API endpoint

class HallService {

    // GET 
    static async getHallById(hallId) {
        return (await axios.get(`${baseURL}/getHall/${hallId}`)).data;
    }

    static async getAllHalls() {
        return (await axios.get(`${baseURL}/getAllHalls`)).data;
    }

    static async getHallsByCinemaId(cinemaId) {
        return (await axios.get(`${baseURL}/getHallsByCinemaId/${cinemaId}`)).data;
    }

    // POST
    static async addHall(newHall) {
        return (await axios.post(`${baseURL}/addHall`, newHall)).data;
    }

    // PUT (Update)
    static async updateHallById(hallId, updatedHall) {
        return (await axios.put(`${baseURL}/updateHall/${hallId}`, updatedHall)).data;
    }

    // DELETE
    static async deleteHallById(hallId) {
        return (await axios.delete(`${baseURL}/deleteHall/${hallId}`)).data;
    }
}

export default HallService;
