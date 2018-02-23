package service.impl;

import dao.DAO;
import domain.AspirantAccount;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.AspirantService;
import service.exception.AspirantAlreadyExistsException;
import service.exception.AspirantNotRegisteredException;
import service.fake.AspirantAccountDaoFake;

import static org.junit.jupiter.api.Assertions.*;

class MyAspirantServiceTest {

    private AspirantService aspirantService;

    @BeforeEach
    void setUp() {
        DAO<AspirantAccount> aspirantAccountDAOFake = new AspirantAccountDaoFake();
        this.aspirantService = new MyAspirantService(aspirantAccountDAOFake);
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

}