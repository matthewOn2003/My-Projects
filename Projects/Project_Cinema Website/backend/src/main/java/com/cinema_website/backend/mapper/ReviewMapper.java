package com.cinema_website.backend.mapper;

import com.cinema_website.backend.model.Review;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReviewMapper {
    Review getReviewById(int reviewId);
    List<Review> getAllReviews();
    List<Review> getReviewsByTarget(int targetId, String targetTable);

    List<Review> getReviewsByUser(int userId);
    boolean addReview(Review review);
    boolean updateReviewById(@Param("reviewId") int reviewId, @Param("review") Review review);
    boolean deleteReviewById(int reviewId);
}
