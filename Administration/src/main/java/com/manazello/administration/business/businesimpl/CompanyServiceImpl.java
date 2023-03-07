package com.manazello.administration.business.businesimpl;

import com.manazello.administration.business.ibusiness.ICompanyService;
import com.manazello.administration.entities.Company;
import com.manazello.administration.repositories.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements ICompanyService<Company> {

    private final CompanyRepository companyRepository;

    @Override
    public Company add(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public List<Company> findAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company findCompanyById(String id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public Company findCompanyByMatriculate(String matriculate) {
        return companyRepository.findCompanyByMatriculate(matriculate);
    }
}
