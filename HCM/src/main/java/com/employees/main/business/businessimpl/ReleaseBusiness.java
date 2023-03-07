package com.employees.main.business.businessimpl;

import com.employees.main.business.dto.ReleaseDTO;
import com.employees.main.business.ibusiness.IReleaseBusiness;
import com.employees.main.entities.Employee;
import com.employees.main.entities.Release;
import com.employees.main.repositories.EmployeeRepository;
import com.employees.main.repositories.ReleaseRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ReleaseBusiness implements IReleaseBusiness {

   private final ReleaseRepository releaseRepository;

   private final EmployeeRepository employeeRepository;

   final ModelMapper mapper;

    @Override
    public Release createRelease(ReleaseDTO releaseDTO, String id) {
            Date date = new Date();
            Instant instanceDateNow = date.toInstant();
            Optional<Employee> finEmployee = employeeRepository.findById(id);
            Release release = new Release(
                    releaseDTO.getId(),
                    releaseDTO.getMotifRelease(),
                    releaseDTO.getStartTime(),
                    releaseDTO.getEndTime(),
                    "Pending",
                    releaseDTO.getCommentsRelease(),
                    finEmployee.get(),
                    releaseDTO.getRejectedReleaseBy(),
                    releaseDTO.getValidatedReleaseBy(),
                    instanceDateNow,
                    null,
                    "No",
                    releaseDTO.getUser()
            );

        return releaseRepository.save(release);
    }

    @Override
    public Release createDraftRelease(ReleaseDTO releaseDTO, String id) {
        Optional<Employee> finEmployee = employeeRepository.findById(id);
        Date date = new Date();
        Instant instanceDateNow = date.toInstant();
        Release release = new Release(
                releaseDTO.getId(),
                releaseDTO.getMotifRelease(),
                releaseDTO.getStartTime(),
                releaseDTO.getEndTime(),
                "Draft",
                releaseDTO.getCommentsRelease(),
                finEmployee.get(),
                releaseDTO.getRejectedReleaseBy(),
                releaseDTO.getValidatedReleaseBy(),
                instanceDateNow,
                null,
                "Yes",
                releaseDTO.getUser()
        );

        return releaseRepository.save(release);
    }

    @Override
    public List<Release> findReleases() {
        return releaseRepository.findAll();
    }

    @Override
    public List<Release> findDraftReleases(String releaseStatus) {
        return releaseRepository.findAllByReleaseStatus(releaseStatus);
    }

    @Override
    public List<Release> sortAscReleases() {
        return releaseRepository.findAll(Sort.by("createdAt").ascending());
    }

    @Override
    public List<Release> sortDescReleases() {
        return releaseRepository.findAll(Sort.by("createdAt").descending());
    }

    @Override
    public Release updateRelease(ReleaseDTO releaseDTO, String id) {
        Release release = this.mapper.map(releaseDTO, Release.class);
        Optional<Release> editRelease= releaseRepository.findById(id);
        return (editRelease.isPresent()? releaseRepository.save(release):null);
    }

    @Override
    public Release validateRelease(ReleaseDTO releaseDTO, String id) {
        Release release = this.mapper.map(releaseDTO, Release.class);
        Optional<Release> validateRelease = releaseRepository.findById(id);
        release.setReleaseStatus("Validate");
        return (validateRelease.isPresent()?
                releaseRepository.save(release): null);
    }

    @Override
    public Release rejectRelease(ReleaseDTO releaseDTO, String id) {
        Release release = this.mapper.map(releaseDTO, Release.class);
        Optional<Release> rejectRelease = releaseRepository.findById(id);
        release.setReleaseStatus("Rejected");
        return (rejectRelease.isPresent()?
                releaseRepository.save(release): null);
    }

    @Override
    public Release cancelRelease(ReleaseDTO releaseDTO, String id) {
        Release release = this.mapper.map(releaseDTO, Release.class);
        Optional<Release> cancelRelease = releaseRepository.findById(id);
        release.setReleaseStatus("Canceled");
        return (cancelRelease.isPresent()?
                releaseRepository.save(release): null);
    }

    @Override
    public Release archiveRelease(ReleaseDTO releaseDTO, String id) {

        Release release = this.mapper.map(releaseDTO, Release.class);
        Optional<Release> archiveRelease = releaseRepository.findById(id);
        release.setIsArchive("Yes");
        return (archiveRelease.isPresent()? releaseRepository.save(release): null);
    }

    @Override
    public Release restoreRelease(ReleaseDTO releaseDTO, String id) {
        Release release = this.mapper.map(releaseDTO, Release.class);
        Optional<Release> archiveRelease = releaseRepository.findById(id);
        release.setIsArchive("No");
        return (archiveRelease.isPresent()? releaseRepository.save(release): null);
    }

    @Override
    public String deleteRelease(String id) {
        releaseRepository.deleteById(id);
        return "Release Deleted Successfuly";
    }

    @Override
    public Optional<Release> getRelease(String id) {
        return releaseRepository.findById(id);
    }

    @Override
    public List<Release> getAllByReleaseStatus() {
        return releaseRepository.findAllByReleaseStatus("Validate");
    }

    @Override
    public List<Release> getAllByEmployee(Employee employee) {
        return releaseRepository.findReleasesByEmployee(employee);
    }
}
