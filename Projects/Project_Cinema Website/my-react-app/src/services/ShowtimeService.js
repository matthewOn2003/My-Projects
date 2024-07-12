import axios from "axios";

const baseURL = 'http://localhost:8080/api/showtimes'; // Replace with your actual API endpoint

class ShowtimeService {

    // GET
    static async getShowtimeById(showtimeId) {
        return (await axios.get(`${baseURL}/getShowtime/${showtimeId}`)).data;
    }

    static async getAllShowtimes() {
        return (await axios.get(`${baseURL}/getAllShowtimes`)).data;
    }

    static async getShowtimesByMovieId(movieId) {
        return (await axios.get(`${baseURL}/getShowtimesByMovieId/${movieId}`)).data;
    }

    static async getShowtimesByCinemaId(cinemaId) {
        return (await axios.get(`${baseURL}/getShowtimesByCinemaId/${cinemaId}`)).data;
    }

    static async getShowtimesByHallId(hallId) {
        return (await axios.get(`${baseURL}/getShowtimesByHallId/${hallId}`)).data;
    }

    static async getShowtimesByMovieDateExperience(movieId, showDate, experienceType) {
        const encodedShowDate = encodeURIComponent(showDate); // Ensure showDate is properly encoded
        return (await axios.get(`${baseURL}/getShowtimesByMovieDateExperience/${movieId}/${encodedShowDate}/${experienceType}`)).data;
    }

    static async getShowtimesExperiences(movieId, showDate) {
        const encodedShowDate = encodeURIComponent(showDate); // Ensure showDate is properly encoded
        return (await axios.get(`${baseURL}/getShowtimesExperiences/${movieId}/${encodedShowDate}`)).data;
    }

    // POST
    static async addShowtime(newShowtime) {
        return (await axios.post(`${baseURL}/addShowtime`, newShowtime)).data;
    }

    // PUT (Update)
    static async updateShowtimeById(showtimeId, updatedShowtime) {
        return (await axios.put(`${baseURL}/updateShowtime/${showtimeId}`, updatedShowtime)).data;
    }

    // DELETE
    static async deleteShowtimeById(showtimeId) {
        return (await axios.delete(`${baseURL}/deleteShowtime/${showtimeId}`)).data;
    }
}

export default ShowtimeService;
