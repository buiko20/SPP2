package service.fake;

import dao.DAO;
import dao.exception.DAOException;
import domain.Company;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CompanyDaoFake implements DAO<Company> {

    private static ArrayList<Company> entities;

    public CompanyDaoFake() {
        entities = new ArrayList<>();
    }

    @Override
    public List<Company> getAll() throws DAOException {
        return entities;
    }

    @Override
    public Company getBy(Predicate<Company> predicate) throws DAOException {

        for (Company resume : entities) {
            if (predicate.test(resume)) {
                return resume;
            }
        }

        return null;
    }

    @Override
    public void update(Company entity) throws DAOException {
        entities.remove(entity);
        entities.add(entity);
    }

    @Override
    public void delete(int id) throws DAOException {

        int i = -1, j = 0;
        for (Company resume : entities) {

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
    public void create(Company entity) throws DAOException {
        entities.add(entity);
    }

}
