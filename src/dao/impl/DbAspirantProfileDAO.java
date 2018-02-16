package dao.impl;

import dao.exception.DAOException;
import domain.AspirantProfile;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class DbAspirantProfileDAO {

    private Connection connection = null;

    private void setConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection =  DriverManager.getConnection("jdbc:mysql://localhost/jobs_db?user=root&password=root");
    }

    public List<AspirantProfile> getAll() throws DAOException {
        ArrayList<AspirantProfile> aspirantProfiles = new ArrayList<>();
        try{
            setConnection();
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM Aspirant_data");

            while(resultSet.next()){
                AspirantProfile aspirantProfile = new AspirantProfile(
                        resultSet.getInt("id"),
                        resultSet.getString("Name"),
                        resultSet.getString("Surname"),
                        resultSet.getString("Patronymic"),
                        resultSet.getString("Sex"),
                        resultSet.getString("Education"),
                        resultSet.getDate("Date_of_birth"),
                        resultSet.getString("Phone_number"),
                        resultSet.getString("Mailing_address"),
                        resultSet.getString("English_level"),
                        resultSet.getString("About_me"),
                        resultSet.getString("City_of_residence")
                );
                aspirantProfiles.add(aspirantProfile);
            }

            connection.close();
            return aspirantProfiles;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public AspirantProfile getBy(Predicate<AspirantProfile> predicate) throws DAOException {
        try {
            AspirantProfile result = null;
            List<AspirantProfile> list = this.getAll();

            for (AspirantProfile aspirantProfile: list) {
                if (predicate.test(aspirantProfile)) {
                    result = aspirantProfile;
                }
            }

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(AspirantProfile aspirantProfile) throws DAOException {

    }

    public void delete(int id) throws DAOException {
        try {
            setConnection();

            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM Aspirant_data WHERE id=" + id);

            connection.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void create(AspirantProfile aspirantProfile) throws DAOException {
        try {
            setConnection();
            Statement statement = connection.createStatement();

            statement.executeUpdate("INSERT INTO Aspirant (Surname, Name, Patronymic, Sex, Education, Date_of_birth, " +
                    "Phone_number, English_level, About_me, City_of_residence, Mailing_address)" +
                    "VALUES ('" + aspirantProfile.getSurname() + "', '" + aspirantProfile.getName() + "', '" +
                    aspirantProfile.getPatronymic() + "', '" + aspirantProfile.getSex() +
                    aspirantProfile.getEducation() + aspirantProfile.getDateOfBirth() +
                    aspirantProfile.getPhoneNumber() + aspirantProfile.getEnglishLevel() + aspirantProfile.getAboutMe() +
                    aspirantProfile.getCityOfResidence() + aspirantProfile.getMailingAddress() + "')", Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = statement.getGeneratedKeys();
            int id = -1;
            if (rs != null && rs.next()) {
                id = rs.getInt(1);
            }
            aspirantProfile.setId(id);

            connection.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
