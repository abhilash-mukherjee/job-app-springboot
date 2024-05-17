package com.learningSpringBoot.jobApp.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyID);
}
