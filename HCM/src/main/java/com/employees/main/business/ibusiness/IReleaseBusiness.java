package com.employees.main.business.ibusiness;

import com.employees.main.business.dto.ReleaseDTO;
import com.employees.main.entities.Employee;
import com.employees.main.entities.Release;

import java.util.List;
import java.util.Optional;

public interface IReleaseBusiness {

    Release createRelease(ReleaseDTO releaseDTO, String id);
    Release createDraftRelease(ReleaseDTO releaseDTO, String id);
    List<Release> findReleases();
    List<Release> findDraftReleases(String releaseStatus);
    List<Release> sortAscReleases();
    List<Release> sortDescReleases();
    Release updateRelease(ReleaseDTO releaseDTO, String id);
    Release validateRelease(ReleaseDTO releaseDTO, String id);
    Release rejectRelease(ReleaseDTO releaseDTO, String id);
    Release cancelRelease(ReleaseDTO releaseDTO, String id);
    Release archiveRelease(ReleaseDTO releaseDTO, String id);
    Release restoreRelease(ReleaseDTO releaseDTO, String id);
    String deleteRelease(String id);
    Optional<Release> getRelease(String id);
    List<Release>getAllByReleaseStatus();
    List<Release>getAllByEmployee(Employee employee);
}
