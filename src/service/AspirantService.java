package service;

import domain.AspirantAccount;
import domain.AspirantProfile;
import domain.Invitation;
import domain.JobVacancy;
import domain.Resume;
import domain.ResumeView;
import service.exception.AspirantAlreadyExistsException;
import service.exception.AspirantNotRegisteredException;
import service.exception.AspirantProfileNotFoundException;
import service.exception.HRManagerNotFoundException;
import service.exception.ResumeNotFoundException;
import service.exception.ServiceException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Represents an AspirantService responsible for working with an aspirant.
 */
public interface AspirantService {

    @Deprecated
    /**
     * Adds an aspirant to the system.
     * @param aspirantAccount aspirant account
     * @throws IllegalArgumentException when aspirantAccount is null.
     * @throws AspirantAlreadyExistsException when aspirant already exists in the system.
     * @throws ServiceException when an error occurred in service.
     */
    void register(AspirantAccount aspirantAccount)
            throws IllegalArgumentException, AspirantAlreadyExistsException, ServiceException;

    @Deprecated
    /**
     * Checks an aspirant credentials.
     * @param email aspirant email
     * @param password aspirant password
     * @return true if email and password are correct otherwise false.
     * @throws IllegalArgumentException when email or password is null, empty or whitespace.
     * @throws AspirantNotRegisteredException when aspirant is not registered in the system.
     * @throws ServiceException when an error occurred in service.
     */
    boolean isValidCredentials(String email, String password)
            throws IllegalArgumentException, AspirantNotRegisteredException, ServiceException;

    /**
     * Returns {@link AspirantAccount} with specific email.
     * @param email aspirant email.
     * @return instance of {@link AspirantAccount} or null
     * if AspirantAccount with specific email  not found.
     * @throws ServiceException when error occurred in service.
     * @throws IllegalArgumentException when email is null, empty or white space.
     */
    AspirantAccount getAspirantAccountByEmail(String email)
            throws IllegalArgumentException, ServiceException;

    /**
     * Add aspirantProfile to aspirantAccount identifiable by email.
     * @param email aspirant email.
     * @param aspirantProfile aspirant profile.
     * @throws IllegalArgumentException when email is null, empty or whitespace or aspirantProfile is null.
     * @throws ServiceException when an error occurred in service.
     */
    void addAspirantProfile(String email, AspirantProfile aspirantProfile)
            throws IllegalArgumentException, ServiceException;

    /**
     * Returns an aspirant profile identifiable by aspirant account email.
     * @param email aspirant email.
     * @return An aspirant profile or null if profile is not found.
     * @throws IllegalArgumentException when email is null, empty or whitespace.
     * @throws ServiceException when an error occurred in service.
     */
    AspirantProfile getAspirantProfile(String email)
            throws IllegalArgumentException, ServiceException;

    /**
     * Updates existing aspirant profile identifiable by aspirant account email.
     * @param email aspirant email.
     * @param aspirantProfile aspirant profile.
     * @throws IllegalArgumentException when email is null, empty or whitespace or aspirantProfile is null.
     * @throws AspirantProfileNotFoundException when aspirant profile not found. Aspirant account have no profile.
     * @throws ServiceException when an error occurred in service.
     */
    void updateAspirantProfile(String email, AspirantProfile aspirantProfile)
            throws IllegalArgumentException, AspirantNotRegisteredException, AspirantProfileNotFoundException, ServiceException;

    /**
     * Add aspirant resume.
     * @param email aspirant email.
     * @param resume aspirant resume.
     * @throws IllegalArgumentException when email is null, empty or whitespace or resume is null.
     * @throws ServiceException when an error occurred in service.
     */
    void addAspirantResume(String email, Resume resume)
            throws IllegalArgumentException, ServiceException;

    /**
     * Returns all aspirant resume.
     * @param email aspirant email.
     * @return list of aspirant resume.
     * @throws IllegalArgumentException when email is null, empty or whitespace.
     * @throws ServiceException when an error occurred in service.
     */
    ArrayList<Resume> getAllAspirantResume(String email)
            throws IllegalArgumentException, ServiceException;

    /**
     * Returns an aspirant resume.
     * @param email aspirant email.
     * @param careerObjective career objective of the resume.
     * @return aspirant resume.
     * @throws IllegalArgumentException when email or careerObjective is null, empty or whitespace.
     * @throws ServiceException when an error occurred in service.
     */
    Resume getAspirantResume(String email, String careerObjective)
            throws IllegalArgumentException, ServiceException;

    /**
     * Delete aspirant resume.
     * @param email aspirant email.
     * @param careerObjective career objective of the resume.
     * @throws IllegalArgumentException when email or careerObjective is null, empty or whitespace.
     * @throws ServiceException when an error occurred in service.
     */
    void deleteAspirantResume(String email, String careerObjective)
            throws IllegalArgumentException, ServiceException;

    /**
     * Update aspirant resume.
     * @param email aspirant email.
     * @param careerObjective career objective of the resume.
     * @param resume aspirant resume.
     * @throws IllegalArgumentException when email or careerObjective is null, empty or whitespace.
     * @throws ResumeNotFoundException when aspirant resume not found.
     * @throws ServiceException when an error occurred in service.
     */
    void updateAspirantResume(String email, String careerObjective, Resume resume)
            throws IllegalArgumentException, ResumeNotFoundException, ServiceException;

    /**
     * Update resume date.
     * @param email aspirant email.
     * @param careerObjective career objective of the resume.
     * @param newDate new resume date.
     * @throws IllegalArgumentException when email or careerObjective is null, empty or whitespace or newDate is null.
     * @throws ResumeNotFoundException when aspirant resume not found.
     * @throws ServiceException when an error occurred in service.
     */
    void updateAspirantResumeDate(String email, String careerObjective, Date newDate)
            throws IllegalArgumentException, ResumeNotFoundException, ServiceException;

    /**
     * Return all aspirant resume view.
     * @param email aspirant email.
     * @param careerObjective career objective of the resume.
     * @return list of resume view.
     * @throws IllegalArgumentException when email or careerObjective is null, empty or whitespace or newDate is null.
     * @throws ResumeNotFoundException when aspirant resume not found.
     * @throws ServiceException when an error occurred in service.
     */
    ArrayList<ResumeView> getAllAspirantResumeViews(String email, String careerObjective)
            throws IllegalArgumentException, ResumeNotFoundException, ServiceException;

    ArrayList<Invitation> getAllAspirantInvitations(String email)
            throws IllegalArgumentException, ServiceException;

    Invitation getInvitation(String email, String careerObjective, String jobVacancyName, String companyName)
            throws IllegalArgumentException, ServiceException;

    AspirantAccount getAspirantAccountById(int id) throws ServiceException;

    Resume getResumeById(int id) throws ServiceException;

    ArrayList<Resume> getAllResume() throws ServiceException;

    void addAspirantResumeView(String aspirantEmail, String careerObjective, String HRManagerEmail)
            throws IllegalArgumentException, AspirantNotRegisteredException, ResumeNotFoundException, HRManagerNotFoundException, ServiceException;
}
