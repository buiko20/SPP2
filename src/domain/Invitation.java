package domain;

import java.sql.Timestamp;

/**
 * Represents an invitation domain model.
 */
public class Invitation implements Comparable<Invitation> {

    private int id;
    private Timestamp date;
    private String address;
    private int resumeId;
    private int aspirantAccountId;
    private int jobVacancyId;
    private int hrManagerId;
    private int companyId;

    public Invitation() {
    }

    /**
     * Initialize a new instance of the {@link Invitation model}
     * @param date date of the interview for which the invitation was sent
     * @param address address of the interview for which the invitation was sent
     * @param resumeId id of the resume the invitation was sent to
     * @param aspirantAccountId id of the aspirant account the invitation was sent to
     * @param jobVacancyId id of the job vacancy the invitation was sent to
     * @param hrManagerId id of the HRManager who sent the invitation
     * @param companyId id of the company which HRManager sent the invitation
     */
    public Invitation(Timestamp date, String address, int resumeId, int aspirantAccountId, int jobVacancyId,
                      int hrManagerId, int companyId) {
        this.date = date;
        this.address = address;
        this.resumeId = resumeId;
        this.aspirantAccountId = aspirantAccountId;
        this.jobVacancyId = jobVacancyId;
        this.hrManagerId = hrManagerId;
        this.companyId = companyId;
    }

    /**
     * Initialize a new instance of the {@link Invitation model}
     * @param id invitation id
     * @param date date of the interview for which the invitation was sent
     * @param address address of the interview for which the invitation was sent
     * @param resumeId id of the resume the invitation was sent to
     * @param aspirantAccountId id of the aspirant account the invitation was sent to
     * @param jobVacancyId id of the job vacancy the invitation was sent to
     * @param hrManagerId id of the HRManager who sent the invitation
     * @param companyId id of the company which HRManager sent the invitation
     */
    public Invitation(int id, Timestamp date, String address, int resumeId, int aspirantAccountId, int jobVacancyId,
                      int hrManagerId, int companyId) {
        this.id = id;
        this.date = date;
        this.address = address;
        this.resumeId = resumeId;
        this.aspirantAccountId = aspirantAccountId;
        this.jobVacancyId = jobVacancyId;
        this.hrManagerId = hrManagerId;
        this.companyId = companyId;
    }

    /**
     * Gets an invitation id
     * @return invitation id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets an invitation id
     * @param id invitation id
     */
    public void setId(int id) {
        this.id = id;
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
     * Gets id of the resume the invitation was sent to
     * @return id of the resume the invitation was sent to
     */
    public int getResumeId() {
        return resumeId;
    }

    /**
     * Sets id of the resume the invitation was sent to
     * @param resumeId id of the resume the invitation was sent to
     */
    public void setResumeId(int resumeId) {
        this.resumeId = resumeId;
    }

    /**
     * Gets id of the aspirant account the invitation was sent to
     * @return id of the aspirant account the invitation was sent to
     */
    public int getAspirantAccountId() {
        return aspirantAccountId;
    }

    /**
     * Sets id of the aspirant account the invitation was sent to
     * @param aspirantAccountId id of the aspirant account the invitation was sent to
     */
    public void setAspirantAccountId(int aspirantAccountId) {
        this.aspirantAccountId = aspirantAccountId;
    }

    /**
     * Gets id of the job vacancy the invitation was sent to
     * @return id of the job vacancy the invitation was sent to
     */
    public int getJobVacancyId() {
        return jobVacancyId;
    }

    /**
     * Sets id of the job vacancy the invitation was sent to
     * @param jobVacancyId id of the job vacancy the invitation was sent to
     */
    public void setJobVacancyId(int jobVacancyId) {
        this.jobVacancyId = jobVacancyId;
    }

    /**
     * Gets id of the HRManager who sent the invitation
     * @return id of the HRManager who sent the invitation
     */
    public int getHrManagerId() {
        return hrManagerId;
    }

    /**
     * Sets id of the HRManager who sent the invitation
     * @param hrManagerId id of the HRManager who sent the invitation
     */
    public void setHrManagerId(int hrManagerId) {
        this.hrManagerId = hrManagerId;
    }

    /**
     * Gets id of the company which HRManager was sent the invitation
     * @return id of the company which HRManager was sent the invitation
     */
    public int getCompanyId() {
        return companyId;
    }

    /**
     * Sets id of the company which HRManager was sent the invitation
     * @param companyId id of the company which HRManager was sent the invitation
     */
    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;

        Invitation invitation = (Invitation)obj;

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
