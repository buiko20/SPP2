package dao.impl;

import dao.DAO;
import dao.exception.DAOException;
import domain.AspirantAccount;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class DbAspirantAccountDAO implements DAO<AspirantAccount>{

    private Connection connection = null;

    private void setConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection =  DriverManager.getConnection("jdbc:mysql://localhost:3307/jobs_db?user=root&password=root");
    }

    public List<AspirantAccount> getAll() throws DAOException {
        ArrayList<AspirantAccount> aspirantAccounts = new ArrayList<>();
        try {
            setConnection();
            Statement statement = connection.createStatement();

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

            connection.close();
            return aspirantAccounts;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
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
            e.printStackTrace();
            return null;
        }
    }

    public void update(AspirantAccount aspirantAccount) throws DAOException {
        try {
            setConnection();
            Statement statement = connection.createStatement();

            statement.execute("UPDATE Aspirant SET Email='" +
                    aspirantAccount.getEmail() +
                    "', Password='" + aspirantAccount.getPassword() +
                    "', Aspirant_data_id='" + aspirantAccount.getAspirantProfileId() +
                    "' WHERE id=" + aspirantAccount.getId());

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) throws DAOException {
        try {
            setConnection();

            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM Aspirant WHERE id=" + id);

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void create(AspirantAccount aspirantAccount) throws DAOException {
        try {
            setConnection();
            Statement statement = connection.createStatement();

            statement.executeUpdate("INSERT INTO Aspirant (Email, Password, Aspirant_data_id)" +
                    "VALUES ('" + aspirantAccount.getEmail() + "', '" +
                    aspirantAccount.getPassword() + "', NULL)", Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = statement.getGeneratedKeys();
            int id = -1;
            if (rs != null && rs.next()) {
                id = rs.getInt(1);
            }
            aspirantAccount.setId(id);

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
