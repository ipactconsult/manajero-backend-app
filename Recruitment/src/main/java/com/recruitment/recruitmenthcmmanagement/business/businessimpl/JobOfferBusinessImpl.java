package com.recruitment.recruitmenthcmmanagement.business.businessimpl;

import com.recruitment.recruitmenthcmmanagement.business.ibusiness.IBusinessJobOffer;
import com.recruitment.recruitmenthcmmanagement.entities.JobOffer;
import com.recruitment.recruitmenthcmmanagement.repositories.JobOfferRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class JobOfferBusinessImpl implements IBusinessJobOffer {

    final JobOfferRepository jobOfferRepository;
    final RestTemplate rest;

    public JobOfferBusinessImpl(JobOfferRepository jobOfferRepository, RestTemplate rest) {
        this.jobOfferRepository = jobOfferRepository;
        this.rest = rest;
    }

    public static String getBearerTokenHeader() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).
                        getRequest().getHeader("Authorization");
    }

    @Override
    public JobOffer addJob(JobOffer jobOffer) {

        return jobOfferRepository.save(jobOffer);
    }

    @Override
    public JobOffer editJob(JobOffer jobOffer, String id) {
        Optional<JobOffer>toEdit = jobOfferRepository.findById(id);
        return (toEdit.isPresent() ? jobOfferRepository.save(jobOffer):null);
    }

    @Override
    public Optional<JobOffer> getJob(String id) {
        return jobOfferRepository.findById(id);
    }

    @Override
    public List<JobOffer> findAllJobs() {
        return jobOfferRepository.findAll();
    }

    @Override
    public JobOffer archive(JobOffer jobOffer, String id) {
        Optional<JobOffer>toArchive = jobOfferRepository.findById(id);
        jobOffer.setIsArchived("Yes");
        return (toArchive.isPresent() ? jobOfferRepository.save(jobOffer):null);
    }

    @Override
    public JobOffer restore(JobOffer jobOffer, String id) {
        Optional<JobOffer>toRestore = jobOfferRepository.findById(id);
        jobOffer.setIsArchived("No");
        return (toRestore.isPresent() ? jobOfferRepository.save(jobOffer):null);
    }

    @Override
    public boolean deleteJob(String id) {
        jobOfferRepository.deleteById(id);
        return true;
    }




}
