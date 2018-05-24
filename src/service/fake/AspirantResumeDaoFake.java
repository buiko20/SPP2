package service.fake;

import dao.DAO;
import dao.exception.DAOException;
import domain.Resume;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AspirantResumeDaoFake implements DAO<Resume> {

    private static ArrayList<Resume> entities;

    public AspirantResumeDaoFake() {
        entities = new ArrayList<>();
    }

    @Override
    public List<Resume> getAll() throws DAOException {
        return entities;
    }

    @Override
    public Resume getBy(Predicate<Resume> predicate) throws DAOException {

        for (Resume entity : entities) {
            if (predicate.test(entity)) {
                return entity;
            }
        }

        return null;
    }

    @Override
    public void update(Resume entity) throws DAOException {
        entities.remove(entity);
        entities.add(entity);
    }

    @Override
    public void delete(int id) throws DAOException {

        int i = -1, j = 0;
        for (Resume entity : entities) {

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
    public void create(Resume entity) throws DAOException {
        entities.add(entity);
    }

}
