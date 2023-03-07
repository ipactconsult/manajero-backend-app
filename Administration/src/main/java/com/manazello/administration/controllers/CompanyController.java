package com.manazello.administration.controllers;

import com.manazello.administration.business.ibusiness.ICompanyService;
import com.manazello.administration.dtos.CompanyDto;
import com.manazello.administration.entities.Company;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/company")
@RequiredArgsConstructor
public class CompanyController {

    private final ICompanyService<Company> companyService;
    private final ModelMapper modelMapper;


    @PostMapping("/add")
    public ResponseEntity<Company> addCompany(@RequestBody CompanyDto companyDto) {
        Company company = modelMapper.map(companyDto, Company.class);
        Company companyAdded = companyService.add(company);
        return ((companyAdded != null)
                ? new ResponseEntity<>(companyAdded, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Company>> getAllCompanies() {
        try {

            List<Company> companies = companyService.findAllCompanies();

            if (companies.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(companies, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/findByMatriculate/{mat}")
    public ResponseEntity<Company> getCompanyByMatriculate(@PathVariable String mat) {
        try {

            Company company = companyService.findCompanyByMatriculate(mat);

            if (company == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(company, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}

