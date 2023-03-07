package com.recruitment.recruitmenthcmmanagement.business.ibusiness;

import com.recruitment.recruitmenthcmmanagement.entities.JobOffer;

import java.util.List;
import java.util.Optional;

public interface IBusinessJobOffer {
    JobOffer addJob (JobOffer jobOffer);
    JobOffer editJob(JobOffer jobOffer , String id);
    Optional<JobOffer> getJob (String id);
    List<JobOffer> findAllJobs();
    JobOffer archive(JobOffer jobOffer, String id);
    JobOffer restore(JobOffer jobOffer, String id);
    boolean deleteJob(String id);
}
