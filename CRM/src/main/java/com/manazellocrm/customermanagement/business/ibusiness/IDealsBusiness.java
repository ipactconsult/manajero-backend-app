package com.manazellocrm.customermanagement.business.ibusiness;

import com.manazellocrm.customermanagement.business.dtos.DealsDTO;
import com.manazellocrm.customermanagement.entities.Deals;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IDealsBusiness {

    ResponseEntity<Deals> addDeal (DealsDTO dealsDTO);
    Deals updateDeal (Deals deals, String id);
    void cancelDealPassed(Deals deals, String id);
    void cancelDeal();
    ResponseEntity<String> deleteDeal (String id);
    List<Deals> getAllDeals ();
    ResponseEntity<Deals> getDealByID(String id);
    Deals archiveDeals(Deals deals, String id);
    Deals cancelArchiveDeals(Deals deals, String id);
    List<Deals> findAllDealsDESC();
    List<Deals> findAllDealsByArchive(String archive);
    List<Deals> findAllDealsASC();

}
