package service.impl;

import dao.DAO;
import domain.Company;
import domain.JobVacancy;
import service.JobVacancyService;
import service.exception.CompanyNotFoundException;
import service.exception.JobVacancyNotFoundException;
import service.exception.ServiceException;
import service.utils.ArgumentVerificationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class MyJobVacancyService implements JobVacancyService {

    private DAO<JobVacancy> jobVacancyDAO;
    private DAO<Company> companyDAO;

    public MyJobVacancyService(DAO<JobVacancy> jobVacancyDAO, DAO<Company> companyDAO) {

        ArgumentVerificationService.verifyNull(jobVacancyDAO, "jobVacancyDAO");
        ArgumentVerificationService.verifyNull(companyDAO, "companyDAO");

        this.jobVacancyDAO = jobVacancyDAO;
        this.companyDAO = companyDAO;
    }

    @Override
    public ArrayList<JobVacancy> getAllAspirantJobVacancy() throws ServiceException {
        try {
            List<JobVacancy> jobVacancies = this.jobVacancyDAO.getAll();
            return new ArrayList<>(jobVacancies);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public JobVacancy getJobVacancy(String vacancyName, String companyName) throws IllegalArgumentException, ServiceException {
        ArgumentVerificationService.verifyString(vacancyName, "vacancyName");
        ArgumentVerificationService.verifyString(companyName, "companyName");

        try {
            Company company = this.companyDAO.getBy(comp -> comp.getName().equals(companyName));
            if (company == null) {
                throw new CompanyNotFoundException(companyName);
            }

            int companyId = company.getId();

            List<JobVacancy> vacancies = this.jobVacancyDAO.getAll();

            for (JobVacancy vacancy : vacancies) {
                if (Objects.equals(vacancy.getName(), vacancyName) && Objects.equals(vacancy.getCompanyId(), companyId)) {
                    return vacancy;
                }
            }

            throw new JobVacancyNotFoundException(vacancyName, companyName);

        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void addJobVacancy(JobVacancy jobVacancy) throws IllegalArgumentException, ServiceException {

        ArgumentVerificationService.verifyNull(jobVacancy, "jobVacancy");

        try {
            this.jobVacancyDAO.create(jobVacancy);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }

    }

    @Override
    public JobVacancy getJobVacancyById(int id) throws ServiceException {

        try {
            Predicate<JobVacancy> predicate = (jobVacancy) -> jobVacancy.getId() == id;
            return this.jobVacancyDAO.getBy(predicate);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
