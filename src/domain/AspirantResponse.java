package domain;

import java.util.Date;

/**
 * Represents an aspirant response domain model.
 */
public class AspirantResponse implements Comparable<AspirantResponse> {

    private int id;
    private Date date;
    private String coveringLetter;
    private int aspirantId;
    private int jobVacancyId;
    private int hrManagerId;
    private int companyId;

    /**
     * Initializes a new instance of the {@link AspirantResponse model}
     * @param date response date
     * @param coveringLetter the cover letter to the response
     * @param aspirantId aspirant account id
     * @param jobVacancyId id of the vacancy to which the response is left
     * @param hrManagerId id of the hr manager to which the vacancy refers
     * @param companyId id of the company to which the vacancy refers
     */
    public AspirantResponse(Date date, String coveringLetter, int aspirantId, int jobVacancyId, int hrManagerId,
                            int companyId) {
        this.date = date;
        this.coveringLetter = coveringLetter;
        this.aspirantId = aspirantId;
        this.jobVacancyId = jobVacancyId;
        this.hrManagerId = hrManagerId;
        this.companyId = companyId;
    }

    /**
     * Initializes a new instance of the {@link AspirantResponse model}
     * @param id aspirant response id
     * @param date response date
     * @param coveringLetter the cover letter to the response
     * @param aspirantId aspirant account id
     * @param jobVacancyId id of the vacancy to which the response is left
     * @param hrManagerId id of the hr manager to which the vacancy refers
     * @param companyId id of the company to which the vacancy refers
     */
    public AspirantResponse(int id, Date date, String coveringLetter, int aspirantId, int jobVacancyId, int hrManagerId,
                            int companyId) {
        this.id = id;
        this.date = date;
        this.coveringLetter = coveringLetter;
        this.aspirantId = aspirantId;
        this.jobVacancyId = jobVacancyId;
        this.hrManagerId = hrManagerId;
        this.companyId = companyId;
    }

    /**
     * Gets an aspirant response id
     * @return aspirant response id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets an aspirant response id
     * @param id aspirant response id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets a response date
     * @return response date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets a response date
     * @param date response date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets a cover letter to the response
     * @return a cover letter to the response
     */
    public String getCoveringLetter() {
        return coveringLetter;
    }

    /**
     * Sets a cover letter to the response
     * @param coveringLetter cover letter to the response
     */
    public void setCoveringLetter(String coveringLetter) {
        this.coveringLetter = coveringLetter;
    }

    /**
     * Gets an aspirant account id
     * @return aspirant account id
     */
    public int getAspirantId() {
        return aspirantId;
    }

    /**
     * Gets id of the vacancy to which the response is left
     * @return id of the vacancy to which the response is left
     */
    public int getJobVacancyId() {
        return jobVacancyId;
    }

    /**
     * Gets id of the hr manager to which the vacancy refers
     * @return id of the hr manager to which the vacancy refers
     */
    public int getHrManagerId() {
        return hrManagerId;
    }

    /**
     * Sets id of the hr manager to which the vacancy refers
     * @param hrManagerId id of the hr manager to which the vacancy refers
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

    @Override
    public int compareTo(AspirantResponse obj) {
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

        AspirantResponse aspirantResponse = (AspirantResponse)obj;

        return this.getId() == aspirantResponse.getId();
    }
}
