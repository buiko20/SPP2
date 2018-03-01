package dao.impl;

import dao.DAO;
import dao.MysqlConnect;
import dao.exception.DAOException;
import domain.AspirantResponse;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class DbAspirantResponseDAO implements DAO<AspirantResponse> {

    private MysqlConnect mysqlConnect = new MysqlConnect();

    public List<AspirantResponse> getAll() throws DAOException {
        ArrayList<AspirantResponse> aspirantResponses = new ArrayList<>();
        try{
            Statement statement = mysqlConnect.connect().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Response");

            while(resultSet.next()){
                AspirantResponse aspirantResponse = new AspirantResponse(
                        resultSet.getInt("id"),
                        resultSet.getDate("Date"),
                        resultSet.getString("Covering_letter"),
                        resultSet.getInt("Aspirant_id"),
                        resultSet.getInt("Job_vacancy_id"),
                        resultSet.getInt("HR_manager_id"),
                        resultSet.getInt("Company_id")
                );
                aspirantResponses.add(aspirantResponse);
            }

            return aspirantResponses;
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    public AspirantResponse getBy(Predicate<AspirantResponse> predicate) throws DAOException {
        try {
            AspirantResponse result = null;
            List<AspirantResponse> list = this.getAll();

            for (AspirantResponse aspirantResponse: list) {
                if (predicate.test(aspirantResponse)) {
                    result = aspirantResponse;
                }
            }

            return result;
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        }
    }

    public void update(AspirantResponse aspirantResponse) throws DAOException {
        try {
            Statement statement = mysqlConnect.connect().createStatement();
            statement.execute("UPDATE Response SET Date='" + aspirantResponse.getDate() +
                    "', Covering_letter='" + aspirantResponse.getCoveringLetter() +
                    "', Aspirant_id='" + aspirantResponse.getAspirantId() +
                    "', Job_vacancy_id='" + aspirantResponse.getJobVacancyId() +
                    "', HR_manager_id='" + aspirantResponse.getHrManagerId() +
                    "', Company_id='" + aspirantResponse.getCompanyId() +
                    "' WHERE id=" + aspirantResponse.getId());
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    public void delete(int id) throws DAOException {
        try {
            Statement statement = mysqlConnect.connect().createStatement();
            statement.execute("DELETE FROM Response WHERE id=" + id);
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    public void create(AspirantResponse aspirantResponse) throws DAOException {
        try {
            Statement statement = mysqlConnect.connect().createStatement();
            statement.executeUpdate("INSERT INTO Response (Date, Covering_letter, Aspirant_id, Job_vacancy_id, " +
                    "HR_manager_id, Company_id) VALUES ('" + aspirantResponse.getDate() + "', '" +
                    aspirantResponse.getCoveringLetter() + "', '" +  aspirantResponse.getAspirantId() + "', '" +
                    aspirantResponse.getJobVacancyId() + "', '" + aspirantResponse.getHrManagerId() + "', '" +
                    aspirantResponse.getCompanyId() + "')", Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = statement.getGeneratedKeys();
            int id = -1;
            if (rs != null && rs.next()) {
                id = rs.getInt(1);
            }
            aspirantResponse.setId(id);
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        } finally {
            mysqlConnect.disconnect();
        }
    }
}
