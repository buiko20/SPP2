package service.impl;

import dao.DAO;
import domain.AspirantAccount;
import domain.AspirantProfile;
import domain.Company;
import domain.Invitation;
import domain.JobVacancy;
import domain.Resume;
import domain.ResumeView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.AspirantService;
import service.CompanyService;
import service.JobVacancyService;
import service.exception.AspirantAlreadyExistsException;
import service.exception.AspirantNotRegisteredException;
import service.exception.AspirantProfileNotFoundException;
import service.exception.ResumeNotFoundException;
import service.fake.AspirantAccountDaoFake;
import service.fake.AspirantProfileDaoFake;
import service.fake.AspirantResumeDaoFake;
import service.fake.AspirantResumeViewDaoFake;
import service.fake.CompanyDaoFake;
import service.fake.InvitationDaoFake;
import service.fake.JobVacancyDaoFake;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class MyAspirantServiceTests {

    private AspirantService aspirantService;

    @BeforeEach
    void setUp() {
        DAO<AspirantAccount> aspirantAccountDAOFake = new AspirantAccountDaoFake();
        DAO<AspirantProfile> aspirantAccountDaoFake = new AspirantProfileDaoFake();
        DAO<Resume> resumeDAO = new AspirantResumeDaoFake();
        DAO<ResumeView> resumeViewDAO = new AspirantResumeViewDaoFake();
        DAO<Invitation> invitationDAO = new InvitationDaoFake();

        DAO<JobVacancy> jobVacancyDAO = new JobVacancyDaoFake();
        JobVacancyService jobVacancyService = new MyJobVacancyService(jobVacancyDAO);

        DAO<Company> companyDAO = new CompanyDaoFake();
        CompanyService companyService = new MyCompanyService(companyDAO);

        this.aspirantService = new MyAspirantService(
                aspirantAccountDAOFake, aspirantAccountDaoFake, resumeDAO,
                resumeViewDAO, invitationDAO, jobVacancyService, companyService);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void register_aspirant_aspirantAdded() throws Exception {
        // Arrange.
        String aspirantEmail = "email";
        String aspirantPassword = "password";
        int aspirantProfileId = -1;
        AspirantAccount aspirantAccount = new AspirantAccount(aspirantEmail, aspirantPassword , aspirantProfileId);

        // Act.
        this.aspirantService.register(aspirantAccount);

        // Assert.
        aspirantAccount = this.aspirantService.getAspirantAccountByEmail(aspirantEmail);
        assertEquals(aspirantProfileId, aspirantAccount.getAspirantProfileId());
        assertEquals(aspirantPassword, aspirantAccount.getPassword());
    }

    @Test
    void register_nullAspirant_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.register(null));
    }

    @Test
    void register_registeredAspirant_throwsAspirantAlreadyExistsException() throws Exception {
        // Arrange.
        String aspirantEmail = "email";
        String aspirantPassword = "password";
        int aspirantProfileId = -1;
        AspirantAccount aspirantAccount = new AspirantAccount(aspirantEmail, aspirantPassword , aspirantProfileId);

        // Act.
        this.aspirantService.register(aspirantAccount);

        // Assert.
        assertThrows(AspirantAlreadyExistsException.class, () -> this.aspirantService.register(aspirantAccount));
    }

    @Test
    void isValidCredentials_nullEmptyWhitespaceArgs_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.isValidCredentials("", "password"));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.isValidCredentials("       ", "password"));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.isValidCredentials(null, "password"));

        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.isValidCredentials("email", ""));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.isValidCredentials("email", "     "));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.isValidCredentials("email", null));
    }

    @Test
    void isValidCredentials_notExistingAspirant_throwsAspirantNotRegisteredException() {
        assertThrows(AspirantNotRegisteredException.class, () -> this.aspirantService.isValidCredentials("email", "password"));
    }

    @Test
    void isValidCredentials_existingAspirant_trueReturned() throws Exception {
        // Arrange.
        String aspirantEmail = "email";
        String aspirantPassword = "password";
        int aspirantProfileId = -1;
        AspirantAccount aspirantAccount = new AspirantAccount(aspirantEmail, aspirantPassword , aspirantProfileId);

        // Act.
        this.aspirantService.register(aspirantAccount);

        // Assert.
        boolean result = this.aspirantService.isValidCredentials(aspirantEmail, aspirantPassword);
        assertTrue(result);
    }

    @Test
    void isValidCredentials_existingAspirant_falseReturned() throws Exception {
        // Arrange.
        String aspirantEmail = "email";
        String aspirantPassword = "password";
        int aspirantProfileId = -1;
        AspirantAccount aspirantAccount = new AspirantAccount(aspirantEmail, aspirantPassword , aspirantProfileId);

        // Act.
        this.aspirantService.register(aspirantAccount);
        boolean resultWrongPassword = this.aspirantService.isValidCredentials(aspirantEmail, "wrong_password");

        // Assert.
        assertFalse(resultWrongPassword);
    }

    @Test
    void getAspirantAccountByEmail_email_aspirantAccountReturned() throws Exception {
        // Arrange.
        String aspirantEmail = "email";
        String aspirantPassword = "password";
        int aspirantProfileId = -1;
        AspirantAccount aspirantAccount = new AspirantAccount(aspirantEmail, aspirantPassword , aspirantProfileId);

        // Act.
        this.aspirantService.register(aspirantAccount);

        // Assert.
        aspirantAccount = this.aspirantService.getAspirantAccountByEmail(aspirantEmail);
        assertEquals(aspirantProfileId, aspirantAccount.getAspirantProfileId());
        assertEquals(aspirantPassword, aspirantAccount.getPassword());
    }

    @Test
    void getAspirantAccountByEmail_nullEmptyWhitespaceArgs_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.getAspirantAccountByEmail(""));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.getAspirantAccountByEmail("     "));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.getAspirantAccountByEmail(null));
    }

    @Test
    void addAspirantProfile_nullEmptyWhitespaceArgs_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.addAspirantProfile("", null));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.addAspirantProfile("   ", null));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.addAspirantProfile(null, null));

        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.addAspirantProfile("email", null));

        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.addAspirantProfile("", new AspirantProfile()));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.addAspirantProfile("   ", new AspirantProfile()));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.addAspirantProfile(null, new AspirantProfile()));
    }

    @Test
    void addAspirantProfile_aspirantProfile_aspirantProfileAdded() throws Exception {
        // Arrange.
        String aspirantEmail = "email";
        int aspirantProfileId = 1;

        AspirantProfile aspirantProfile = new AspirantProfile();
        aspirantProfile.setId(aspirantProfileId);
        AspirantAccount aspirantAccount = new AspirantAccount(aspirantEmail, "password", 0);

        // Act.
        this.aspirantService.register(aspirantAccount);
        this.aspirantService.addAspirantProfile(aspirantEmail, aspirantProfile);

        // Assert.
        aspirantAccount = this.aspirantService.getAspirantAccountByEmail(aspirantEmail);
        assertEquals(aspirantAccount.getAspirantProfileId(), aspirantProfileId);
    }

    @Test
    void getAspirantProfile_nullEmptyWhitespaceArgs_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.getAspirantProfile(""));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.getAspirantProfile("     "));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.getAspirantProfile(null));
    }

    @Test
    void getAspirantProfile_aspirantProfile_aspirantProfileReturned() throws Exception {
        // Arrange.
        String aspirantEmail = "email";
        int aspirantProfileId = 1;

        AspirantProfile aspirantProfile = new AspirantProfile();
        aspirantProfile.setId(aspirantProfileId);
        AspirantAccount aspirantAccount = new AspirantAccount(aspirantEmail, "password", 0);

        // Act.
        this.aspirantService.register(aspirantAccount);
        this.aspirantService.addAspirantProfile(aspirantEmail, aspirantProfile);

        // Assert.
        aspirantProfile = this.aspirantService.getAspirantProfile(aspirantEmail);
        assertEquals(aspirantProfile.getId(), aspirantProfileId);
    }

    @Test
    void updateAspirantProfile_nullEmptyWhitespaceArgs_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.updateAspirantProfile("", null));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.updateAspirantProfile("   ", null));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.updateAspirantProfile(null, null));

        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.updateAspirantProfile("email", null));

        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.updateAspirantProfile("", new AspirantProfile()));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.updateAspirantProfile("   ", new AspirantProfile()));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.updateAspirantProfile(null, new AspirantProfile()));;
    }

    @Test
    void updateAspirantProfile_notExistingProfile_throwsAspirantProfileNotFoundException() throws Exception {
        // Arrange.
        String aspirantEmail = "email";
        int aspirantProfileId = 1;

        AspirantProfile aspirantProfile = new AspirantProfile();
        aspirantProfile.setId(aspirantProfileId);
        AspirantAccount aspirantAccount = new AspirantAccount(aspirantEmail, "password", 0);

        // Act.
        this.aspirantService.register(aspirantAccount);

        // Assert.
        assertThrows(AspirantProfileNotFoundException.class, () -> this.aspirantService.updateAspirantProfile(aspirantEmail, aspirantProfile));
    }

    @Test
    void updateAspirantProfile_aspirantProfile_aspirantProfileUpdated() throws Exception {
        // Arrange.
        String aspirantEmail = "email";
        int aspirantProfileId = 1;
        String aboutMe = "I am cool :)";

        AspirantProfile aspirantProfile = new AspirantProfile();
        aspirantProfile.setId(aspirantProfileId);
        AspirantAccount aspirantAccount = new AspirantAccount(aspirantEmail, "password", 0);

        // Act.
        this.aspirantService.register(aspirantAccount);
        this.aspirantService.addAspirantProfile(aspirantEmail, aspirantProfile);
        aspirantProfile.setAboutMe(aboutMe);
        this.aspirantService.updateAspirantProfile(aspirantEmail, aspirantProfile);

        // Assert.
        aspirantProfile = this.aspirantService.getAspirantProfile(aspirantEmail);
        assertEquals(aspirantProfile.getId(), aspirantProfileId);
        assertEquals(aspirantProfile.getAboutMe(), aboutMe);
    }

    @Test
    void addAspirantResume_nullEmptyWhitespaceArgs_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.addAspirantResume("", null));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.addAspirantResume("   ", null));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.addAspirantResume(null, null));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.addAspirantResume("email", null));
    }

    @Test
    void addAspirantResume_resume_resumeAdded() throws Exception {
        // Arrange.
        AspirantAccount aspirantAccount = new AspirantAccount("email", "password", 0);
        Resume resume = new Resume();
        resume.setCareerObjective("setCareerObjective");

        // Act.
        this.aspirantService.register(aspirantAccount);
        this.aspirantService.addAspirantResume("email",resume );

        // Assert.
        resume = this.aspirantService.getAspirantResume("email", "setCareerObjective");
        assertEquals("setCareerObjective", resume.getCareerObjective());
    }

    @Test
    void getAllAspirantResume_nullEmptyWhitespaceArgs_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.getAllAspirantResume(""));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.getAllAspirantResume("   "));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.getAllAspirantResume(null));
    }

    @Test
    void getAllAspirantResume_email_resumeReturned() throws Exception {
        // Arrange.
        AspirantAccount aspirantAccount = new AspirantAccount("email", "password", 0);
        Resume resume = new Resume();

        // Act.
        this.aspirantService.register(aspirantAccount);
        this.aspirantService.addAspirantResume("email",resume);

        // Assert.
        ArrayList<Resume> result = this.aspirantService.getAllAspirantResume("email");
        assertEquals(1, result.size());
    }

    @Test
    void getAspirantResume_nullEmptyWhitespaceArgs_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.getAspirantResume("", "fwef"));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.getAspirantResume("   ", "wef"));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.getAspirantResume(null, "wef"));

        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.getAspirantResume("wef", ""));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.getAspirantResume("wef", "   "));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.getAspirantResume("wef", null));
    }

    @Test
    void getAspirantResume_emailCareerObjective_resumeReturned() throws Exception {
        // Arrange.
        AspirantAccount aspirantAccount = new AspirantAccount("email", "password", 0);
        Resume resume = new Resume();
        resume.setCareerObjective("setCareerObjective");

        // Act.
        this.aspirantService.register(aspirantAccount);
        this.aspirantService.addAspirantResume("email",resume);

        // Assert.
        resume = this.aspirantService.getAspirantResume("email", "setCareerObjective");
        assertEquals("setCareerObjective", resume.getCareerObjective());
    }

    @Test
    void getAspirantResume_notCreatedResume_resumeNull() throws Exception {
        // Arrange.
        AspirantAccount aspirantAccount = new AspirantAccount("email", "password", 0);
        Resume resume = new Resume();
        resume.setCareerObjective("setCareerObjective");

        // Act.
        this.aspirantService.register(aspirantAccount);

        // Assert.
        resume = this.aspirantService.getAspirantResume("email", "setCareerObjective");
        assertEquals(null, resume);
    }

    @Test
    void deleteAspirantResume_nullEmptyWhitespaceArgs_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.deleteAspirantResume("", "fwef"));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.deleteAspirantResume("   ", "wef"));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.deleteAspirantResume(null, "wef"));

        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.deleteAspirantResume("wef", ""));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.deleteAspirantResume("wef", "   "));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.deleteAspirantResume("wef", null));
    }

    @Test
    void deleteAspirantResume_emailCareerObjective_resumeReturned() throws Exception {
        // Arrange.
        AspirantAccount aspirantAccount = new AspirantAccount("email", "password", 0);
        Resume resume = new Resume();
        resume.setCareerObjective("setCareerObjective");

        // Act.
        this.aspirantService.register(aspirantAccount);
        this.aspirantService.addAspirantResume("email",resume);
        this.aspirantService.deleteAspirantResume("email", "setCareerObjective");

        // Assert.
        resume = this.aspirantService.getAspirantResume("email", "setCareerObjective");
        assertEquals(null, resume);
    }

    @Test
    void updateAspirantResume_nullEmptyWhitespaceArgs_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.updateAspirantResume("", "fwef", new Resume()));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.updateAspirantResume("   ", "wef", new Resume()));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.updateAspirantResume(null, "wef", new Resume()));

        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.updateAspirantResume("wef", "", new Resume()));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.updateAspirantResume("wef", "   ", new Resume()));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.updateAspirantResume("wef", null, new Resume()));

        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.updateAspirantResume("wef", "wefwef", null));
    }

    @Test
    void updateAspirantResume_notExistingResume_throwsResumeNotFoundException() throws Exception {
        // Arrange.
        AspirantAccount aspirantAccount = new AspirantAccount("email", "password", 0);

        // Act.
        this.aspirantService.register(aspirantAccount);

        // Assert.
        assertThrows(ResumeNotFoundException.class, () -> this.aspirantService.updateAspirantResume("email", "wef", new Resume()));
    }

    @Test
    void updateAspirantResume_emailCareerObjective_resumeReturned() throws Exception {
        // Arrange.
        AspirantAccount aspirantAccount = new AspirantAccount("email", "password", 0);
        Resume resume = new Resume();
        resume.setCareerObjective("setCareerObjective");

        // Act.
        this.aspirantService.register(aspirantAccount);
        this.aspirantService.addAspirantResume("email",resume);
        resume.setNumberOfViews(10);
        this.aspirantService.updateAspirantResume("email", "setCareerObjective", resume);

        // Assert.
        resume = this.aspirantService.getAspirantResume("email", "setCareerObjective");
        assertEquals(10, resume.getNumberOfViews());
    }

    @Test
    void updateAspirantResumeDate_nullEmptyWhitespaceArgs_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.updateAspirantResumeDate("", "fwef", new Date()));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.updateAspirantResumeDate("   ", "wef", new Date()));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.updateAspirantResumeDate(null, "wef", new Date()));

        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.updateAspirantResumeDate("wef", "", new Date()));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.updateAspirantResumeDate("wef", "   ", new Date()));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.updateAspirantResumeDate("wef", null, new Date()));

        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.updateAspirantResumeDate("wef", "wefwef", null));
    }

    @Test
    void updateAspirantResumeDate_notExistingResume_throwsResumeNotFoundException() throws Exception {
        // Arrange.
        AspirantAccount aspirantAccount = new AspirantAccount("email", "password", 0);

        // Act.
        this.aspirantService.register(aspirantAccount);

        // Assert.
        assertThrows(ResumeNotFoundException.class, () -> this.aspirantService.updateAspirantResumeDate("email", "wef", new Date()));
    }

    @Test
    void getAllAspirantResumeView_nullEmptyWhitespaceArgs_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.getAllAspirantResumeViews("", "fwef"));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.getAllAspirantResumeViews("   ", "wef"));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.getAllAspirantResumeViews(null, "wef"));

        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.getAllAspirantResumeViews("wef", ""));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.getAllAspirantResumeViews("wef", "   "));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.getAllAspirantResumeViews("wef", null));
    }

    @Test
    void getAllAspirantResumeView_emailCareerObjective_resumeReturned() throws Exception {
        // Arrange.
        AspirantAccount aspirantAccount = new AspirantAccount("email", "password", 0);
        Resume resume = new Resume();
        resume.setCareerObjective("setCareerObjective");

        // Act.
        this.aspirantService.register(aspirantAccount);
        this.aspirantService.addAspirantResume("email", resume);

        // Assert.
        ArrayList<ResumeView> result = this.aspirantService.getAllAspirantResumeViews("email", "setCareerObjective");
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void getAspirantResumeView_nullEmptyWhitespaceArgs_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.getAllAspirantResumeViews("", "fwef"));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.getAllAspirantResumeViews("   ", "wef"));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.getAllAspirantResumeViews(null, "wef"));

        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.getAllAspirantResumeViews("wef", ""));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.getAllAspirantResumeViews("wef", "   "));
        assertThrows(IllegalArgumentException.class, () -> this.aspirantService.getAllAspirantResumeViews("wef", null));
    }

}