package domain;

import java.util.Date;

/**
 * Represents a resume domain model.
 */
public class Resume implements Comparable<Resume> {

    private int id;
    private Date date;
    private String careerObjective;
    private Boolean isTripPossible;
    private Boolean isRelocationPossible;
    private String skills;
    private Float salary;
    private int numberOfViews;
    private int aspirantId;

    public Resume() {
    }

    /**
     * Initializes a new instance of the {@link Resume model}
     * @param date date of the resume update
     * @param careerObjective aspirant career objective
     * @param isTripPossible value indicating the possibility of a business trip
     * @param isRelocationPossible value indicating the possibility of a relocation
     * @param skills aspirant skills
     * @param salary desired salary of an aspirant
     * @param numberOfViews number of resume views
     * @param aspirantId id of the aspirant to which the resume belongs
     */
    public Resume(Date date, String careerObjective, Boolean isTripPossible, Boolean isRelocationPossible,
                  String skills, Float salary, int numberOfViews, int aspirantId) {
        this.date = date;
        this.careerObjective = careerObjective;
        this.isTripPossible = isTripPossible;
        this.isRelocationPossible = isRelocationPossible;
        this.skills = skills;
        this.salary = salary;
        this.numberOfViews = numberOfViews;
        this.aspirantId = aspirantId;
    }

    /**
     * Initializes a new instance of the {@link Resume model}
     * @param id resume id
     * @param date date of the resume update
     * @param careerObjective aspirant career objective
     * @param isTripPossible value indicating the possibility of a business trip
     * @param isRelocationPossible value indicating the possibility of a relocation
     * @param skills aspirant skills
     * @param salary desired salary of an aspirant
     * @param numberOfViews number of resume views
     * @param aspirantId id of the aspirant to which the resume belongs
     */
    public Resume(int id, Date date, String careerObjective, Boolean isTripPossible, Boolean isRelocationPossible,
                  String skills, Float salary, int numberOfViews, int aspirantId) {
        this.id = id;
        this.date = date;
        this.careerObjective = careerObjective;
        this.isTripPossible = isTripPossible;
        this.isRelocationPossible = isRelocationPossible;
        this.skills = skills;
        this.salary = salary;
        this.numberOfViews = numberOfViews;
        this.aspirantId = aspirantId;
    }

    /**
     * Gets a resume id
     * @return resume id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets a resume id
     * @param id resume id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets a date of the resume update
     * @return date of the resume update
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets a date of the resume update
     * @param date date of the resume update
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets an aspirant career objective
     * @return aspirant career objective
     */
    public String getCareerObjective() {
        return careerObjective;
    }

    /**
     * Sets an aspirant career objective
     * @param careerObjective aspirant career objective
     */
    public void setCareerObjective(String careerObjective) {
        this.careerObjective = careerObjective;
    }

    /**
     * Gets a value indicating the possibility of a business trip
     * @return value indicating the possibility of a business trip
     */
    public Boolean getTripPossible() {
        return isTripPossible;
    }

    /**
     * Sets a value indicating the possibility of a business trip
     * @param tripPossible value indicating the possibility of a business trip
     */
    public void setTripPossible(Boolean tripPossible) {
        isTripPossible = tripPossible;
    }

    /**
     * Gets a value indicating the possibility of a relocation
     * @return value indicating the possibility of a relocation
     */
    public Boolean getRelocationPossible() {
        return isRelocationPossible;
    }

    /**
     * Sets a value indicating the possibility of a relocation
     * @param relocationPossible value indicating the possibility of a relocation
     */
    public void setRelocationPossible(Boolean relocationPossible) {
        isRelocationPossible = relocationPossible;
    }

    /**
     * Gets aspirant skills
     * @return aspirant skills
     */
    public String getSkills() {
        return skills;
    }

    /**
     * Sets aspirant skills
     * @param skills aspirant skills
     */
    public void setSkills(String skills) {
        this.skills = skills;
    }

    /**
     * Gets desired salary of the aspirant
     * @return desired salary of the aspirant
     */
    public Float getSalary() {
        return salary;
    }

    /**
     * Sets desired salary of the aspirant
     * @param salary desired salary of the aspirant
     */
    public void setSalary(Float salary) {
        this.salary = salary;
    }

    /**
     * Gets a number of resume views
     * @return number of resume views
     */
    public int getNumberOfViews() {
        return numberOfViews;
    }

    /**
     * Sets a number of resume views
     * @param numberOfViews number of resume views
     */
    public void setNumberOfViews(int numberOfViews) {
        this.numberOfViews = numberOfViews;
    }

    /**
     * Gets id of the aspirant to which the resume belongs
     * @return
     */
    public int getAspirantId() {
        return aspirantId;
    }

    @Override
    public int compareTo(Resume obj) {
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

        Resume resume = (Resume)obj;

        return this.getId() == resume.getId();
    }
}
