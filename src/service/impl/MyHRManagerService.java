package service.impl;

import dao.DAO;
import domain.Company;
import domain.Invitation;
import domain.HRManager;
import domain.JobVacancy;
import domain.Resume;
import service.HRManagerService;
import service.exception.CompanyNotFoundException;
import service.exception.JobVacancyNotFoundException;
import service.exception.ServiceException;
import service.utils.ArgumentVerificationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class MyHRManagerService implements HRManagerService {

    private DAO<HRManager> hrManagerDAO;
    private DAO<Company> companyDAO;
    private DAO<JobVacancy> jobVacancyDAO;
    private DAO<Resume> resumeDAO;
    private DAO<Invitation> invitationDAO;

    public MyHRManagerService(DAO<HRManager> hrManagerDAO, DAO<Company> companyDAO, DAO<JobVacancy> jobVacancyDAO,
        DAO<Resume> resumeDAO, DAO<Invitation> invitationDAO) {

        ArgumentVerificationService.verifyNull(hrManagerDAO, "hrManagerDAO");
        ArgumentVerificationService.verifyNull(companyDAO, "companyDAO");
        ArgumentVerificationService.verifyNull(jobVacancyDAO, "jobVacancyDAO");
        ArgumentVerificationService.verifyNull(resumeDAO, "resumeDAO");
        ArgumentVerificationService.verifyNull(invitationDAO, "invitationDAO");

        this.hrManagerDAO = hrManagerDAO;
        this.companyDAO = companyDAO;
        this.jobVacancyDAO = jobVacancyDAO;
        this.resumeDAO = resumeDAO;
        this.invitationDAO = invitationDAO;
    }

    @Override
    public HRManager getHRManagerByEmail(String email) throws IllegalArgumentException, ServiceException {
        ArgumentVerificationService.verifyString(email, "email");

        try {
            Predicate<HRManager> mailPredicate = HRManager -> HRManager.getEmail().equals(email);
            return this.hrManagerDAO.getBy(mailPredicate);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public HRManager getHRManagerById(int id) throws ServiceException {
        try {
            return this.hrManagerDAO.getBy(hrManager -> hrManager.getId() == id);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public ArrayList<JobVacancy> getAllVacanciesOfCompany(String companyName) throws IllegalArgumentException,
            ServiceException {

        ArgumentVerificationService.verifyString(companyName, "companyName");

        try {
            Company company = this.getCompanyByName(companyName);
            if (company == null) {
                throw new CompanyNotFoundException(companyName);
            }

            ArrayList<JobVacancy> result = new ArrayList<>();
            List<JobVacancy> vacancies = this.jobVacancyDAO.getAll();

            for (JobVacancy vacancy : vacancies) {
                if (vacancy.getCompanyId() == company.getId()) {
                    result.add(vacancy);
                }
            }

            return result;

        } catch (ServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public ArrayList<Resume> getAllResume() throws ServiceException {
        try {
            List<Resume> resumes = this.resumeDAO.getAll();
            return new ArrayList<>(resumes);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public ArrayList<Invitation> getAllInvitations() throws ServiceException {
        try {
            List<Invitation> invitations = this.invitationDAO.getAll();
            return new ArrayList<>(invitations);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public JobVacancy getJobVacancy(String vacancyName, String companyName) throws IllegalArgumentException, ServiceException {
        ArgumentVerificationService.verifyString(vacancyName, "vacancyName");
        ArgumentVerificationService.verifyString(companyName, "companyName");

        try {
            ArrayList<JobVacancy> vacancies = this.getAllVacanciesOfCompany(companyName);

            for (JobVacancy vacancy : vacancies) {
                if (Objects.equals(vacancy.getName(), vacancyName)) {
                    return vacancy;
                }
            }

            throw new JobVacancyNotFoundException(vacancyName, companyName);

        } catch (ServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void updateJobVacancy(String vacancyName, String companyName, JobVacancy jobVacancy)
            throws IllegalArgumentException, ServiceException {

        ArgumentVerificationService.verifyString(vacancyName, "vacancyName");
        ArgumentVerificationService.verifyString(companyName, "companyName");

        try {
            JobVacancy oldVacancy = this.getJobVacancy(vacancyName, companyName);
            if (oldVacancy == null) {
                throw new JobVacancyNotFoundException(vacancyName, companyName);
            }

            jobVacancy.setId(oldVacancy.getId());
            jobVacancy.setHrManagerId(oldVacancy.getHrManagerId());
            jobVacancy.setCompanyId(oldVacancy.getCompanyId());

            this.jobVacancyDAO.update(jobVacancy);

        } catch (ServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void deleteJobVacancy(String vacancyName, String companyName) throws IllegalArgumentException,
            ServiceException {

        ArgumentVerificationService.verifyString(vacancyName, "vacancyName");
        ArgumentVerificationService.verifyString(companyName, "companyName");

        try {
            JobVacancy vacancy = this.getJobVacancy(vacancyName, companyName);
            if (vacancy == null) {
                throw new JobVacancyNotFoundException(vacancyName, companyName);
            }
            this.jobVacancyDAO.delete(vacancy.getId());
        } catch (ServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    private Company getCompanyByName(String name) throws ServiceException {
        try {
            return this.companyDAO.getBy(company -> company.getName().equals(name));
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
