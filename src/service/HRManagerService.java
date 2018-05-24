package service;

import domain.HRManager;
import domain.Invitation;
import domain.JobVacancy;
import domain.Resume;
import service.exception.ServiceException;

import java.util.ArrayList;

public interface HRManagerService {

    HRManager getHRManagerByEmail(String email) throws IllegalArgumentException, ServiceException;

    HRManager getHRManagerById(int id) throws ServiceException;

    ArrayList<JobVacancy> getAllVacanciesOfCompany(String companyName) throws IllegalArgumentException,  ServiceException;

    ArrayList<Resume> getAllResume() throws ServiceException;

    ArrayList<Invitation> getAllInvitations() throws ServiceException;

    JobVacancy getJobVacancy(String vacancyName, String companyName) throws IllegalArgumentException, ServiceException;

    void updateJobVacancy(String vacancyName, String companyName, JobVacancy jobVacancy) throws IllegalArgumentException,
            ServiceException;

    void deleteJobVacancy(String vacancyName, String companyName) throws IllegalArgumentException, ServiceException;

}
