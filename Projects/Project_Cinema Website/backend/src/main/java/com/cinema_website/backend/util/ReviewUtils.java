package com.cinema_website.backend.util;

import com.cinema_website.backend.dto.ReviewDTO;
import com.cinema_website.backend.model.Review;
import com.cinema_website.backend.service.UserService;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@SuppressWarnings("all")
public class ReviewUtils {

    // Convert Strings to Timestamps
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    // parse Review to ReviewDTO
    public static ReviewDTO toReviewDTO(Review review, UserService userService) {
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setReviewId(review.getReviewId());
        reviewDTO.setUserDTO(userService.getUser(review.getUserId()));
        reviewDTO.setTargetId(review.getTargetId());
        reviewDTO.setTargetTable(review.getTargetTable());
        reviewDTO.setTargetName(review.getTargetName());
        reviewDTO.setRating(review.getRating());
        reviewDTO.setReviewText(review.getReviewText());

        // Convert Timestamps to String format (assuming format "yyyy-MM-dd HH:mm:ss")
        if (review.getReviewDate() != null) {
            reviewDTO.setReviewDate(dateFormat.format(review.getReviewDate()));
        }
        if (review.getCreatedAt() != null) {
            reviewDTO.setCreatedAt(dateFormat.format(review.getCreatedAt()));
        }
        if (review.getUpdatedAt() != null) {
            reviewDTO.setUpdatedAt(dateFormat.format(review.getUpdatedAt()));
        }

        return reviewDTO;
    }

    // parse ReviewDTO to Review
    public static Review toReview(ReviewDTO reviewDTO) {
        Review review = new Review();
        review.setReviewId(reviewDTO.getReviewId());
        review.setUserId(reviewDTO.getUserDTO().getUserId());
        review.setTargetId(reviewDTO.getTargetId());
        review.setTargetTable(reviewDTO.getTargetTable());
        review.setTargetName(reviewDTO.getTargetName());
        review.setRating(reviewDTO.getRating());
        review.setReviewText(reviewDTO.getReviewText());

        try {
            if (reviewDTO.getReviewDate() != null) {
                review.setReviewDate(new Timestamp(dateFormat.parse(reviewDTO.getReviewDate()).getTime()));
            }
            if (reviewDTO.getCreatedAt() != null) {
                review.setCreatedAt(new Timestamp(dateFormat.parse(reviewDTO.getCreatedAt()).getTime()));
            }
            if (reviewDTO.getUpdatedAt() != null) {
                review.setUpdatedAt(new Timestamp(dateFormat.parse(reviewDTO.getUpdatedAt()).getTime()));
            }
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception properly in real scenarios
        }

        return review;
    }
}
