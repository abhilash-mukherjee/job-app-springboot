package com.learningSpringBoot.jobApp.review;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/companies/{companyId}/reviews")
public class ReviewController {

    private ReviewService reviewService;
    @GetMapping
    public ResponseEntity<List<Review>> getAlReviews(@PathVariable Long companyId){
        try{
            System.out.println("Requesting reviews for company:"+companyId);
            return new ResponseEntity<List<Review>>(reviewService.getAllReviews(companyId), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
