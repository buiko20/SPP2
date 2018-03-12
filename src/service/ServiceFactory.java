package service;

import dao.DAO;
import dao.DAOFactory;
import domain.AspirantAccount;
import domain.AspirantProfile;
import domain.Company;
import domain.HRManager;
import domain.Invitation;
import domain.JobVacancy;
import domain.Resume;
import domain.ResumeView;
import service.impl.*;

/**
 * Represents a simple service factory.
 */
public class ServiceFactory {
    private static final ServiceFactory factory = new ServiceFactory();

    private final DAO<AspirantAccount> AspirantAccountDao = DAOFactory.getInstance().getAspirantAccountDAO();
    private final DAO<AspirantProfile> AspirantProfileDao = DAOFactory.getInstance().getAspirantProfileDAO();
    private final DAO<Resume> resumeDAO = DAOFactory.getInstance().getResumeDAO();
    private final DAO<ResumeView> resumeViewDAO = DAOFactory.getInstance().getResumeViewDAO();
    private final DAO<JobVacancy> jobVacancyDAO = DAOFactory.getInstance().getJobVacancyDAO();
    private final DAO<Company> companyDAO = DAOFactory.getInstance().getCompanyDAO();
    private final DAO<Invitation> invitationDAO = DAOFactory.getInstance().getInvitationDAO();
    private final DAO<HRManager> hrManagerDAO = DAOFactory.getInstance().getHRManagerDAO();

    private final AuthService authService = new MyAuthService(
            AspirantAccountDao, hrManagerDAO);
    private final JobVacancyService jobVacancyService = new MyJobVacancyService(
            jobVacancyDAO);
    private final CompanyService companyService = new MyCompanyService(
            companyDAO);
    private final AspirantService aspirantService = new MyAspirantService(
            AspirantAccountDao, AspirantProfileDao, resumeDAO, resumeViewDAO,
            invitationDAO, jobVacancyService, companyService);
    private final HRManagerService hrManagerService = new MyHRManagerService(hrManagerDAO, companyDAO,
            jobVacancyDAO, resumeDAO);

    private ServiceFactory() {
    }

    /**
     * Returns an instance of the {@link ServiceFactory} in singleton scope.
     * @return instance of the {@link ServiceFactory}
     */
    public static ServiceFactory getInstance() {
        return factory;
    }

    /**
     * Returns an instance of the {@link AspirantService} in singleton scope.
     * @return instance of the {@link AspirantService}
     */
    public AspirantService getAspirantService() {
        return aspirantService;
    }

    /**
     * Returns an instance of the {@link JobVacancyService} in singleton scope.
     * @return instance of the {@link JobVacancyService}
     */
    public JobVacancyService getJobVacancyService() {
        return jobVacancyService;
    }

    /**
     * Returns an instance of the {@link CompanyService} in singleton scope.
     * @return instance of the {@link CompanyService}
     */
    public CompanyService getCompanyService() {
        return companyService;
    }

    /**
     * Returns an instance of the {@link AuthService} in singleton scope.
     * @return instance of the {@link AuthService}
     */
    public AuthService getAuthService() {
        return authService;
    }

    /**
     * Returns an instance of the {@link HRManagerService} in singleton scope.
     * @return instance of the {@link HRManagerService}
     */
    public HRManagerService getHrManagerService() {
        return hrManagerService;
    }
}
