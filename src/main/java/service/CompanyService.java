package service;

import model.Company;

import java.util.List;

public class CompanyService {
    private final List<Company> companies;

    public CompanyService(List<Company> companies) {
        this.companies = companies;
    }

    public void addCompany(Company company){
        companies.add(company);
    }

}
