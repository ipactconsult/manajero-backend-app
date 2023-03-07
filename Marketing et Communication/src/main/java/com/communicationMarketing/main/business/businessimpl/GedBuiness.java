package com.communicationMarketing.main.business.businessimpl;

import java.util.List;

import java.time.Instant;
import java.util.Date;

import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.communicationMarketing.main.business.dtos.GEDDTO;
import com.communicationMarketing.main.business.ibusiness.IGEDBusiness;
import com.communicationMarketing.main.entity.Event;
import com.communicationMarketing.main.entity.GED;

import com.communicationMarketing.main.repository.GEDRepos;

@Service
public class GedBuiness implements IGEDBusiness {

    private static final Logger logger = LoggerFactory.getLogger(GedBuiness.class);
    private final GEDRepos gedRepos;

    public GedBuiness(GEDRepos gedRepos) {
        this.gedRepos = gedRepos;
    }

    @Override
    public ResponseEntity<GED> addGED(GEDDTO gedDTO) throws ConstraintViolationException {

        Date date = new Date();
        Instant instanceNow = date.toInstant();

        GED gedToPersist = new GED();

        gedToPersist.setId(gedDTO.getId());
        gedToPersist.setTitle(gedDTO.getTitle());
        gedToPersist.setDescription(gedDTO.getDescription());
        gedToPersist.setDateCreation(gedDTO.getDateCreation());
        gedToPersist.setContent(gedDTO.getContent());
        gedToPersist.setContentType(gedDTO.getContentType());
        gedToPersist.setFileName(gedDTO.getFileName());
        gedToPersist.setFileGed(gedDTO.getFileGed());
        gedToPersist.setCreatedAt(instanceNow);
        gedToPersist.setModifiedAt(instanceNow);
        gedToPersist.setArchive(false);

        gedRepos.save(gedToPersist);
        return ResponseEntity.status(HttpStatus.CREATED).body(gedToPersist);

    }

    @Transactional
    @Override
    public GED updateGED(GED ged) {
        Optional<GED> gedOptional = gedRepos.findById(ged.getId());

        Date date = new Date();
        Instant dateToUpdate = date.toInstant();
        ged.setModifiedAt(dateToUpdate);

        return (gedOptional.isPresent()
                ? gedRepos.save(ged)
                : null);
    }

    @Override
    public GED deleteGED(String id) {
        GED existedGED = gedRepos.findById(id).orElse(null);
        if (existedGED != null) {
            gedRepos.delete(existedGED);
            return existedGED;
        } else {
            return null;
        }
    }

    @Override
    public List<GED> getAllGEDs() {

        return gedRepos.findAll();

    }

    @Override
    public ResponseEntity<?> getGEDByID(String id) {
        Optional<GED> gedData = gedRepos.findById(id);
        return gedData.map(GED -> new ResponseEntity<>(GED, HttpStatus.OK)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));

    }

    @Override
    public long countGEDs() {
        return gedRepos.count();

    }

    @Override
    public ResponseEntity<GED> updateGED(GEDDTO GEDDTO, String idGED) {
        Optional<GED> GEDOptional = gedRepos.findById(idGED);

        if (GEDOptional.isPresent()) {
            GED gedToSave = GEDOptional.get();
            gedToSave.setId(GEDDTO.getId() != null ? GEDDTO.getId() : gedToSave.getId());
            gedToSave.setTitle(GEDDTO.getTitle() != null ? GEDDTO.getTitle() : gedToSave.getTitle());
            gedToSave.setContent(GEDDTO.getContent() != null ? GEDDTO.getContent() : gedToSave.getContent());
            gedToSave.setContentType(GEDDTO.getContentType() != null ? GEDDTO.getContentType() : gedToSave.getContentType());

            gedRepos.save(gedToSave);
            return new ResponseEntity<>(GEDOptional.get(), HttpStatus.OK);
        } else {
            String message = "ERROR WHILE UPDATING GED WITH  id  =" + idGED;
            logger.error(message);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public GED cancelArchiveGED(GED g, String id) {

        GED existedGED = gedRepos.findById(id).orElse(null);
        if (existedGED != null) {
            existedGED.setArchive(false);
            gedRepos.save(existedGED);
            return existedGED;
        } else {
            return null;
        }

    }

    @Override
    public GED archiveGED(GED event, String id) {
        GED existedGED = gedRepos.findById(id).orElse(null);
        if (existedGED != null) {
            existedGED.setArchive(true);
            gedRepos.save(existedGED);
            return existedGED;
        } else {
            return null;
        }

    }

    public String saveFile(GED ged) {

        if (ged.getContent() == null || ged.getContent().isEmpty()) {
            return "you must fill in the type of lawys";
        }
        if (ged.getContentType() == null || ged.getContentType().isEmpty()) {
            return "you have to put the title";
        }

        gedRepos.save(ged);
        return "Successful Add";
    }

}
