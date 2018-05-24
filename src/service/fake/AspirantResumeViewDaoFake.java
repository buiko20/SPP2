package service.fake;

import dao.DAO;
import dao.exception.DAOException;
import domain.ResumeView;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AspirantResumeViewDaoFake implements DAO<ResumeView> {

    private static ArrayList<ResumeView> entities;

    public AspirantResumeViewDaoFake() {
        entities = new ArrayList<>();
    }

    @Override
    public List<ResumeView> getAll() throws DAOException {
        return entities;
    }

    @Override
    public ResumeView getBy(Predicate<ResumeView> predicate) throws DAOException {

        for (ResumeView entity : entities) {
            if (predicate.test(entity)) {
                return entity;
            }
        }

        return null;
    }

    @Override
    public void update(ResumeView entity) throws DAOException {
        entities.remove(entity);
        entities.add(entity);
    }

    @Override
    public void delete(int id) throws DAOException {

        int i = -1, j = 0;
        for (ResumeView entity : entities) {

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
    public void create(ResumeView entity) throws DAOException {
        entities.add(entity);
    }

}
