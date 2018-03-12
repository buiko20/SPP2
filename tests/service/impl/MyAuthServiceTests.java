package service.impl;

import dao.DAO;
import domain.AspirantAccount;
import domain.HRManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.AuthService;
import service.fake.AspirantAccountDaoFake;
import service.fake.HRManagerDaoFake;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyAuthServiceTests {

    private AuthService authService;

    @BeforeEach
    void setUp() {
        DAO<AspirantAccount> aspirantAccountDAO = new AspirantAccountDaoFake();
        DAO<HRManager> hrManagerDAO = new HRManagerDaoFake();
        authService = new MyAuthService(aspirantAccountDAO, hrManagerDAO);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void registerAspirantANDisValidAspirantCredentialsTests() throws Exception {
        AspirantAccount aspirantAccount = new AspirantAccount();
        aspirantAccount.setEmail("email");
        aspirantAccount.setPassword("password");

        this.authService.registerAspirant(aspirantAccount);

        String result1 = this.authService.isValidAspirantCredentials("123", "123");
        assertTrue(() -> result1.equals(""));

        String result2 = this.authService.isValidAspirantCredentials("email", "password");
        assertTrue(() -> result2.equals("aspirant"));

        String result3 = this.authService.isValidAspirantCredentials("email", "pass");
        assertTrue(() -> result3.equals("error"));
    }

}
