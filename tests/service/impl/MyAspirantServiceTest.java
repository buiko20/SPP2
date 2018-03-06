package service.impl;

import dao.DAO;
import domain.AspirantAccount;
import domain.AspirantProfile;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.AspirantService;
import service.exception.AspirantAlreadyExistsException;
import service.exception.AspirantNotRegisteredException;
import service.exception.AspirantProfileNotFoundException;
import service.fake.AspirantAccountDaoFake;
import service.fake.AspirantProfileDaoFake;

import static org.junit.jupiter.api.Assertions.*;

class MyAspirantServiceTest {

    private AspirantService aspirantService;

    @BeforeEach
    void setUp() {
        DAO<AspirantAccount> aspirantAccountDAOFake = new AspirantAccountDaoFake();
        DAO<AspirantProfile> aspirantAccountDaoFake = new AspirantProfileDaoFake();
        this.aspirantService = new MyAspirantService(aspirantAccountDAOFake, aspirantAccountDaoFake);
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

}