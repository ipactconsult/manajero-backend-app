package com.recruitment.recruitmenthcmmanagement.business.businessimpl;

import com.recruitment.recruitmenthcmmanagement.business.ibusiness.IBusinessJobsCategory;
import com.recruitment.recruitmenthcmmanagement.entities.JobsCategory;
import com.recruitment.recruitmenthcmmanagement.repositories.JobsCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobsCategoryBusinessImpl implements IBusinessJobsCategory {

    final JobsCategoryRepository jobsCategoryRepository;

    public JobsCategoryBusinessImpl(JobsCategoryRepository jobsCategoryRepository) {
        this.jobsCategoryRepository = jobsCategoryRepository;
    }


    @Override
    public JobsCategory add(JobsCategory jobsCategory) {
        return jobsCategoryRepository.save(jobsCategory);
    }

    @Override
    public JobsCategory edit(JobsCategory jobsCategory, String id) {
        Optional<JobsCategory> get = jobsCategoryRepository.findById(id);
        return (get.isPresent()? jobsCategoryRepository.save(jobsCategory):null);
    }

    @Override
    public List<JobsCategory> records() {
        return jobsCategoryRepository.findAll();
    }

    @Override
    public void remove(String id) {
        jobsCategoryRepository.deleteById(id);
    }

    @Override
    public Optional<JobsCategory> show(String id) {
        return jobsCategoryRepository.findById(id);
    }
}
