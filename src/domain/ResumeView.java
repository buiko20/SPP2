package domain;

import java.util.Date;

/**
 * Represents a resume view domain model.
 */
public class ResumeView implements Comparable<ResumeView> {

    private int id;
    private Date date;
    private int resumeId;
    private int aspirantId;
    private int hrManagerId;
    private int companyId;

    /**
     * Initializes a new instance of the {@link ResumeView model}
     * @param date resume view date
     * @param resumeId resume id
     * @param aspirantId id of the aspirant to which the resume belongs
     * @param hrManagerId id of the HRManager who viewed the resume
     * @param companyId id of the company that looked the resume
     */
    public ResumeView(Date date, int resumeId, int aspirantId, int hrManagerId, int companyId) {
        this.date = date;
        this.resumeId = resumeId;
        this.aspirantId = aspirantId;
        this.hrManagerId = hrManagerId;
        this.companyId = companyId;
    }

    /**
     * Initializes a new instance of the {@link ResumeView model}
     * @param id resume view id
     * @param date resume view date
     * @param resumeId resume id
     * @param aspirantId id of the aspirant to which the resume belongs
     * @param hrManagerId id of the HRManager who viewed the resume
     * @param companyId id of the company that looked the resume
     */
    public ResumeView(int id, Date date, int resumeId, int aspirantId, int hrManagerId, int companyId) {
        this.id = id;
        this.date = date;
        this.resumeId = resumeId;
        this.aspirantId = aspirantId;
        this.hrManagerId = hrManagerId;
        this.companyId = companyId;
    }

    /**
     * Gets a resume view id
     * @return resume view id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets a resume view id
     * @param id resume view id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets a resume view date
     * @return resume view date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Gets a resume id
     * @return resume id
     */
    public int getResumeId() {
        return resumeId;
    }

    /**
     * Gets id of the aspirant to which the resume belongs
     * @return id of the aspirant to which the resume belongs
     */
    public int getAspirantId() {
        return aspirantId;
    }

    /**
     * id of the HRManager who viewed the resume
     * @return id of the HRManager who viewed the resume
     */
    public int getHrManagerId() {
        return hrManagerId;
    }

    /**
     * Gets id of the company that looked the resume
     * @return id of the company that looked the resume
     */
    public int getCompanyId() {
        return companyId;
    }

    @Override
    public int compareTo(ResumeView obj) {
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

        ResumeView resumeView = (ResumeView)obj;

        return this.getId() == resumeView.getId();
    }
}
