import axios from "axios";

const baseURL = 'http://localhost:8080/api/seats'; // Replace with your actual API endpoint

class SeatService {

    // GET
    static async getSeatById(seatId) {
        return (await axios.get(`${baseURL}/getSeat/${seatId}`)).data;
    }

    static async getAllSeats() {
        return (await axios.get(`${baseURL}/getAllSeats`)).data;
    }

    static async getSeatsByHallId(hallId) {
        return (await axios.get(`${baseURL}/getSeatsByHallId/${hallId}`)).data;
    }

    // POST
    static async addSeat(newSeat) {
        return (await axios.post(`${baseURL}/addSeat`, newSeat)).data;
    }

    // PUT (Update)
    static async updateSeatById(seatId, updatedSeat) {
        return (await axios.put(`${baseURL}/updateSeat/${seatId}`, updatedSeat)).data;
    }

    // DELETE
    static async deleteSeatById(seatId) {
        return (await axios.delete(`${baseURL}/deleteSeat/${seatId}`)).data;
    }
}

export default SeatService;
