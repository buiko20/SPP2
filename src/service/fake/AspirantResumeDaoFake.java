package service.fake;

import dao.DAO;
import dao.exception.DAOException;
import domain.Resume;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AspirantResumeDaoFake implements DAO<Resume> {

    private static ArrayList<Resume> resumes;

    public AspirantResumeDaoFake() {
        resumes = new ArrayList<>();
    }

    @Override
    public List<Resume> getAll() throws DAOException {
        return resumes;
    }

    @Override
    public Resume getBy(Predicate<Resume> predicate) throws DAOException {

        for (Resume resume : resumes) {
            if (predicate.test(resume)) {
                return resume;
            }
        }

        return null;
    }

    @Override
    public void update(Resume entity) throws DAOException {
        resumes.remove(entity);
        resumes.add(entity);
    }

    @Override
    public void delete(int id) throws DAOException {

        int i = -1, j = 0;
        for (Resume resume : resumes) {

            if (resume.getId() == id) {
                i = j;
            }

            j++;
        }

        if (i != -1) {
            resumes.remove(i);
        }

    }

    @Override
    public void create(Resume entity) throws DAOException {
        resumes.add(entity);
    }

}
