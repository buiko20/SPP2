package service.fake;

import dao.DAO;
import dao.exception.DAOException;
import domain.Invitation;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class InvitationDaoFake implements DAO<Invitation> {

    private static ArrayList<Invitation> entities;

    public InvitationDaoFake() {
        entities = new ArrayList<>();
    }

    @Override
    public List<Invitation> getAll() throws DAOException {
        return entities;
    }

    @Override
    public Invitation getBy(Predicate<Invitation> predicate) throws DAOException {

        for (Invitation resume : entities) {
            if (predicate.test(resume)) {
                return resume;
            }
        }

        return null;
    }

    @Override
    public void update(Invitation entity) throws DAOException {
        entities.remove(entity);
        entities.add(entity);
    }

    @Override
    public void delete(int id) throws DAOException {

        int i = -1, j = 0;
        for (Invitation resume : entities) {

            if (resume.getId() == id) {
                i = j;
            }

            j++;
        }

        if (i != -1) {
            entities.remove(i);
        }

    }

    @Override
    public void create(Invitation entity) throws DAOException {
        entities.add(entity);
    }

}
