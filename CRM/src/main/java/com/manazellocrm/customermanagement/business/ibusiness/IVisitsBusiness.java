package com.manazellocrm.customermanagement.business.ibusiness;

import com.manazellocrm.customermanagement.business.dtos.VisitDTO;
import com.manazellocrm.customermanagement.entities.Customer;
import com.manazellocrm.customermanagement.entities.Visit;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IVisitsBusiness {

    ResponseEntity<Visit> addVisit (VisitDTO visitDTO,  String idProperty,String idCustomer);
    Visit updateVisit (Visit visit,  String idProperty);

    ResponseEntity<String> deleteVisit (String id);

    List<Visit> getAllVisits ();

    ResponseEntity<Visit> getVisitByID(String id);

    Visit archiveVisit(Visit visit, String id);
    Visit cancelArchiveVisit(Visit visit, String id);

    List<Visit> findAllVisitTitleDESC(String archive);
    List<Visit> findAllVisitTitleASC(String archive);

    List<Visit> getVisitsCreatedAtDesc(String archive);

    List<Visit> getVisitsCreatedAtAsc( String archive);


    List<Visit> getVisitsNonArchived( String archive);

    List<Visit> getVisitsByCustomers();

    List<Visit> findAllLastsVisitTitleDESC(String archive, Customer id);



}
