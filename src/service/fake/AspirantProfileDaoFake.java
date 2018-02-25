package service.fake;

import dao.DAO;
import dao.exception.DAOException;
import domain.AspirantAccount;
import domain.AspirantProfile;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AspirantProfileDaoFake implements DAO<AspirantProfile> {

    private static ArrayList<AspirantProfile> aspirantProfiles;

    public AspirantProfileDaoFake() {
        aspirantProfiles = new ArrayList<>();
    }

    @Override
    public List<AspirantProfile> getAll() throws DAOException {
        return aspirantProfiles;
    }

    @Override
    public AspirantProfile getBy(Predicate<AspirantProfile> predicate) throws DAOException {

        for (AspirantProfile aspirantProfile : aspirantProfiles) {
            if (predicate.test(aspirantProfile)) {
                return aspirantProfile;
            }
        }

        return null;
    }

    @Override
    public void update(AspirantProfile entity) throws DAOException {
        aspirantProfiles.remove(entity);
        aspirantProfiles.add(entity);
    }

    @Override
    public void delete(int id) throws DAOException {

        int i = -1, j = 0;
        for (AspirantProfile aspirantProfile : aspirantProfiles) {

            if (aspirantProfile.getId() == id) {
                i = j;
            }

            j++;
        }

        if (i != -1) {
            aspirantProfiles.remove(i);
        }

    }

    @Override
    public void create(AspirantProfile entity) throws DAOException {
        aspirantProfiles.add(entity);
    }

}
