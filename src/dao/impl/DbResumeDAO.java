package dao.impl;

import dao.DAO;
import dao.MysqlConnect;
import dao.exception.DAOException;
import domain.Resume;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class DbResumeDAO implements DAO<Resume> {

    private MysqlConnect mysqlConnect = new MysqlConnect();

    public List<Resume> getAll() throws DAOException {
        ArrayList<Resume> resumes = new ArrayList<>();
        try{
            Statement statement = mysqlConnect.connect().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Resume");

            while(resultSet.next()){
                Boolean isTripPossible = resultSet.getInt("Business_trip") != 0;
                Boolean isRelocationPossible = resultSet.getInt("Relocation") != 0;
                Resume resume = new Resume(
                        resultSet.getInt("id"),
                        resultSet.getDate("Date"),
                        resultSet.getString("Career_objective"),
                        isTripPossible,
                        isRelocationPossible,
                        resultSet.getString("Skills"),
                        resultSet.getFloat("Salary"),
                        resultSet.getInt("Number_of_view"),
                        resultSet.getInt("Aspirant_id")
                );
                resumes.add(resume);
            }

            return resumes;
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    public Resume getBy(Predicate<Resume> predicate) throws DAOException {
        try {
            Resume result = null;
            List<Resume> list = this.getAll();

            for (Resume resume: list) {
                if (predicate.test(resume)) {
                    result = resume;
                }
            }

            return result;
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        }
    }

    public void update(Resume resume) throws DAOException {
        int isTripPossible = resume.getTripPossible() ? 1 : 0;
        int isRelocationPossible = resume.getRelocationPossible() ? 1 : 0;
        try {
            Statement statement = mysqlConnect.connect().createStatement();
            statement.execute("UPDATE Resume SET Date='" + resume.getDate() +
                    "', Career_objective='" + resume.getCareerObjective() +
                    "', Business_trip='" + isTripPossible +
                    "', Relocation='" + isRelocationPossible +
                    "', Skills='" + resume.getSkills() + "', Salary='" + resume.getSalary() +
                    "', Number_of_view='" + resume.getNumberOfViews() +
                    "', Aspirant_id='" + resume.getAspirantId() + "' WHERE id=" + resume.getId());
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    public void delete(int id) throws DAOException {
        try {
            Statement statement = mysqlConnect.connect().createStatement();
            statement.execute("DELETE FROM Resume WHERE id=" + id);
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    public void create(Resume resume) throws DAOException {
        int isTripPossible = resume.getTripPossible() ? 1 : 0;
        int isRelocationPossible = resume.getRelocationPossible() ? 1 : 0;
        try {
            Statement statement = mysqlConnect.connect().createStatement();
            statement.executeUpdate("INSERT INTO Resume (Date, Career_objective, Business_trip, Relocation, " +
                    "Skills, Salary, Number_of_view, Aspirant_id) VALUES ('" + resume.getDate() + "', '" +
                    resume.getCareerObjective() + "', '" + isTripPossible + "', '" +
                    isRelocationPossible + "', '" + resume.getSkills() + "', '" +
                    resume.getSalary() + "', '" + resume.getNumberOfViews() + "', '" +
                    resume.getAspirantId() + "')", Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = statement.getGeneratedKeys();
            int id = -1;
            if (rs != null && rs.next()) {
                id = rs.getInt(1);
            }
            resume.setId(id);
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        } finally {
            mysqlConnect.disconnect();
        }
    }
}
