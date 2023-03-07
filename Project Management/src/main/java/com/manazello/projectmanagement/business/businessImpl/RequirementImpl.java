package com.manazello.projectmanagement.business.businessImpl;

import com.manazello.projectmanagement.business.ibusiness.IService;
import com.manazello.projectmanagement.entities.Requirement;
import com.manazello.projectmanagement.repositories.RequirementRpository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RequirementImpl implements IService<Requirement> {
    final RequirementRpository requirementRpository;

    public RequirementImpl(RequirementRpository requirementRpository) {
        this.requirementRpository = requirementRpository;
    }


    @Override
    public Requirement add(Requirement entity) {
        return requirementRpository.save(entity);
    }

    @Override
    public List<Requirement> findAllActive() {
        return null;
    }

    @Override
    public List<Requirement> findAllArchived() {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public Requirement update(Requirement enity) {
        return requirementRpository.save(enity);
    }

    @Override
    public Requirement findById(String id) {
        return null;
    }



    public List<Requirement>findAllActiveRequirementByProject(String id){
        return requirementRpository.findByArchivedNotAndProject(true, new ObjectId(id));
    }

    public List<Requirement>findAllArchivedRequirementByProject(String id){
        return requirementRpository.findByArchivedNotAndProject(false, new ObjectId(id));
    }
}
