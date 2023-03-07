package com.example.litigerecouvrement.ibusniess;

import com.example.litigerecouvrement.entites.CallRapport;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CallRapportIBusiness {
    CallRapport createCall(CallRapport call);
    List<CallRapport> findAllCallRapport();
    public String deleteCallRapport(String idc) ;
    ResponseEntity<CallRapport> findByid(String id);

    long countCallRapport ();
    public CallRapport updateCallRapport(CallRapport callRapport);
}
