package dao.impl;

import dao.DAO;
import dao.MysqlConnect;
import dao.exception.DAOException;
import domain.Invitation;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class DbInvitationDAO implements DAO<Invitation> {

    private MysqlConnect mysqlConnect = new MysqlConnect();

    public List<Invitation> getAll() throws DAOException {
        ArrayList<Invitation> invitations = new ArrayList<>();
        try{
            Statement statement = mysqlConnect.connect().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Invitation");

            while(resultSet.next()){
                Invitation invitation = new Invitation(
                        resultSet.getInt("id"),
                        resultSet.getTimestamp("Date"),
                        resultSet.getString("Address"),
                        resultSet.getInt("Resume_id"),
                        resultSet.getInt("Aspirant_id"),
                        resultSet.getInt("Job_vacancy_id"),
                        resultSet.getInt("HR_manager_id"),
                        resultSet.getInt("Company_id")
                );
                invitations.add(invitation);
            }

            return invitations;
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    public Invitation getBy(Predicate<Invitation> predicate) throws DAOException {
        try {
            Invitation result = null;
            List<Invitation> list = this.getAll();

            for (Invitation invitation: list) {
                if (predicate.test(invitation)) {
                    result = invitation;
                }
            }

            return result;
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        }
    }

    public void update(Invitation invitation) throws DAOException {
        try {
            Statement statement = mysqlConnect.connect().createStatement();
            statement.execute("UPDATE Invitation SET Date='" + invitation.getDate() +
                    "', Address='" + invitation.getAddress() + "', Resume_id='" + invitation.getResumeId() +
                    "', Aspirant_id='" + invitation.getAspirantAccountId() +
                    "', Job_vacancy_id='" + invitation.getJobVacancyId() +
                    "', HR_manager_id='" + invitation.getHrManagerId() +
                    "', Company_id='" + invitation.getCompanyId() + "' WHERE id=" + invitation.getId());
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    public void delete(int id) throws DAOException {
        try {
            Statement statement = mysqlConnect.connect().createStatement();
            statement.execute("DELETE FROM Invitation WHERE id=" + id);
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    public void create(Invitation invitation) throws DAOException {
        try {
            Statement statement = mysqlConnect.connect().createStatement();
            statement.executeUpdate("INSERT INTO Invitation (Date, Address, Resume_id, Aspirant_id, " +
                    "Job_vacancy_id, HR_manager_id, Company_id) VALUES ('" + invitation.getDate() + "', '" +
                    invitation.getAddress() + "', '" + invitation.getResumeId() + "', '" +
                    invitation.getAspirantAccountId() + "', '" + invitation.getJobVacancyId() + "', '" +
                    invitation.getHrManagerId() + "', '" + invitation.getCompanyId() + "')",
                    Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = statement.getGeneratedKeys();
            int id = -1;
            if (rs != null && rs.next()) {
                id = rs.getInt(1);
            }
            invitation.setId(id);
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        } finally {
            mysqlConnect.disconnect();
        }
    }
}
