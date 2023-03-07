package com.example.litigerecouvrement.ibusniess;

import com.example.litigerecouvrement.entites.Mail;
import com.example.litigerecouvrement.entites.Relance;

import java.util.List;

public interface RelanceIBusiness {
    Relance createRelance(Relance lit);
    List<Relance> findAllRelances(String ar,Boolean clo);
    public Relance updateRelance(String id, Relance relance) ;
    public Relance findByid(String id) ;
    public String deleteRelance(String idl) ;
    Relance cancelArchiveRelance(Relance relance, String id);
    List<Mail> findEmailbyRelance(String id );
    public void sendMail();



}
