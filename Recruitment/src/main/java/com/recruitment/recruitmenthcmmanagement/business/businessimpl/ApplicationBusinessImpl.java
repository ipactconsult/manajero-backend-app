package com.recruitment.recruitmenthcmmanagement.business.businessimpl;


import com.recruitment.recruitmenthcmmanagement.business.dto.ApplicationDTO;
import com.recruitment.recruitmenthcmmanagement.business.ibusiness.IBusinessApplication;
import com.recruitment.recruitmenthcmmanagement.csvtomongo.jobs.CsvToMongoJob;
import com.recruitment.recruitmenthcmmanagement.entities.Application;
import com.recruitment.recruitmenthcmmanagement.repositories.ApplicationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationBusinessImpl implements IBusinessApplication {


    final ApplicationRepository applicationRepository;

    final ModelMapper mapper;


    final CsvToMongoJob csvToMongoJob;
    public ApplicationBusinessImpl(ApplicationRepository applicationRepository, ModelMapper mapper, CsvToMongoJob csvToMongoJob) {
        this.applicationRepository = applicationRepository;
        this.mapper = mapper;
        this.csvToMongoJob = csvToMongoJob;
    }

    @Override
    public Application addApplication(Application application){
        csvToMongoJob.writer();
        return applicationRepository.save(application);
    }

    @Override
    public Application addApplications(List<? extends Application> items) {
        return (Application) applicationRepository.saveAll(items);
    }

    @Override
    public List<Application> readAll() {
        return applicationRepository.findAll();
    }

    @Override
    public Optional<Application> getApplication(String id) {
        return applicationRepository.findById(id);
    }

    @Override
    public Application screenProfile(ApplicationDTO applicationDTO, String id) {
        Application app = this.mapper.map(applicationDTO, Application.class);
        Optional<Application> screen = applicationRepository.findById(id);
        app.setStatus("SCREENING");
        return (screen.isPresent()? applicationRepository.save(app):null);
    }

    @Override
    public Application validateProfile(ApplicationDTO applicationDTO, String id) {
        Application app = this.mapper.map(applicationDTO, Application.class);
        Optional<Application> screen = applicationRepository.findById(id);
        app.setStatus("APPROVED");
        return (screen.isPresent()? applicationRepository.save(app):null);
    }

    @Override
    public Application rejectProfile(ApplicationDTO applicationDTO, String id) {
        Application app = this.mapper.map(applicationDTO, Application.class);
        Optional<Application> screen = applicationRepository.findById(id);
        app.setStatus("REJECTED");
        return (screen.isPresent()? applicationRepository.save(app):null);
    }

    @Override
    public List<Application> readAllByScreening() {
        return applicationRepository.findAllByStatus("SCREENING");
    }


}
