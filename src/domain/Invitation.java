package domain;

import java.sql.Timestamp;

/**
 * Represents an invitation domain model.
 */
public class Invitation implements Comparable<Invitation> {

    private int id;
    private Timestamp date;
    private String address;
    private Resume resume;
    private AspirantAccount aspirantAccount;
    private JobVacancy jobVacancy;
    private HRManager hrManager;
    private Company company;

    /**
     * Initialize a new instance of the {@link Invitation model}
     * @param id invitation id
     */
    public Invitation(int id){
        this.id = id;
    }

    /**
     * Initialize a new instance of the {@link Invitation model}
     * @param id invitation id
     * @param date date of the interview for which the invitation was sent
     * @param address address of the interview for which the invitation was sent
     * @param resume resume the invitation was sent to
     * @param aspirantAccount aspirant account the invitation was sent to
     * @param jobVacancy job vacancy the invitation was sent to
     * @param hrManager HRManager who sent the invitation
     * @param company company which HRManager sent the invitation
     */
    public Invitation(int id, Timestamp date, String address, Resume resume, AspirantAccount aspirantAccount,
                      JobVacancy jobVacancy, HRManager hrManager, Company company) {
        this.id = id;
        this.date = date;
        this.address = address;
        this.resume = resume;
        this.aspirantAccount = aspirantAccount;
        this.jobVacancy = jobVacancy;
        this.hrManager = hrManager;
        this.company = company;
    }

    /**
     * Gets an invitation id
     * @return invitation id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets a date of the interview for which the invitation was sent
     * @return date of the interview for which the invitation was sent
     */
    public Timestamp getDate() {
        return date;
    }

    /**
     * Sets a date of the interview for which the invitation was sent
     * @param date date of the interview for which the invitation was sent
     */
    public void setDate(Timestamp date) {
        this.date = date;
    }

    /**
     * Gets an address of the interview for which the invitation was sent
     * @return address of the interview for which the invitation was sent
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets an address of the interview for which the invitation was sent
     * @param address address of the interview for which the invitation was sent
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets a resume the invitation was sent to
     * @return resume the invitation was sent to
     */
    public Resume getResume() {
        return resume;
    }

    /**
     * Sets a resume the invitation was sent to
     * @param resume resume the invitation was sent to
     */
    public void setResume(Resume resume) {
        this.resume = resume;
    }

    /**
     * Gets an aspirant account the invitation was sent to
     * @return aspirant account the invitation was sent to
     */
    public AspirantAccount getAspirantAccount() {
        return aspirantAccount;
    }

    /**
     * Sets an aspirant account the invitation was sent to
     * @param aspirantAccount aspirant account the invitation was sent to
     */
    public void setAspirantAccount(AspirantAccount aspirantAccount) {
        this.aspirantAccount = aspirantAccount;
    }

    /**
     * Gets a job vacancy the invitation was sent to
     * @return job vacancy the invitation was sent to
     */
    public JobVacancy getJobVacancy() {
        return jobVacancy;
    }

    /**
     * Sets a job vacancy the invitation was sent to
     * @param jobVacancy job vacancy the invitation was sent to
     */
    public void setJobVacancy(JobVacancy jobVacancy) {
        this.jobVacancy = jobVacancy;
    }

    /**
     * Gets an HRManager who sent the invitation
     * @return HRManager who sent the invitation
     */
    public HRManager getHrManager() {
        return hrManager;
    }

    /**
     * Sets an HRManager who sent the invitation
     * @param hrManager HRManager who sent the invitation
     */
    public void setHrManager(HRManager hrManager) {
        this.hrManager = hrManager;
    }

    /**
     * Gets a company which HRManager was sent the invitation
     * @return company which HRManager was sent the invitation
     */
    public Company getCompany() {
        return company;
    }

    /**
     * Sets a company which HRManager was sent the invitation
     * @param company company which HRManager was sent the invitation
     */
    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;

        Invitation invitation = (Invitation) obj;

        return this.getId() == invitation.getId();
    }

    @Override
    public int compareTo(Invitation obj) {
        if (obj == null) {
            throw new NullPointerException("Object is null");
        }

        return Integer.compare(this.getId(), obj.getId());
    }
}
