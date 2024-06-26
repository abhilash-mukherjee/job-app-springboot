package com.learningSpringBoot.jobApp.job;

import com.learningSpringBoot.jobApp.job.impl.JobServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/jobs")
@RestController
public class JobController {
    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<Job>> findAll() {
        return ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job) {
        jobService.createJob(job);
        return new ResponseEntity<>("Job added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> findJobById(@PathVariable Long id) {
        var job = jobService.findById(id);
        if (job != null)
            return ResponseEntity.ok(job);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id) {
        if (jobService.deleteJobById(id))
            return ResponseEntity.ok("Deleted successfully");
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Job not found");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateById(@PathVariable Long id, @RequestBody Job updatedJob) {
        boolean updated = jobService.updateJobById(id,updatedJob);
        if (updated)
            return ResponseEntity.ok("Updated successfully");
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Job not found");
    }
}
