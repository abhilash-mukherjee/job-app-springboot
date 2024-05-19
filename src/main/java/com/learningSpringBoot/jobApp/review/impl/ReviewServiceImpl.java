package com.learningSpringBoot.jobApp.review.impl;

import com.learningSpringBoot.jobApp.company.CompanyService;
import com.learningSpringBoot.jobApp.review.Review;
import com.learningSpringBoot.jobApp.review.ReviewRepository;
import com.learningSpringBoot.jobApp.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    ReviewRepository reviewRepository;
    CompanyService companyService;
    @Override
    public List<Review> getAllReviews(Long companyId) {
        return reviewRepository.findAllByCompanyId(companyId);
    }

    @Override
    public Review createReview(Long companyId, Review review) {
        try{
            var company = companyService.getCompanyById(companyId);
            review.setCompany(company);
            reviewRepository.save(review);
            System.out.println(
                    "Review created. Id: " + review.getId() +
                            "Title: " + review.getReviewTitle() +
                            "Description: " + review.getReviewDescription() +
                            "Company: " + review.getCompany().getId());
            return review;
        }
        catch (Exception e){
            System.out.println("Error: "+e.getMessage());
            throw new RuntimeException("Review was not created");
        }
    }

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }
}
