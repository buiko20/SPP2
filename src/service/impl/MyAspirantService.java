package service.impl;

import dao.DAO;
import domain.AspirantAccount;
import domain.AspirantProfile;
import service.AspirantService;
import service.exception.AspirantAlreadyExistsException;
import service.exception.AspirantNotRegisteredException;
import service.exception.AspirantProfileNotFoundException;
import service.exception.ServiceException;
import service.utils.ArgumentVerificationService;

import java.util.function.Predicate;

public class MyAspirantService implements AspirantService {

    private DAO<AspirantAccount> aspirantAccountDao;
    private DAO<AspirantProfile> aspirantProfileDAO;

    public MyAspirantService(DAO<AspirantAccount> aspirantAccountDao, DAO<AspirantProfile> aspirantProfileDAO) throws IllegalArgumentException {

        ArgumentVerificationService.verifyNull(aspirantAccountDao, "aspirantAccountDao");
        ArgumentVerificationService.verifyNull(aspirantProfileDAO, "aspirantProfileDAO");

        this.aspirantAccountDao = aspirantAccountDao;
        this.aspirantProfileDAO = aspirantProfileDAO;
    }

    @Override
    public void register(AspirantAccount aspirantAccount) throws IllegalArgumentException, AspirantAlreadyExistsException, ServiceException {

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
    public boolean isValidCredentials(String email, String password) throws IllegalArgumentException, AspirantNotRegisteredException, ServiceException {

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

    @Override
    public void addAspirantProfile(String email, AspirantProfile aspirantProfile) throws IllegalArgumentException, AspirantNotRegisteredException, ServiceException {

        ArgumentVerificationService.verifyString(email, "email");
        ArgumentVerificationService.verifyNull(aspirantProfile, "aspirantProfile");

        try {

            AspirantAccount aspirantAccount = this.getAspirantAccountByEmail(email);
            if (aspirantAccount == null) {
                throw new AspirantNotRegisteredException(email);
            }

            // After calling this method aspirantProfileId will be set by dao.
            this.aspirantProfileDAO.create(aspirantProfile);

            aspirantAccount.setAspirantProfileId(aspirantProfile.getId());
            this.aspirantAccountDao.update(aspirantAccount);

        } catch (AspirantNotRegisteredException | ServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public AspirantProfile getAspirantProfile(String email) throws IllegalArgumentException, AspirantNotRegisteredException, ServiceException {

        ArgumentVerificationService.verifyString(email, "email");

        try {

            AspirantAccount aspirantAccount = this.getAspirantAccountByEmail(email);
            if (aspirantAccount == null) {
                throw new AspirantNotRegisteredException(email);
            }

            return this.aspirantProfileDAO.getBy(aspirantProfile -> aspirantProfile.getId() == aspirantAccount.getAspirantProfileId());

        } catch (AspirantNotRegisteredException | ServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void updateAspirantProfile(String email, AspirantProfile aspirantProfile)
            throws IllegalArgumentException, AspirantNotRegisteredException, AspirantProfileNotFoundException, ServiceException {

        ArgumentVerificationService.verifyString(email, "email");
        ArgumentVerificationService.verifyNull(aspirantProfile, "aspirantProfile");

        try {

            AspirantProfile temp = this.getAspirantProfile(email);
            if (temp == null) {
                throw new AspirantProfileNotFoundException();
            }

            aspirantProfile.setId(temp.getId());
            this.aspirantProfileDAO.update(aspirantProfile);

        } catch (AspirantNotRegisteredException | AspirantProfileNotFoundException | ServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }

    }
}
