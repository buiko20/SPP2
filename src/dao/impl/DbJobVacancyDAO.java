package dao.impl;

import dao.DAO;
import dao.MysqlConnect;
import dao.exception.DAOException;
import domain.JobVacancy;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class DbJobVacancyDAO implements DAO<JobVacancy> {

    private MysqlConnect mysqlConnect = new MysqlConnect();

    public List<JobVacancy> getAll() throws DAOException {
        ArrayList<JobVacancy> jobVacancies = new ArrayList<>();
        try{
            Statement statement = mysqlConnect.connect().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Job_vacancy");

            while(resultSet.next()){
                JobVacancy jobVacancy = new JobVacancy(
                        resultSet.getInt("id"),
                        resultSet.getString("Name"),
                        resultSet.getTimestamp("Date"),
                        resultSet.getString("Description"),
                        resultSet.getString("Status"),
                        resultSet.getString("Address"),
                        resultSet.getInt("HR_manager_id"),
                        resultSet.getInt("Company_id")
                );
                jobVacancies.add(jobVacancy);
            }

            return jobVacancies;
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    public JobVacancy getBy(Predicate<JobVacancy> predicate) throws DAOException {
        try {
            JobVacancy result = null;
            List<JobVacancy> list = this.getAll();

            for (JobVacancy jobVacancy: list) {
                if (predicate.test(jobVacancy)) {
                    result = jobVacancy;
                }
            }

            return result;
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        }
    }

    public void update(JobVacancy jobVacancy) throws DAOException {
        try {
            Statement statement = mysqlConnect.connect().createStatement();
            statement.execute("UPDATE Job_vacancy SET Name='" + jobVacancy.getName() +
                    "', Date='" + jobVacancy.getDate() + "', Description='" + jobVacancy.getDescription() +
                    "', Status='" + jobVacancy.getStatus() +
                    "', Address='" + jobVacancy.getAddress() +
                    "', HR_manager_id='" + jobVacancy.getHrManagerId() +
                    "', Company_id='" + jobVacancy.getCompanyId() + "' WHERE id=" + jobVacancy.getId());
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    public void delete(int id) throws DAOException {
        try {
            Statement statement = mysqlConnect.connect().createStatement();
            statement.execute("DELETE FROM Job_vacancy WHERE id=" + id);
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    public void create(JobVacancy jobVacancy) throws DAOException {
        try {
            Statement statement = mysqlConnect.connect().createStatement();
            statement.executeUpdate("INSERT INTO Job_vacancy (Name, Date, Description, Status, " +
                    "Address, HR_manager_id, Company_id) VALUES ('" + jobVacancy.getName() + "', '" +
                    jobVacancy.getDate() + "', '" + jobVacancy.getDescription() + "', '" +
                    jobVacancy.getStatus() + "', '" + jobVacancy.getAddress() + "', '" +
                    jobVacancy.getHrManagerId() + "', '" + jobVacancy.getCompanyId() + "')",
                    Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = statement.getGeneratedKeys();
            int id = -1;
            if (rs != null && rs.next()) {
                id = rs.getInt(1);
            }
            jobVacancy.setId(id);
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        } finally {
            mysqlConnect.disconnect();
        }
    }
}
