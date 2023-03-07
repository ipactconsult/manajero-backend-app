package com.recruitment.recruitmenthcmmanagement.business.ibusiness;

import com.recruitment.recruitmenthcmmanagement.business.dto.*;
import com.recruitment.recruitmenthcmmanagement.entities.Application;

import java.util.List;
import java.util.Optional;

public interface IBusinessApplication {
    Application addApplication (Application application) throws Exception;
    Application addApplications (List<? extends Application> items);

    List<Application> readAll();

    Optional<Application> getApplication(String id);
    Application screenProfile(ApplicationDTO applicationDTO, String id);

    Application validateProfile(ApplicationDTO applicationDTO, String id);
    Application rejectProfile(ApplicationDTO applicationDTO, String id);

    List<Application> readAllByScreening();

}
