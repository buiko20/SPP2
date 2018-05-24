package dao.impl;

import dao.DAO;
import dao.MysqlConnect;
import dao.exception.DAOException;
import domain.AspirantAccount;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class DbAspirantAccountDAO implements DAO<AspirantAccount> {

    private MysqlConnect mysqlConnect = new MysqlConnect();

    public List<AspirantAccount> getAll() throws DAOException {
        ArrayList<AspirantAccount> aspirantAccounts = new ArrayList<>();
        try {
            Statement statement = mysqlConnect.connect().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Aspirant");

            while(resultSet.next()){
                AspirantAccount aspirantAccount = new AspirantAccount(
                        resultSet.getInt("id"),
                        resultSet.getString("Email"),
                        resultSet.getString("Password"),
                        resultSet.getInt("Aspirant_data_id")
                );
                aspirantAccounts.add(aspirantAccount);
            }

            return aspirantAccounts;
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    public AspirantAccount getBy(Predicate<AspirantAccount> predicate) throws DAOException {
        try {
            AspirantAccount result = null;
            List<AspirantAccount> list = this.getAll();

            for (AspirantAccount aspirantAccount: list) {
                if (predicate.test(aspirantAccount)) {
                    result = aspirantAccount;
                }
            }

            return result;
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        }
    }

    public void update(AspirantAccount aspirantAccount) throws DAOException {
        try {
            Statement statement = mysqlConnect.connect().createStatement();
            statement.execute("UPDATE Aspirant SET Email='" +
                    aspirantAccount.getEmail() +
                    "', Password='" + aspirantAccount.getPassword() +
                    "', Aspirant_data_id='" + aspirantAccount.getAspirantProfileId() +
                    "' WHERE id=" + aspirantAccount.getId());
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    public void delete(int id) throws DAOException {
        try {
            Statement statement = mysqlConnect.connect().createStatement();
            statement.execute("DELETE FROM Aspirant WHERE id=" + id);
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    public void create(AspirantAccount aspirantAccount) throws DAOException {
        try {
            Statement statement = mysqlConnect.connect().createStatement();
            statement.executeUpdate("INSERT INTO Aspirant (Email, Password, Aspirant_data_id)" +
                    "VALUES ('" + aspirantAccount.getEmail() + "', '" +
                    aspirantAccount.getPassword() + "', NULL)", Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = statement.getGeneratedKeys();
            int id = -1;
            if (rs != null && rs.next()) {
                id = rs.getInt(1);
            }
            aspirantAccount.setId(id);
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        } finally {
            mysqlConnect.disconnect();
        }
    }
}
