package dao.impl;

import dao.DAO;
import dao.MysqlConnect;
import dao.exception.DAOException;
import domain.HRManager;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class DbHRManagerDAO implements DAO<HRManager> {

    private MysqlConnect mysqlConnect = new MysqlConnect();

    public List<HRManager> getAll() throws DAOException {
        ArrayList<HRManager> hrManagers = new ArrayList<>();
        try{
            Statement statement = mysqlConnect.connect().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Hr_manager");

            while(resultSet.next()){
                HRManager hrManager = new HRManager(
                        resultSet.getInt("id"),
                        resultSet.getString("Email"),
                        resultSet.getString("Password"),
                        resultSet.getString("Surname"),
                        resultSet.getString("Name"),
                        resultSet.getString("Phone_number"),
                        resultSet.getInt("Company_id")
                );
                hrManagers.add(hrManager);
            }

            return hrManagers;
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    public HRManager getBy(Predicate<HRManager> predicate) throws DAOException {
        try {
            HRManager result = null;
            List<HRManager> list = this.getAll();

            for (HRManager hrManager: list) {
                if (predicate.test(hrManager)) {
                    result = hrManager;
                }
            }

            return result;
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        }
    }

    public void update(HRManager hrManager) throws DAOException {
        try {
            Statement statement = mysqlConnect.connect().createStatement();
            statement.execute("UPDATE Hr_manager SET Email='" + hrManager.getEmail() +
                    "', Password='" + hrManager.getPassword() + "', Surname='" + hrManager.getSurname() +
                    "', Name='" + hrManager.getName() + "', Phone_number='" + hrManager.getPhoneNumber() +
                    "', Company_id='" + hrManager.getCompanyId() + "' WHERE id=" + hrManager.getId());
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    public void delete(int id) throws DAOException {
        try {
            Statement statement = mysqlConnect.connect().createStatement();
            statement.execute("DELETE FROM Hr_manager WHERE id=" + id);
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    public void create(HRManager hrManager) throws DAOException {
        try {
            Statement statement = mysqlConnect.connect().createStatement();
            statement.executeUpdate("INSERT INTO Hr_manager (Email, Password, Surname, Name, Phone_number, " +
                    "Company_id) VALUES ('" + hrManager.getEmail() + "', '" + hrManager.getPassword() + "', '" +
                    hrManager.getSurname() + "', '" + hrManager.getName() + "', '" +
                    hrManager.getPhoneNumber() + "', '" + hrManager.getCompanyId() + "')",
                    Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = statement.getGeneratedKeys();
            int id = -1;
            if (rs != null && rs.next()) {
                id = rs.getInt(1);
            }
            hrManager.setId(id);
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        } finally {
            mysqlConnect.disconnect();
        }
    }
}
