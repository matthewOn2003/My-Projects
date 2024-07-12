import axios from "axios";

const baseURL = 'http://localhost:8080/api/movies'; // Replace with your actual API endpoint

class MovieService {

    // GET
    static async getMovieById(movieId) {
        return (await axios.get(`${baseURL}/getMovie/${movieId}`)).data;
    }

    static async getAllMovies() {
        return (await axios.get(`${baseURL}/getAllMovies`)).data;
    }

    // POST
    static async addMovie(newMovie) {
        return (await axios.post(`${baseURL}/addMovie`, newMovie)).data;
    }

    // PUT (Update)
    static async updateMovieById(movieId, updatedMovie) {
        return (await axios.put(`${baseURL}/updateMovie/${movieId}`, updatedMovie)).data;
    }

    // DELETE
    static async deleteMovieById(movieId) {
        return (await axios.delete(`${baseURL}/deleteMovie/${movieId}`)).data;
    }
}

export default MovieService;
