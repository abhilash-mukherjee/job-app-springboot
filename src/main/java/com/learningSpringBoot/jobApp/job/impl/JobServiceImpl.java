package com.learningSpringBoot.jobApp.job.impl;

import com.learningSpringBoot.jobApp.job.Job;
import com.learningSpringBoot.jobApp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    private List<Job> jobs = new ArrayList<>();

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        jobs.add(job);
    }

    @Override
    public Job findById(Long id) {
        for (Job job : jobs){
            if(job.getId().equals(id))
                return job;
        }
        return null;
    }

    @Override
    public boolean deleteJobById(Long id) {
        Iterator<Job> jobIterator = jobs.iterator();
        while (jobIterator.hasNext()){
            var job = jobIterator.next();
            if(job.getId().equals(id)){
                jobIterator.remove();
                return true;
            }
        }
        return false;
    }
}
