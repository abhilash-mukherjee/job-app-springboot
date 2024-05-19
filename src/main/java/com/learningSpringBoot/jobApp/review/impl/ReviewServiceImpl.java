package com.learningSpringBoot.jobApp.review.impl;

import com.learningSpringBoot.jobApp.company.Company;
import com.learningSpringBoot.jobApp.company.CompanyService;
import com.learningSpringBoot.jobApp.review.Review;
import com.learningSpringBoot.jobApp.review.ReviewRepository;
import com.learningSpringBoot.jobApp.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

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

    @Override
    public Review getReviewById(Long companyId, Long reviewId) {
        try{
            Company company = companyService.getCompanyById(companyId);
            Optional<Review> reviewOptional = reviewRepository.findById(reviewId);
            if (reviewOptional.isPresent()) {
                var review = reviewOptional.get();
                if (company.equals(review.getCompany())) {
                    return review;
                } else {
                    throw new RuntimeException("Review belongs to a different company");
                }
            } else {
                throw new RuntimeException("Review not found");
            }
        }
        catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }
}
