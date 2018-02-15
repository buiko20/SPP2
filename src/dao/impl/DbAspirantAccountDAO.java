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
        connection =  DriverManager.getConnection("jdbc:mysql://localhost/jobs_db?user=root&password=root");
    }

    public List<AspirantAccount> getAll() throws DAOException {
        ArrayList<AspirantAccount> aspirantAccounts = new ArrayList<>();
        try{
            setConnection();
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM Aspirant");

            while(resultSet.next()){
                AspirantAccount aspirantAccount = new AspirantAccount(
                        resultSet.getInt("id"),
                        resultSet.getString("Email"),
                        resultSet.getString("Password"),
                        null
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

    @Override
    public AspirantAccount getBy(Predicate<AspirantAccount> predicate) throws DAOException {
        return null;
    }

    public AspirantAccount getById(int id) throws DAOException {
        try{
            setConnection();
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT FROM Aspirant WHERE id=" + id);

            AspirantAccount aspirantAccount = null;
            if(resultSet.next()){
                aspirantAccount = new AspirantAccount(
                        resultSet.getInt("id"),
                        resultSet.getString("Email"),
                        resultSet.getString("Password"),
                        null
                );
            }

            connection.close();
            return aspirantAccount;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(AspirantAccount aspirantAccount) throws DAOException {
        try{
            setConnection();
            Statement statement = connection.createStatement();

            statement.execute("update Aspirant set Email='" +
                    aspirantAccount.getEmail() +
                    "', Password='" + aspirantAccount.getPassword() +
                    "' where id=" + aspirantAccount.getId());

            connection.close();
           // return true;
        } catch (Exception e) {
            e.printStackTrace();
            //return false;
        }
    }

    @Override
    public void delete(AspirantAccount entity) throws DAOException {

    }

    public void create(AspirantAccount aspirantAccount) throws DAOException {
        try {
            setConnection();
            Statement statement = connection.createStatement();

            statement.execute("INSERT INTO Aspirant (Email, Password, Aspirant_data_id)" +
                    "VALUES ('" + aspirantAccount.getEmail() + "', '" +
                    aspirantAccount.getPassword() + "', NULL)");

            connection.close();
         //   return true;
        }
        catch (Exception e) {
            e.printStackTrace();
         //   return false;
        }
    }


}
