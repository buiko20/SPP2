package service.impl;

import dao.DAO;
import domain.Company;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.fake.CompanyDaoFake;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MyCompanyServiceTests {

    private MyCompanyService companyService;

    @BeforeEach
    void setUp() {
        DAO<Company> companyDAO = new CompanyDaoFake();
        companyService = new MyCompanyService(companyDAO);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllCompanies_returnedAllCompanies() throws Exception {
        ArrayList<Company> result = this.companyService.getAllCompanies();
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void addJobVacancy_jobVacancy_addedJobVacancy() throws Exception {
        Company company = new Company();
        company.setName("name");
        company.setId(10);

        this.companyService.addCompany(company);
        company = this.companyService.getCompanyById(10);
        assertTrue(company.getId() == 10);

        company = this.companyService.getCompanyByName("name");
        assertTrue(company.getName().equals("name"));
    }

}
