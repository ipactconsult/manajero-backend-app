package com.manazello.administration.business.ibusiness;

import com.manazello.administration.entities.Company;

import java.util.List;

public interface ICompanyService<T> {
    T add( T company);
    List<T> findAllCompanies();
    Company findCompanyById(String id);
    Company findCompanyByMatriculate(String matriculate);
}
