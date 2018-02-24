package dao.impl;

import dao.DAO;
import dao.MysqlConnect;
import dao.exception.DAOException;
import domain.AspirantProfile;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class DbAspirantProfileDAO implements DAO<AspirantProfile> {

    private MysqlConnect mysqlConnect = new MysqlConnect();

    public List<AspirantProfile> getAll() throws DAOException {
        ArrayList<AspirantProfile> aspirantProfiles = new ArrayList<>();
        try{
            Statement statement = mysqlConnect.connect().createStatement();
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

            return aspirantProfiles;
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        } finally {
            mysqlConnect.disconnect();
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
            throw new DAOException(e.getMessage(), e);
        }
    }

    public void update(AspirantProfile aspirantProfile) throws DAOException {
        try {
            Statement statement = mysqlConnect.connect().createStatement();
            statement.execute("UPDATE Aspirant_data SET Surname='" + aspirantProfile.getSurname() +
                    "', Name='" + aspirantProfile.getName() + "', Patronymic='" + aspirantProfile.getPatronymic() +
                    "', Sex='" + aspirantProfile.getSex() + "', Education='" + aspirantProfile.getEducation() +
                    "', Date_of_birth='" + aspirantProfile.getDateOfBirth() +
                    "', Phone_number='" + aspirantProfile.getPhoneNumber() +
                    "', English_level='" + aspirantProfile.getEnglishLevel() +
                    "', About_me='" + aspirantProfile.getAboutMe() +
                    "', City_of_residence='" + aspirantProfile.getCityOfResidence() +
                    "', Mailing_address='" + aspirantProfile.getMailingAddress() +
                    "' WHERE id=" + aspirantProfile.getId());
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    public void delete(int id) throws DAOException {
        try {
            Statement statement = mysqlConnect.connect().createStatement();
            statement.execute("DELETE FROM Aspirant_data WHERE id=" + id);
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    public void create(AspirantProfile aspirantProfile) throws DAOException {
        try {
            Statement statement = mysqlConnect.connect().createStatement();
            statement.executeUpdate("INSERT INTO Aspirant_data (Surname, Name, Patronymic, Sex, Education, " +
                    "Date_of_birth, Phone_number, English_level, About_me, City_of_residence, Mailing_address)" +
                    "VALUES ('" + aspirantProfile.getSurname() + "', '" + aspirantProfile.getName() + "', '" +
                    aspirantProfile.getPatronymic() + "', '" + aspirantProfile.getSex() + "', '" +
                    aspirantProfile.getEducation() + "', '" + aspirantProfile.getDateOfBirth() + "', '" +
                    aspirantProfile.getPhoneNumber() + "', '" + aspirantProfile.getEnglishLevel() + "', '" +
                    aspirantProfile.getAboutMe() + "', '" + aspirantProfile.getCityOfResidence() + "', '" +
                    aspirantProfile.getMailingAddress() + "')", Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = statement.getGeneratedKeys();
            int id = -1;
            if (rs != null && rs.next()) {
                id = rs.getInt(1);
            }
            aspirantProfile.setId(id);
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        } finally {
            mysqlConnect.disconnect();
        }
    }
}
