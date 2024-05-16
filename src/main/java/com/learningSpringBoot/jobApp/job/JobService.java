package com.learningSpringBoot.jobApp.job;

import java.util.List;

public interface JobService {
    public List<Job> findAll();

    public void createJob(Job job);

    Job findById(Long id);

    boolean deleteJobById(Long id);

    boolean updateJobById(Long id, Job updatedJob);
}
