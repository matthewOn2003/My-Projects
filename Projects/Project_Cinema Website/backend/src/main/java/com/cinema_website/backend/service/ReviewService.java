package com.cinema_website.backend.service;

import com.cinema_website.backend.dto.ReviewDTO;
import com.cinema_website.backend.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    // GET
    public ReviewDTO getReviewById(int reviewId) {
        return reviewRepository.getReviewById(reviewId);
    }

    public List<ReviewDTO> getAllReviews() {
        return reviewRepository.getAllReviews();
    }

    public List<ReviewDTO> getReviewsByTarget(int targetId, String targetTable) {
        return reviewRepository.getReviewsByTarget(targetId, targetTable);
    }
    public List<ReviewDTO> getReviewsByUser(int userId) {
        return reviewRepository.getReviewsByUser(userId);
    }

    // INSERT
    public boolean addReview(ReviewDTO reviewDTO) {
        return reviewRepository.addReview(reviewDTO);
    }

    // UPDATE
    public boolean updateReviewById(int reviewId, ReviewDTO updatedReview) {
        return reviewRepository.updateReviewById(reviewId, updatedReview);
    }

    // DELETE
    public boolean deleteReviewById(int reviewId) {
        return reviewRepository.deleteReviewById(reviewId);
    }
}
