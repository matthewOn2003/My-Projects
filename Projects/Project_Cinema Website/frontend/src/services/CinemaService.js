import axios from "axios";

const baseURL = 'http://localhost:8080/api/cinemas'; // Replace with your actual API endpoint

class CinemaService {

    // GET
    static async getCinemaById(cinemaId) {
        const response = await axios.get(`${baseURL}/getCinema/${cinemaId}`);
        return response.data;
    }

    static async getAllCinemas() {
        const response = await axios.get(`${baseURL}/getAllCinemas`);
        return response.data;
    }

    // POST
    static async addCinema(newCinema) {
        const response = await axios.post(`${baseURL}/addCinema`, newCinema);
        return response.data;
    }

    // PUT (Update)
    static async updateCinemaById(cinemaId, updatedCinema) {
        const response = await axios.put(`${baseURL}/updateCinema/${cinemaId}`, updatedCinema);
        return response.data;
    }

    // DELETE
    static async deleteCinemaById(cinemaId) {
        const response = await axios.delete(`${baseURL}/deleteCinema/${cinemaId}`);
        return response.data;
    }
}

export default CinemaService;
