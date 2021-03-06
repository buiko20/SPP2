package service;

import domain.Company;
import domain.Invitation;
import service.exception.ServiceException;

import java.util.ArrayList;

public interface CompanyService {

    ArrayList<Company> getAllCompanies() throws ServiceException;

    Company getCompanyById(int id) throws ServiceException;

    Company getCompanyByName(String name) throws IllegalArgumentException, ServiceException;

    void addCompany(Company company) throws IllegalArgumentException, ServiceException;

    ArrayList<Invitation> getAllInvitation(String companyName) throws IllegalArgumentException, ServiceException;

}
