package dao;

import dao.impl.*;
import domain.AspirantAccount;
import domain.AspirantProfile;
import domain.AspirantResponse;
import domain.Company;
import domain.HRManager;
import domain.Invitation;
import domain.JobVacancy;
import domain.Resume;
import domain.ResumeView;

/**
 * Represents a simple DAO factory.
 */
public class DAOFactory {

    private static final DAOFactory factory = new DAOFactory();

    private final DbAspirantProfileDAO AspirantProfileDAO = new DbAspirantProfileDAO();
    private final DbAspirantAccountDAO AspirantAccountDAO = new DbAspirantAccountDAO();
    private final DbAspirantResponseDAO AspirantResponseDAO = new DbAspirantResponseDAO();
    private final DbCompanyDAO CompanyDAO = new DbCompanyDAO();
    private final DbHRManagerDAO HRManagerDAO = new DbHRManagerDAO();
    private final DbInvitationDAO InvitationDAO = new DbInvitationDAO();
    private final DbJobVacancyDAO JobVacancyDAO = new DbJobVacancyDAO();
    private final DbResumeDAO ResumeDAO = new DbResumeDAO();
    private final DbResumeViewDAO ResumeViewDAO = new DbResumeViewDAO();

    private DAOFactory() {
    }

    /**
     * Returns an instance of the {@link DAOFactory} in singleton scope.
     * @return instance of the {@link DAOFactory}
     */
    public static DAOFactory getInstance() {
        return factory;
    }

    /**
     * Returns an instance of the {@link DAO<AspirantAccount>} in singleton scope.
     * @return instance of the {@link DAO<AspirantAccount>}
     */
    public DAO<AspirantAccount> getAspirantAccountDAO() {
        return AspirantAccountDAO;
    }

    /**
     * Returns an instance of the {@link DAO<AspirantProfile>} in singleton scope.
     * @return instance of the {@link DAO<AspirantProfile>}
     */
    public DAO<AspirantProfile> getAspirantProfileDAO() {
        return AspirantProfileDAO;
    }

    /**
     * Returns an instance of the {@link DAO<AspirantResponse>} in singleton scope.
     * @return instance of the {@link DAO<AspirantResponse>}
     */
    public DAO<AspirantResponse> getAspirantResponseDAO() {
        return AspirantResponseDAO;
    }

    /**
     * Returns an instance of the {@link DAO<Company>} in singleton scope.
     * @return instance of the {@link DAO<Company>}
     */
    public DAO<Company> getCompanyDAO() {
        return CompanyDAO;
    }

    /**
     * Returns an instance of the {@link DAO<HRManager>} in singleton scope.
     * @return instance of the {@link DAO<HRManager>}
     */
    public DAO<HRManager> getHRManagerDAO() {
        return HRManagerDAO;
    }

    /**
     * Returns an instance of the {@link DAO<Invitation>} in singleton scope.
     * @return instance of the {@link DAO<Invitation>}
     */
    public DAO<Invitation> getInvitationDAO() {
        return InvitationDAO;
    }

    /**
     * Returns an instance of the {@link DAO<JobVacancy>} in singleton scope.
     * @return instance of the {@link DAO<JobVacancy>}
     */
    public DAO<JobVacancy> getJobVacancyDAO() {
        return JobVacancyDAO;
    }

    /**
     * Returns an instance of the {@link DAO<Resume>} in singleton scope.
     * @return instance of the {@link DAO<Resume>}
     */
    public DAO<Resume> getResumeDAO() {
        return ResumeDAO;
    }

    /**
     * Returns an instance of the {@link DAO<ResumeView>} in singleton scope.
     * @return instance of the {@link DAO<ResumeView>}
     */
    public DAO<ResumeView> getResumeViewDAO() {
        return ResumeViewDAO;
    }
}
