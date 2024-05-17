package com.learningSpringBoot.jobApp.review.impl;

import com.learningSpringBoot.jobApp.review.Review;
import com.learningSpringBoot.jobApp.review.ReviewRepository;
import com.learningSpringBoot.jobApp.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    ReviewRepository reviewRepository;
    @Override
    public List<Review> getAllReviews(Long companyId) {
        return reviewRepository.findAllByCompanyId(companyId);
    }
}
