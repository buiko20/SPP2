package dao.impl;

import dao.DAO;
import dao.MysqlConnect;
import dao.exception.DAOException;
import domain.ResumeView;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class DbResumeViewDAO implements DAO<ResumeView> {

    private MysqlConnect mysqlConnect = new MysqlConnect();

    public List<ResumeView> getAll() throws DAOException {
        ArrayList<ResumeView> resumeViews = new ArrayList<>();
        try{
            Statement statement = mysqlConnect.connect().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM View");

            while(resultSet.next()){
                ResumeView resumeView = new ResumeView(
                        resultSet.getInt("id"),
                        resultSet.getDate("Date"),
                        resultSet.getInt("Resume_id"),
                        resultSet.getInt("Aspirant_id"),
                        resultSet.getInt("HR_manager_id"),
                        resultSet.getInt("Company_id")
                );
                resumeViews.add(resumeView);
            }

            return resumeViews;
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    public ResumeView getBy(Predicate<ResumeView> predicate) throws DAOException {
        try {
            ResumeView result = null;
            List<ResumeView> list = this.getAll();

            for (ResumeView resumeView: list) {
                if (predicate.test(resumeView)) {
                    result = resumeView;
                }
            }

            return result;
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        }
    }

    public void update(ResumeView resumeView) throws DAOException {
        try {
            Statement statement = mysqlConnect.connect().createStatement();
            statement.execute("UPDATE View SET Date='" + resumeView.getDate() +
                    "', Resume_id='" + resumeView.getResumeId() +
                    "', Aspirant_id='" + resumeView.getAspirantId() +
                    "', HR_manager_id='" + resumeView.getHrManagerId() +
                    "', Company_id='" + resumeView.getCompanyId() + "' WHERE id=" + resumeView.getId());
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    public void delete(int id) throws DAOException {
        try {
            Statement statement = mysqlConnect.connect().createStatement();
            statement.execute("DELETE FROM View WHERE id=" + id);
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    public void create(ResumeView resumeView) throws DAOException {
        try {
            Statement statement = mysqlConnect.connect().createStatement();
            statement.executeUpdate("INSERT INTO View (Date, Resume_id, Aspirant_id, HR_manager_id, " +
                    "Company_id) VALUES ('" + resumeView.getDate() + "', '" + resumeView.getResumeId() + "', '" +
                    resumeView.getAspirantId() + "', '" + resumeView.getHrManagerId() + "', '" +
                    resumeView.getCompanyId() + "')", Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = statement.getGeneratedKeys();
            int id = -1;
            if (rs != null && rs.next()) {
                id = rs.getInt(1);
            }
            resumeView.setId(id);
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        } finally {
            mysqlConnect.disconnect();
        }
    }
}
