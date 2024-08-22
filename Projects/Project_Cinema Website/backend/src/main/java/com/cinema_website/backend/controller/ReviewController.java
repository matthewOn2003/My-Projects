package com.cinema_website.backend.controller;

import com.cinema_website.backend.dto.ReviewDTO;
import com.cinema_website.backend.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // GET
    @GetMapping("/getReview/{reviewId}")
    public ResponseEntity<ReviewDTO> getReviewById(@PathVariable int reviewId) {
        ReviewDTO review = reviewService.getReviewById(reviewId);
        if (review != null) {
            return new ResponseEntity<>(review, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllReviews")
    public ResponseEntity<List<ReviewDTO>> getAllReviews() {
        List<ReviewDTO> reviewList = reviewService.getAllReviews();
        if (reviewList != null && !reviewList.isEmpty()) {
            return new ResponseEntity<>(reviewList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getReviewsByTarget/{targetId}/{targetTable}")
    public ResponseEntity<List<ReviewDTO>> getReviewsByTarget(@PathVariable int targetId, @PathVariable String targetTable) {
        List<ReviewDTO> reviewList = reviewService.getReviewsByTarget(targetId, targetTable);
        if (reviewList != null && !reviewList.isEmpty()) {
            return new ResponseEntity<>(reviewList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getReviewsByUser/{userId}")
    public ResponseEntity<List<ReviewDTO>> getReviewsByUser(@PathVariable int userId) {
        List<ReviewDTO> reviewList = reviewService.getReviewsByUser(userId);
        if (reviewList != null && !reviewList.isEmpty()) {
            return new ResponseEntity<>(reviewList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }



    // POST
    @PostMapping("/addReview")
    public ResponseEntity<Boolean> addReview(@RequestBody ReviewDTO reviewDTO) {
        boolean result = reviewService.addReview(reviewDTO);
        if (result) {
            return new ResponseEntity<>(true, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }

    // PUT
    @PutMapping("/updateReview/{reviewId}")
    public ResponseEntity<Boolean> updateReview(@PathVariable int reviewId, @RequestBody ReviewDTO updatedReview) {
        boolean result = reviewService.updateReviewById(reviewId, updatedReview);
        if (result) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    // DELETE
    @DeleteMapping("/deleteReview/{reviewId}")
    public ResponseEntity<Boolean> deleteReview(@PathVariable int reviewId) {
        boolean result = reviewService.deleteReviewById(reviewId);
        if (result) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }
}
