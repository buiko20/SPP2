package service.fake;

import dao.DAO;
import dao.exception.DAOException;
import domain.AspirantAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AspirantAccountDaoFake implements DAO<AspirantAccount> {

    private static ArrayList<AspirantAccount> entities;

    public AspirantAccountDaoFake() {
        entities = new ArrayList<>();
    }

    @Override
    public List<AspirantAccount> getAll() throws DAOException {
        return entities;
    }

    @Override
    public AspirantAccount getBy(Predicate<AspirantAccount> predicate) throws DAOException {

        for (AspirantAccount entity : entities) {
            if (predicate.test(entity)) {
                return entity;
            }
        }

        return null;
    }

    @Override
    public void update(AspirantAccount entity) throws DAOException {
        entities.remove(entity);
        entities.add(entity);
    }

    @Override
    public void delete(int id) throws DAOException {

        int i = -1, j = 0;
        for (AspirantAccount entity : entities) {

            if (entity.getId() == id) {
                i = j;
            }

            j++;
        }

        if (i != -1) {
            entities.remove(i);
        }

    }

    @Override
    public void create(AspirantAccount entity) throws DAOException {
        entities.add(entity);
    }
}
