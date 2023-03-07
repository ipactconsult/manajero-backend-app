package com.example.litigerecouvrement.busniess;

import com.example.litigerecouvrement.entites.CallRapport;
import com.example.litigerecouvrement.ibusniess.CallRapportIBusiness;
import com.example.litigerecouvrement.repositories.CallRapportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CallRapportBusiness implements CallRapportIBusiness {

    @Autowired
    private CallRapportRepository callrepo;

    @Override
    public CallRapport createCall(CallRapport call) {


        return callrepo.save(call);
    }

    @Override
    public List<CallRapport> findAllCallRapport() {
        return callrepo.findAll();
    }

    @Override
    public String deleteCallRapport(String idc) {
        return "null";
    }

    @Override
    public ResponseEntity<CallRapport> findByid(String id) {
        Optional<CallRapport> cr = callrepo.findById(id);
        return (
                cr.isPresent() ?
                        new ResponseEntity<>(cr.get(), HttpStatus.OK)
                        : new ResponseEntity<>(HttpStatus.NOT_FOUND)
        );
    }

    @Override
    public long countCallRapport() {
        return callrepo.count();
    }

    @Override
    public CallRapport updateCallRapport(CallRapport callRapport) {
        return null;
    }
}
