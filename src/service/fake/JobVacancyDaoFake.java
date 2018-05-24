package service.fake;

import dao.DAO;
import dao.exception.DAOException;
import domain.JobVacancy;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class JobVacancyDaoFake implements DAO<JobVacancy> {

    private static ArrayList<JobVacancy> entities;

    public JobVacancyDaoFake() {
        entities = new ArrayList<>();
    }

    @Override
    public List<JobVacancy> getAll() throws DAOException {
        return entities;
    }

    @Override
    public JobVacancy getBy(Predicate<JobVacancy> predicate) throws DAOException {

        for (JobVacancy entity : entities) {
            if (predicate.test(entity)) {
                return entity;
            }
        }

        return null;
    }

    @Override
    public void update(JobVacancy entity) throws DAOException {
        entities.remove(entity);
        entities.add(entity);
    }

    @Override
    public void delete(int id) throws DAOException {

        int i = -1, j = 0;
        for (JobVacancy entity : entities) {

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
    public void create(JobVacancy entity) throws DAOException {
        entities.add(entity);
    }

}
