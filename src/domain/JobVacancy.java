package domain;

import java.util.Date;

/**
 * Represents a job vacancy domain model.
 */
public class JobVacancy implements Comparable<JobVacancy> {

    private int id;
    private String name;
    private Date date;
    private String description;
    private String status;
    private String address;
    private int hrManagerId;
    private int companyId;

    public JobVacancy() {
    }

    /**
     * Initializes a new instance of the {@link JobVacancy model}
     * @param name job vacancy name
     * @param date date of the job vacancy update
     * @param description job vacancy description
     * @param status job vacancy status
     * @param address address of possible job
     * @param hrManagerId id of the HRManager to which the vacancy refers
     * @param companyId id of the company to which the vacancy refers
     */
    public JobVacancy(String name, Date date, String description, String status, String address, int hrManagerId,
                      int companyId) {
        this.name = name;
        this.date = date;
        this.description = description;
        this.status = status;
        this.address = address;
        this.hrManagerId = hrManagerId;
        this.companyId = companyId;
    }

    /**
     * Initializes a new instance of the {@link JobVacancy model}
     * @param id job vacancy id
     * @param name job vacancy name
     * @param date date of the job vacancy update
     * @param description job vacancy description
     * @param status job vacancy status
     * @param address address of possible job
     * @param hrManagerId id of the HRManager to which the vacancy refers
     * @param companyId id of the company to which the vacancy refers
     */
    public JobVacancy(int id, String name, Date date, String description, String status, String address,
                      int hrManagerId, int companyId) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.description = description;
        this.status = status;
        this.address = address;
        this.hrManagerId = hrManagerId;
        this.companyId = companyId;
    }

    /**
     * Gets a job vacancy id
     * @return job vacancy id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets a job vacancy id
     * @param id job vacancy id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets a job vacancy name
     * @return job vacancy name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets a job vacancy name
     * @param name job vacancy name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets a date of the job vacancy update
     * @return date of the job vacancy update
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets a date of the job vacancy update
     * @param date date of the job vacancy update
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets a job vacancy description
     * @return job vacancy description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets a job vacancy description
     * @param description job vacancy description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets a job vacancy status
     * @return job vacancy status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets a job vacancy status
     * @param status job vacancy status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets a address of possible job
     * @return address of possible job
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets a address of possible job
     * @param address address of possible job
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets id of the HRManager to which the vacancy refers
     * @return id of the HRManager to which the vacancy refers
     */
    public int getHrManagerId() {
        return hrManagerId;
    }

    /**
     * Sets id of the HRManager to which the vacancy refers
     * @param hrManagerId id of the HRManager to which the vacancy refers
     */
    public void setHrManagerId(int hrManagerId) {
        this.hrManagerId = hrManagerId;
    }

    /**
     * Gets id of the company to which the vacancy refers
     * @return id of the company to which the vacancy refers
     */
    public int getCompanyId() {
        return companyId;
    }

    /**
     * Sets id of the company to which the vacancy refers
     * @param companyId id of the company to which the vacancy refers
     */
    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Override
    public int compareTo(JobVacancy obj) {
        if (obj == null) {
            throw new NullPointerException("Object is null");
        }

        return Integer.compare(this.getId(), obj.getId());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;

        JobVacancy jobVacancy = (JobVacancy)obj;

        return this.getId() == jobVacancy.getId();
    }
}
