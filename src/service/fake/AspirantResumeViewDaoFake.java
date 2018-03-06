package service.fake;

import dao.DAO;
import dao.exception.DAOException;
import domain.Resume;
import domain.ResumeView;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AspirantResumeViewDaoFake implements DAO<ResumeView> {

    private static ArrayList<ResumeView> resumeViews;

    public AspirantResumeViewDaoFake() {
        resumeViews = new ArrayList<>();
    }

    @Override
    public List<ResumeView> getAll() throws DAOException {
        return resumeViews;
    }

    @Override
    public ResumeView getBy(Predicate<ResumeView> predicate) throws DAOException {

        for (ResumeView resume : resumeViews) {
            if (predicate.test(resume)) {
                return resume;
            }
        }

        return null;
    }

    @Override
    public void update(ResumeView entity) throws DAOException {
        resumeViews.remove(entity);
        resumeViews.add(entity);
    }

    @Override
    public void delete(int id) throws DAOException {

        int i = -1, j = 0;
        for (ResumeView resume : resumeViews) {

            if (resume.getId() == id) {
                i = j;
            }

            j++;
        }

        if (i != -1) {
            resumeViews.remove(i);
        }

    }

    @Override
    public void create(ResumeView entity) throws DAOException {
        resumeViews.add(entity);
    }

}
