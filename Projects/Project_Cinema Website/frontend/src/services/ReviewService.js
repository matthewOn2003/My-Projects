import axios from "axios";

const baseURL = 'http://localhost:8080/api/reviews'; // Replace with your actual API endpoint

class ReviewService {

    // GET
    static async getReviewById(reviewId) {
        const response = await axios.get(`${baseURL}/getReview/${reviewId}`);
        return response.data;
    }

    static async getAllReviews() {
        const response = await axios.get(`${baseURL}/getAllReviews`);
        return response.data;
    }

    static async getReviewsByTarget(targetId, targetTable) {
        const response = await axios.get(`${baseURL}/getReviewsByTarget/${targetId}/${targetTable}`);
        return response.data;
    }

    static async getReviewsByUser(userId) {
        const response = await axios.get(`${baseURL}/getReviewsByUser/${userId}`);
        return response.data;
    }



    // POST
    static async addReview(newReview) {
        const response = await axios.post(`${baseURL}/addReview`, newReview);
        return response.data;
    }

    // PUT (Update)
    static async updateReviewById(reviewId, updatedReview) {
        const response = await axios.put(`${baseURL}/updateReview/${reviewId}`, updatedReview);
        return response.data;
    }

    // DELETE
    static async deleteReviewById(reviewId) {
        const response = await axios.delete(`${baseURL}/deleteReview/${reviewId}`);
        return response.data;
    }
}

export default ReviewService;
