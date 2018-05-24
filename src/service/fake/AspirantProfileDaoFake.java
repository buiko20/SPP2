package service.fake;

import dao.DAO;
import dao.exception.DAOException;
import domain.AspirantProfile;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AspirantProfileDaoFake implements DAO<AspirantProfile> {

    private static ArrayList<AspirantProfile> entities;

    public AspirantProfileDaoFake() {
        entities = new ArrayList<>();
    }

    @Override
    public List<AspirantProfile> getAll() throws DAOException {
        return entities;
    }

    @Override
    public AspirantProfile getBy(Predicate<AspirantProfile> predicate) throws DAOException {

        for (AspirantProfile entity : entities) {
            if (predicate.test(entity)) {
                return entity;
            }
        }

        return null;
    }

    @Override
    public void update(AspirantProfile entity) throws DAOException {
        entities.remove(entity);
        entities.add(entity);
    }

    @Override
    public void delete(int id) throws DAOException {

        int i = -1, j = 0;
        for (AspirantProfile entity : entities) {

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
    public void create(AspirantProfile entity) throws DAOException {
        entities.add(entity);
    }

}
