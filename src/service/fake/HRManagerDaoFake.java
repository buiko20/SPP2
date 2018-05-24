package service.fake;

import dao.DAO;
import dao.exception.DAOException;
import domain.HRManager;
import domain.Invitation;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class HRManagerDaoFake implements DAO<HRManager> {

    private static ArrayList<HRManager> entities;

    public HRManagerDaoFake() {
        entities = new ArrayList<>();
    }

    @Override
    public List<HRManager> getAll() throws DAOException {
        return entities;
    }

    @Override
    public HRManager getBy(Predicate<HRManager> predicate) throws DAOException {

        for (HRManager entity : entities) {
            if (predicate.test(entity)) {
                return entity;
            }
        }

        return null;
    }

    @Override
    public void update(HRManager entity) throws DAOException {
        entities.remove(entity);
        entities.add(entity);
    }

    @Override
    public void delete(int id) throws DAOException {

        int i = -1, j = 0;
        for (HRManager entity : entities) {

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
    public void create(HRManager entity) throws DAOException {
        entities.add(entity);
    }

}
