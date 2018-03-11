package service.impl;

import dao.DAO;
import domain.JobVacancy;
import service.JobVacancyService;
import service.exception.ServiceException;
import service.utils.ArgumentVerificationService;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MyJobVacancyService implements JobVacancyService {

    private DAO<JobVacancy> jobVacancyDAO;

    public MyJobVacancyService(DAO<JobVacancy> jobVacancyDAO) {

        ArgumentVerificationService.verifyNull(jobVacancyDAO, "jobVacancyDAO");

        this.jobVacancyDAO = jobVacancyDAO;
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
    public JobVacancy getJobVacancy(String vacancyName) throws IllegalArgumentException, ServiceException {

        ArgumentVerificationService.verifyString(vacancyName, "vacancyName");

        try {
            Predicate<JobVacancy> predicate = (jobVacancy) -> jobVacancy.getName().equals(vacancyName);
            return this.jobVacancyDAO.getBy(predicate);
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
}
