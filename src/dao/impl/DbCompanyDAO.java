package dao.impl;

import dao.DAO;
import dao.MysqlConnect;
import dao.exception.DAOException;
import domain.Company;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class DbCompanyDAO implements DAO<Company> {

    private MysqlConnect mysqlConnect = new MysqlConnect();

    public List<Company> getAll() throws DAOException {
        ArrayList<Company> companies = new ArrayList<>();
        try{
            Statement statement = mysqlConnect.connect().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Company");

            while(resultSet.next()){
                Company company = new Company(
                        resultSet.getInt("id"),
                        resultSet.getString("Name"),
                        resultSet.getString("Phone_number"),
                        resultSet.getString("Mailing_address"),
                        resultSet.getString("Email")
                );
                companies.add(company);
            }

            return companies;
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    public Company getBy(Predicate<Company> predicate) throws DAOException {
        try {
            Company result = null;
            List<Company> list = this.getAll();

            for (Company company: list) {
                if (predicate.test(company)) {
                    result = company;
                }
            }

            return result;
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        }
    }

    public void update(Company company) throws DAOException {
        try {
            Statement statement = mysqlConnect.connect().createStatement();
            statement.execute("UPDATE Company SET Name='" + company.getName() +
                    "', Phone_number='" + company.getPhoneNumber() +
                    "', Mailing_address='" + company.getMailingAddress() +
                    "', Email='" + company.getEmail() +
                    "' WHERE id=" + company.getId());
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    public void delete(int id) throws DAOException {
        try {
            Statement statement = mysqlConnect.connect().createStatement();
            statement.execute("DELETE FROM Company WHERE id=" + id);
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    public void create(Company company) throws DAOException {
        try {
            Statement statement = mysqlConnect.connect().createStatement();
            statement.executeUpdate("INSERT INTO Company (Name, Phone_number, Mailing_address, Email) " +
                    "VALUES ('" + company.getName() + "', '" + company.getPhoneNumber() + "', '" +
                    company.getMailingAddress() + "', '" + company.getEmail() + "')", Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = statement.getGeneratedKeys();
            int id = -1;
            if (rs != null && rs.next()) {
                id = rs.getInt(1);
            }
            company.setId(id);
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        } finally {
            mysqlConnect.disconnect();
        }
    }
}
