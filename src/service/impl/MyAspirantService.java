package service.impl;

import dao.DAO;
import dao.DAOFactory;
import domain.AspirantAccount;
import service.AspirantService;
import service.exception.AspirantAlreadyExistsException;
import service.exception.AspirantNotRegisteredException;
import service.exception.ServiceException;

import java.util.function.Predicate;

public class MyAspirantService implements AspirantService {

    private DAO<AspirantAccount> aspirantAccountDao = DAOFactory.getInstance().getAspirantAccountDAO();

    @Override
    public void register(AspirantAccount aspirantAccount) throws AspirantAlreadyExistsException, ServiceException {

        ArgumentVerificationService.verifyNull(aspirantAccount, "aspirantAccount");

        try {

            AspirantAccount temp = this.getAspirantAccountByEmail(aspirantAccount.getEmail());
            if (temp != null) {
                throw new AspirantAlreadyExistsException(aspirantAccount.getEmail());
            }

            aspirantAccountDao.create(aspirantAccount);

        } catch (AspirantAlreadyExistsException e) {
            throw e;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }

    }

    @Override
    public boolean isValidCredentials(String email, String password) throws AspirantNotRegisteredException, ServiceException {

        ArgumentVerificationService.verifyString(email, "email");
        ArgumentVerificationService.verifyString(password, "password");

        try {

            AspirantAccount aspirantAccount = this.getAspirantAccountByEmail(email);
            if (aspirantAccount == null) {
                throw new AspirantNotRegisteredException(email);
            }

            return password.equals(aspirantAccount.getPassword());

        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public AspirantAccount getAspirantAccountByEmail(String email) throws IllegalArgumentException, ServiceException {

        ArgumentVerificationService.verifyString(email, "email");

        try {

            Predicate<AspirantAccount> mailPredicate =
                    aspirantAccount -> aspirantAccount.getEmail().equals(email);
            return aspirantAccountDao.getBy(mailPredicate);

        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

}
