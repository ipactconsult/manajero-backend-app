package com.manazello.projectmanagement.business.businessImpl;

import com.manazello.projectmanagement.business.ibusiness.IService;
import com.manazello.projectmanagement.entities.ChangeRequest;
import com.manazello.projectmanagement.entities.Requirement;
import com.manazello.projectmanagement.entities.enumeration.Status;
import com.manazello.projectmanagement.repositories.ChangeRequestRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ChangeRequestImpl implements IService<ChangeRequest> {
    private final ChangeRequestRepository changeRequestRepository;

    public ChangeRequestImpl(ChangeRequestRepository changeRequestRepository) {
        this.changeRequestRepository = changeRequestRepository;
    }

    @Override
    public ChangeRequest add(ChangeRequest entity) {
        return changeRequestRepository.save(entity);
    }

    @Override
    public List<ChangeRequest> findAllActive() {
        return  changeRequestRepository.findByArchivedNot(true);
    }

    @Override
    public List<ChangeRequest> findAllArchived() {
        return  changeRequestRepository.findByArchivedNot(false);
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public ChangeRequest update(ChangeRequest entity) {
        if(entity.getStatus()!= Status.IN_PROGRESS) {
            entity.setApprovedDate(new Date());
        }
        return changeRequestRepository.save(entity);
    }

    @Override
    public ChangeRequest findById(String id) {
        return changeRequestRepository.findById(id).orElse(null);
    }



    public List<ChangeRequest>findAllActiveByProject(String id){
        return changeRequestRepository.findByArchivedNotAndProject(true, new ObjectId(id));
    }

    public List<ChangeRequest>findAllArchivedByProject(String id){
        return changeRequestRepository.findByArchivedNotAndProject(false, new ObjectId(id));
    }
    public List<ChangeRequest> findChangeRequestByRequestorEmailAndProject(String email,String id){
        return changeRequestRepository.findChangeRequestByRequestorEmailAndProject(email, new ObjectId(id));
    }
}
