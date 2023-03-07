package com.employees.main.business.businessimpl;

import com.employees.main.business.dto.SubDepartmentDTO;
import com.employees.main.business.ibusiness.IBusinessSubDepartment;
import com.employees.main.entities.SubDepartment;
import com.employees.main.repositories.SubDepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubDepartmentBusiness implements IBusinessSubDepartment {

     final
     SubDepartmentRepository sdr;

     final ModelMapper mapper;

    public SubDepartmentBusiness(SubDepartmentRepository sdr, ModelMapper mapper) {
        this.sdr = sdr;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<SubDepartment> createSubDepartment(SubDepartmentDTO subDepartmentDTO) {

        SubDepartment sd = new SubDepartment();
        sd.setSubDepartmentName(subDepartmentDTO.getSubDepartmentName());
        sd.setDepartment(subDepartmentDTO.getDepartment());
        sdr.save(sd);
        return ResponseEntity.status(HttpStatus.CREATED).body(sd);
    }

    @Override
    public List<SubDepartment> findAllSubDepartments() {
        return sdr.findAll(Sort.by("subDepartmentName"));
    }

    @Override
    public List<SubDepartment> findByDepartment(String departmentName) {
        return sdr.findByDepartment(departmentName);
    }

    @Override
    public SubDepartment editSubDepartment(String id, SubDepartmentDTO subDepartmentDTO) {
        SubDepartment subDepartment = this.mapper.map(subDepartmentDTO, SubDepartment.class);
        Optional<SubDepartment> editSub =  sdr.findById(id);
        return (editSub.isPresent()? sdr.save(subDepartment) : null);
    }

    @Override
    public Optional<SubDepartment> findById(String id) {
        return sdr.findById(id);
    }

    @Override
    public ResponseEntity<String> deleteSub(String id) {
        sdr.deleteById(id);
        return new ResponseEntity<>("Operation Deleted Successfuly", HttpStatus.OK);
    }

}
