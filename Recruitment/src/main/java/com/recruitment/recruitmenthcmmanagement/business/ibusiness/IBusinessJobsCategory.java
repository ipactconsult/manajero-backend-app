package com.recruitment.recruitmenthcmmanagement.business.ibusiness;

import com.recruitment.recruitmenthcmmanagement.entities.JobsCategory;

import java.util.List;
import java.util.Optional;

public interface IBusinessJobsCategory {
    JobsCategory add(JobsCategory jobsCategory);
    JobsCategory edit(JobsCategory jobsCategory, String id);
    List<JobsCategory> records();
    void remove(String id);
    Optional<JobsCategory> show(String id);
}
