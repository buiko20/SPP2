package service.impl;

import dao.DAO;
import domain.Company;
import service.exception.ServiceException;
import service.utils.ArgumentVerificationService;
import service.CompanyService;

import java.util.ArrayList;
import java.util.List;

public class MyCompanyService implements CompanyService {

    private DAO<Company> companyDAO;

    public MyCompanyService(DAO<Company> companyDAO) {

        ArgumentVerificationService.verifyNull(companyDAO, "companyDAO");

        this.companyDAO = companyDAO;
    }

    @Override
    public ArrayList<Company> getAllCompanies() throws ServiceException {
        try {

            List<Company> companies = this.companyDAO.getAll();
            return new ArrayList<>(companies);

        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Company getCompanyById(int id) throws ServiceException {
        try {
            return this.companyDAO.getBy(company -> company.getId() == id);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Company getCompanyByName(String name) throws IllegalArgumentException, ServiceException {

        ArgumentVerificationService.verifyString(name, "name");

        try {
            return this.companyDAO.getBy(company -> company.getName().equals(name));
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void addCompany(Company company) throws IllegalArgumentException, ServiceException {

        ArgumentVerificationService.verifyNull(company, "company");

        try {
            this.companyDAO.create(company);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
