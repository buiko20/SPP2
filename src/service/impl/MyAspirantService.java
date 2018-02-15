package service.impl;

import dao.DAO;
import dao.DAOFactory;
import domain.AspirantAccount;
import service.AspirantService;
import service.exception.ServiceException;

import java.util.function.Predicate;

public class MyAspirantService implements AspirantService {

    private DAO<AspirantAccount> aspirantAccountDao = DAOFactory.getInstance().getAspirantAccountDAO();

    @Override
    public AspirantAccount getAspirantAccountByEmail(String email) throws ServiceException {

        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("email is null, empty or white space.");
        }

        try {

            Predicate<AspirantAccount> mailPredicate =
                    aspirantAccount -> aspirantAccount.getEmail().equals(email);
            return aspirantAccountDao.getBy(mailPredicate);

        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

}
