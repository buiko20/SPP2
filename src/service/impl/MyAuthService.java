package service.impl;

import dao.DAO;
import dao.exception.DAOException;
import domain.AspirantAccount;
import domain.HRManager;
import service.AuthService;
import service.exception.AspirantAlreadyExistsException;
import service.exception.ServiceException;
import service.utils.ArgumentVerificationService;

import java.util.function.Predicate;

public class MyAuthService implements AuthService {

    private DAO<AspirantAccount> aspirantAccountDAO;
    private DAO<HRManager> hrManagerDAO;

    public MyAuthService(DAO<AspirantAccount> aspirantAccountDAO, DAO<HRManager> hrManagerDAO) {

        ArgumentVerificationService.verifyNull(aspirantAccountDAO, "aspirantAccountDAO");
        ArgumentVerificationService.verifyNull(hrManagerDAO, "hrManagerDAO");

        this.aspirantAccountDAO = aspirantAccountDAO;
        this.hrManagerDAO = hrManagerDAO;
    }

    @Override
    public void registerAspirant(AspirantAccount aspirantAccount)
            throws IllegalArgumentException, AspirantAlreadyExistsException, ServiceException {

        ArgumentVerificationService.verifyNull(aspirantAccount, "aspirantAccount");

        try {

            AspirantAccount temp = this.getAspirantAccountByEmail(aspirantAccount.getEmail());
            if (temp != null) {
                throw new AspirantAlreadyExistsException(aspirantAccount.getEmail());
            }

            this.aspirantAccountDAO.create(aspirantAccount);

        } catch (AspirantAlreadyExistsException | IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }

    }

    @Override
    public String isValidAspirantCredentials(String email, String password)
            throws IllegalArgumentException, ServiceException {

        ArgumentVerificationService.verifyString(email, "email");
        ArgumentVerificationService.verifyString(password, "password");

        try {

            AspirantAccount aspirantAccount = this.getAspirantAccountByEmail(email);
            if (aspirantAccount != null) {
                if (aspirantAccount.getPassword().equals(password)) {
                    return "aspirant";
                }

                return "error";
            }

            HRManager hrManager = this.getHRManagerByEmail(email);
            if (hrManager != null) {
                if (hrManager.getPassword().equals(password)) {
                    return "hr";
                }

                return "error";
            }

            return "";

        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    private AspirantAccount getAspirantAccountByEmail(String email)
            throws IllegalArgumentException, DAOException {

        ArgumentVerificationService.verifyString(email, "email");

        Predicate<AspirantAccount> mailPredicate =
                aspirantAccount -> aspirantAccount.getEmail().equals(email);

        return this.aspirantAccountDAO.getBy(mailPredicate);
    }

    private HRManager getHRManagerByEmail(String email)
            throws IllegalArgumentException, DAOException {

        ArgumentVerificationService.verifyString(email, "email");

        Predicate<HRManager> mailPredicate =
                HRManager -> HRManager.getEmail().equals(email);

        return this.hrManagerDAO.getBy(mailPredicate);
    }
}
