package dao;

import dao.impl.DbAspirantAccountDAO;
import dao.impl.DbAspirantProfileDAO;
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
        this.AspirantAccountDAO.setAspirantProfileDAO(this.AspirantProfileDAO);
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
        return null;
    }

    /**
     * Returns an instance of the {@link DAO<Company>} in singleton scope.
     * @return instance of the {@link DAO<Company>}
     */
    public DAO<Company> getCompanyDAO() {
        return null;
    }

    /**
     * Returns an instance of the {@link DAO<HRManager>} in singleton scope.
     * @return instance of the {@link DAO<HRManager>}
     */
    public DAO<HRManager> getHRManagerDAO() {
        return null;
    }

    /**
     * Returns an instance of the {@link DAO<Invitation>} in singleton scope.
     * @return instance of the {@link DAO<Invitation>}
     */
    public DAO<Invitation> getInvitationDAO() {
        return null;
    }

    /**
     * Returns an instance of the {@link DAO<JobVacancy>} in singleton scope.
     * @return instance of the {@link DAO<JobVacancy>}
     */
    public DAO<JobVacancy> getJobVacancyDAO() {
        return null;
    }

    /**
     * Returns an instance of the {@link DAO<Resume>} in singleton scope.
     * @return instance of the {@link DAO<Resume>}
     */
    public DAO<Resume> getResumeDAO() {
        return null;
    }

    /**
     * Returns an instance of the {@link DAO<ResumeView>} in singleton scope.
     * @return instance of the {@link DAO<ResumeView>}
     */
    public DAO<ResumeView> getResumeViewDAO() {
        return null;
    }
}
