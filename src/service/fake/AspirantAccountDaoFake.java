package service.fake;

import dao.DAO;
import dao.exception.DAOException;
import domain.AspirantAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AspirantAccountDaoFake implements DAO<AspirantAccount> {

    private static ArrayList<AspirantAccount> aspirantAccounts;

    public AspirantAccountDaoFake() {
        aspirantAccounts = new ArrayList<>();
    }

    @Override
    public List<AspirantAccount> getAll() throws DAOException {
        return aspirantAccounts;
    }

    @Override
    public AspirantAccount getBy(Predicate<AspirantAccount> predicate) throws DAOException {

        for (AspirantAccount aspirantAccount : aspirantAccounts) {
            if (predicate.test(aspirantAccount)) {
                return aspirantAccount;
            }
        }

        return null;
    }

    @Override
    public void update(AspirantAccount entity) throws DAOException {
        aspirantAccounts.remove(entity);
        aspirantAccounts.add(entity);
    }

    @Override
    public void delete(int id) throws DAOException {

        int i = -1, j = 0;
        for (AspirantAccount aspirantAccount : aspirantAccounts) {

            if (aspirantAccount.getId() == id) {
                i = j;
            }

            j++;
        }

        if (i != -1) {
            aspirantAccounts.remove(i);
        }

    }

    @Override
    public void create(AspirantAccount entity) throws DAOException {
        aspirantAccounts.add(entity);
    }
}
