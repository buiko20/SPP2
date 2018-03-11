package service.impl;

import dao.DAO;
import domain.AspirantAccount;
import domain.AspirantProfile;
import domain.Company;
import domain.Invitation;
import domain.JobVacancy;
import domain.Resume;
import domain.ResumeView;
import service.AspirantService;
import service.CompanyService;
import service.JobVacancyService;
import service.exception.AspirantAlreadyExistsException;
import service.exception.AspirantNotRegisteredException;
import service.exception.AspirantProfileNotFoundException;
import service.exception.ResumeNotFoundException;
import service.exception.ServiceException;
import service.utils.ArgumentVerificationService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

public class MyAspirantService implements AspirantService {

    private DAO<AspirantAccount> aspirantAccountDao;
    private DAO<AspirantProfile> aspirantProfileDAO;
    private DAO<Resume> resumeDAO;
    private DAO<ResumeView> resumeViewDAO;
    private DAO<Invitation> invitationDAO;
    private JobVacancyService jobVacancyService;
    private CompanyService companyService;

    public MyAspirantService(DAO<AspirantAccount> aspirantAccountDao, DAO<AspirantProfile> aspirantProfileDAO,
                             DAO<Resume> resumeDAO, DAO<ResumeView> resumeViewDAO, DAO<Invitation> invitationDAO,
                             JobVacancyService jobVacancyService, CompanyService companyService)
            throws IllegalArgumentException {

        ArgumentVerificationService.verifyNull(aspirantAccountDao, "aspirantAccountDao");
        ArgumentVerificationService.verifyNull(aspirantProfileDAO, "aspirantProfileDAO");
        ArgumentVerificationService.verifyNull(resumeDAO, "resumeDAO");
        ArgumentVerificationService.verifyNull(resumeViewDAO, "resumeViewDAO");
        ArgumentVerificationService.verifyNull(invitationDAO, "invitationDAO");
        ArgumentVerificationService.verifyNull(jobVacancyService, "jobVacancyService");
        ArgumentVerificationService.verifyNull(companyService, "companyService");

        this.aspirantAccountDao = aspirantAccountDao;
        this.aspirantProfileDAO = aspirantProfileDAO;
        this.resumeDAO = resumeDAO;
        this.resumeViewDAO = resumeViewDAO;
        this.invitationDAO = invitationDAO;
        this.jobVacancyService = jobVacancyService;
        this.companyService = companyService;
    }

    @Override
    public void register(AspirantAccount aspirantAccount)
            throws IllegalArgumentException, AspirantAlreadyExistsException, ServiceException {

        ArgumentVerificationService.verifyNull(aspirantAccount, "aspirantAccount");

        try {

            AspirantAccount temp = this.getAspirantAccountByEmail(aspirantAccount.getEmail());
            if (temp != null) {
                throw new AspirantAlreadyExistsException(aspirantAccount.getEmail());
            }

            aspirantAccountDao.create(aspirantAccount);

        } catch (AspirantAlreadyExistsException | ServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }

    }

    @Override
    public boolean isValidCredentials(String email, String password)
            throws IllegalArgumentException, AspirantNotRegisteredException, ServiceException {

        ArgumentVerificationService.verifyString(email, "email");
        ArgumentVerificationService.verifyString(password, "password");

        try {

            AspirantAccount aspirantAccount = this.getAspirantAccountByEmail(email);
            if (aspirantAccount == null) {
                throw new AspirantNotRegisteredException(email);
            }

            return password.equals(aspirantAccount.getPassword());

        } catch (AspirantNotRegisteredException | ServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public AspirantAccount getAspirantAccountByEmail(String email)
            throws IllegalArgumentException, ServiceException {

        ArgumentVerificationService.verifyString(email, "email");

        try {

            Predicate<AspirantAccount> mailPredicate =
                    aspirantAccount -> aspirantAccount.getEmail().equals(email);

            return aspirantAccountDao.getBy(mailPredicate);

        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void addAspirantProfile(String email, AspirantProfile aspirantProfile)
            throws IllegalArgumentException, ServiceException {

        ArgumentVerificationService.verifyString(email, "email");
        ArgumentVerificationService.verifyNull(aspirantProfile, "aspirantProfile");

        try {

            AspirantAccount aspirantAccount = this.getAspirantAccountByEmail(email);

            // After calling this method aspirantProfileId will be set by dao.
            this.aspirantProfileDAO.create(aspirantProfile);

            aspirantAccount.setAspirantProfileId(aspirantProfile.getId());
            this.aspirantAccountDao.update(aspirantAccount);

        } catch (ServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public AspirantProfile getAspirantProfile(String email)
            throws IllegalArgumentException, ServiceException {

        ArgumentVerificationService.verifyString(email, "email");

        try {

            AspirantAccount aspirantAccount = this.getAspirantAccountByEmail(email);

            return this.aspirantProfileDAO.getBy(aspirantProfile -> aspirantProfile.getId() == aspirantAccount.getAspirantProfileId());

        } catch (ServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void updateAspirantProfile(String email, AspirantProfile aspirantProfile)
            throws IllegalArgumentException, AspirantProfileNotFoundException, ServiceException {

        ArgumentVerificationService.verifyString(email, "email");
        ArgumentVerificationService.verifyNull(aspirantProfile, "aspirantProfile");

        try {

            AspirantProfile temp = this.getAspirantProfile(email);
            if (temp == null) {
                throw new AspirantProfileNotFoundException();
            }

            aspirantProfile.setId(temp.getId());
            this.aspirantProfileDAO.update(aspirantProfile);

        } catch (AspirantProfileNotFoundException | ServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }

    }

    @Override
    public void addAspirantResume(String email, Resume resume)
            throws IllegalArgumentException, ServiceException {

        ArgumentVerificationService.verifyString(email, "email");
        ArgumentVerificationService.verifyNull(resume, "resume");

        try {
            this.resumeDAO.create(resume);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }

    }

    @Override
    public ArrayList<Resume> getAllAspirantResume(String email)
            throws IllegalArgumentException, ServiceException {

        ArgumentVerificationService.verifyString(email, "email");

        try {

            ArrayList<Resume> result = new ArrayList<>();
            List<Resume> resumes = this.resumeDAO.getAll();
            int aspirantAccountId = this.getAspirantAccountByEmail(email).getId();

            for (Resume resume : resumes) {
                int aspirantId = resume.getAspirantId();
                if (aspirantAccountId == aspirantId) {
                    result.add(resume);
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
    public Resume getAspirantResume(String email, String careerObjective)
            throws IllegalArgumentException, ServiceException {

        ArgumentVerificationService.verifyString(email, "email");
        ArgumentVerificationService.verifyString(careerObjective, "careerObjective");

        try {

            ArrayList<Resume> resumes = this.getAllAspirantResume(email);
            for (Resume resume : resumes) {
                if (resume.getCareerObjective().equals(careerObjective)) {
                    return resume;
                }
            }

            return null;

        } catch (ServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }

    }

    @Override
    public void deleteAspirantResume(String email, String careerObjective)
            throws IllegalArgumentException, ServiceException {

        ArgumentVerificationService.verifyString(email, "email");
        ArgumentVerificationService.verifyString(careerObjective, "careerObjective");

        try {

            Resume resume = this.getAspirantResume(email, careerObjective);
            this.resumeDAO.delete(resume.getId());

        } catch (ServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }

    }

    @Override
    public void updateAspirantResume(String email, String careerObjective, Resume resume)
            throws IllegalArgumentException, ResumeNotFoundException, ServiceException {

        ArgumentVerificationService.verifyString(email, "email");
        ArgumentVerificationService.verifyString(careerObjective, "careerObjective");
        ArgumentVerificationService.verifyNull(resume, "resume");

        try {

            Resume oldResume = this.getAspirantResume(email, careerObjective);
            if (oldResume == null) {
                throw new ResumeNotFoundException(email, careerObjective);
            }

            resume.setId(oldResume.getId());
            this.resumeDAO.update(resume);

        } catch (ResumeNotFoundException | ServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }

    }

    @Override
    public ArrayList<ResumeView> getAllAspirantResumeViews(String email, String careerObjective)
            throws IllegalArgumentException, ResumeNotFoundException, ServiceException {

        ArgumentVerificationService.verifyString(email, "email");
        ArgumentVerificationService.verifyString(careerObjective, "careerObjective");

        try {

            Resume resume = this.getAspirantResume(email, careerObjective);
            if (resume == null) {
                throw new ResumeNotFoundException(email, careerObjective);
            }

            ArrayList<ResumeView> result = new ArrayList<>();
            List<ResumeView> views = this.resumeViewDAO.getAll();

            for (ResumeView view : views) {
                if (view.getResumeId() == resume.getId()) {
                    result.add(view);
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
    public void updateAspirantResumeDate(String email, String careerObjective, Date newDate)
            throws IllegalArgumentException, ResumeNotFoundException, ServiceException {

        ArgumentVerificationService.verifyString(email, "email");
        ArgumentVerificationService.verifyString(careerObjective, "careerObjective");
        ArgumentVerificationService.verifyNull(newDate, "newDate");

        try {

            Resume resume = this.getAspirantResume(email, careerObjective);
            if (resume == null) {
                throw new ResumeNotFoundException(email, careerObjective);
            }

            resume.setDate(newDate);
            this.resumeDAO.update(resume);

        } catch (ResumeNotFoundException | ServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }

    }

    @Override
    public ArrayList<Invitation> getAllAspirantInvitations(String email)
            throws IllegalArgumentException, ServiceException {

        ArgumentVerificationService.verifyString(email, "email");

        try {
            List<Invitation> invitations = this.invitationDAO.getAll();
            return new ArrayList<>(invitations);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Invitation getInvitation(String email, String careerObjective, String jobVacancyName, String companyName)
            throws IllegalArgumentException, ServiceException {

        ArgumentVerificationService.verifyString(email, "email");
        ArgumentVerificationService.verifyString(careerObjective, "careerObjective");
        ArgumentVerificationService.verifyString(jobVacancyName, "jobVacancyName");
        ArgumentVerificationService.verifyString(companyName, "companyName");

        try {
            Resume resume = this.getAspirantResume(email, careerObjective);
            JobVacancy jobVacancy = this.jobVacancyService.getJobVacancy(jobVacancyName);
            Company company = this.companyService.getCompanyByName(companyName);

            Predicate<Invitation> predicate = i -> i.getResumeId() == resume.getId() &&
                    i.getAspirantAccountId() == resume.getAspirantId() &&
                    i.getJobVacancyId() == jobVacancy.getId() && i.getCompanyId() == company.getId();

            return this.invitationDAO.getBy(predicate);

        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
