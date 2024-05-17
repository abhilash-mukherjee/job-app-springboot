package com.learningSpringBoot.jobApp.review;

import com.learningSpringBoot.jobApp.company.Company;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Review Title is mandatory")
    @NotNull(message = "Review TItle is mandatory")
    private String reviewTitle;
    @NotBlank(message = "Review Description is mandatory")
    @NotNull(message = "Review Description is mandatory")
    private String reviewDescription;
    @ManyToOne
    private Company company;

    public Review() {
    }

    public Review(String reviewTitle, String reviewDescription) {
        this.reviewTitle = reviewTitle;
        this.reviewDescription = reviewDescription;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public String getReviewDescription() {
        return reviewDescription;
    }

    public void setReviewDescription(String reviewDescription) {
        this.reviewDescription = reviewDescription;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
