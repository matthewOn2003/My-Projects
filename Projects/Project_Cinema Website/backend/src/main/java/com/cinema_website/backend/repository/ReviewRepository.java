package com.cinema_website.backend.repository;

import com.cinema_website.backend.dto.ReviewDTO;
import com.cinema_website.backend.mapper.ReviewMapper;
import com.cinema_website.backend.model.Review;
import com.cinema_website.backend.service.UserService;
import com.cinema_website.backend.util.ReviewUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ReviewRepository {

    private final ReviewMapper reviewMapper;
    private final UserService userService;

    public ReviewRepository(ReviewMapper reviewMapper, UserService userService) {
        this.reviewMapper = reviewMapper;
        this.userService = userService;
    }

    // SELECT
    public ReviewDTO getReviewById(int reviewId) {
        Review review = reviewMapper.getReviewById(reviewId);
        return ReviewUtils.toReviewDTO(review, userService);
    }

    public List<ReviewDTO> getAllReviews() {
        try {
            List<Review> reviews = reviewMapper.getAllReviews();
            List<ReviewDTO> reviewDTOs = new ArrayList<>();

            for (Review review : reviews) {
                ReviewDTO dto = ReviewUtils.toReviewDTO(review, userService);
                reviewDTOs.add(dto);
            }

            return reviewDTOs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ReviewDTO> getReviewsByTarget(int targetId, String targetTable) {
        try {
            List<Review> reviews = reviewMapper.getReviewsByTarget(targetId, targetTable);
            List<ReviewDTO> reviewDTOs = new ArrayList<>();

            for (Review review : reviews) {
                ReviewDTO dto = ReviewUtils.toReviewDTO(review, userService);
                reviewDTOs.add(dto);
            }

            return reviewDTOs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public List<ReviewDTO> getReviewsByUser(int userId) {
        try {
            List<Review> reviews = reviewMapper.getReviewsByUser(userId);
            List<ReviewDTO> reviewDTOs = new ArrayList<>();

            for (Review review : reviews) {
                ReviewDTO dto = ReviewUtils.toReviewDTO(review, userService);
                reviewDTOs.add(dto);
            }

            return reviewDTOs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    // INSERT
    public boolean addReview(ReviewDTO reviewDTO) {
        try {
            Review review = ReviewUtils.toReview(reviewDTO);
            return reviewMapper.addReview(review);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // UPDATE
    public boolean updateReviewById(int reviewId, ReviewDTO updatedReview) {
        try {
            Review review = ReviewUtils.toReview(updatedReview);
            return reviewMapper.updateReviewById(reviewId, review);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // DELETE
    public boolean deleteReviewById(int reviewId) {
        try {
            return reviewMapper.deleteReviewById(reviewId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
