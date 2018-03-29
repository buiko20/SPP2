package viewModel;

import java.util.Date;

/**
 * Represents an invitation view model.
 */
public class AspirantInvitation {

    public Date date;
    public String address;
    public String aspirantEmail;
    public String aspirantCareerObjective;
    public String companyName;
    public String jobVacancyName;
    public String hrManagerSurname;
    public String hrManagerName;
    public String hrManagerPhoneNumber;
    public String hrManagerEmail;

    /**
     * Initializes a new instance of the {@link AspirantInvitation model}
     * @param date date of interview
     * @param address address of interview
     * @param aspirantEmail aspirant email
     * @param aspirantCareerObjective aspirant career objective
     * @param companyName company name
     * @param jobVacancyName job vacancy name
     * @param hrManagerSurname HR manager surname
     * @param hrManagerName HR manager name
     * @param hrManagerPhoneNumber HR manager phone number
     * @param hrManagerEmail HR manager email
     */
    public AspirantInvitation(Date date, String address, String aspirantEmail, String aspirantCareerObjective, String companyName, String jobVacancyName,
                              String hrManagerSurname, String hrManagerName, String hrManagerPhoneNumber, String hrManagerEmail) {
        this.date = date;
        this.address = address;
        this.aspirantEmail = aspirantEmail;
        this.aspirantCareerObjective = aspirantCareerObjective;
        this.companyName = companyName;
        this.jobVacancyName = jobVacancyName;
        this.hrManagerSurname = hrManagerSurname;
        this.hrManagerName = hrManagerName;
        this.hrManagerPhoneNumber = hrManagerPhoneNumber;
        this.hrManagerEmail = hrManagerEmail;
    }

    /**
     * Gets a date of interview.
     * @return date of interview
     */
    public Date getDate() {
        return date;
    }

    /**
     * Gets an address of interview.
     * @return address of interview
     */
    public String getAddress() {
        return address;
    }

    /**
     * Gets an aspirant email.
     * @return aspirant email
     */
    public String getAspirantEmail() {
        return aspirantEmail;
    }

    /**
     * Gets an aspirant career objective.
     * @return aspirant career objective
     */
    public String getAspirantCareerObjective() {
        return aspirantCareerObjective;
    }

    /**
     * Gets a company name.
     * @return company name
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Gets a job vacancy name.
     * @return job vacancy name
     */
    public String getJobVacancyName() {
        return jobVacancyName;
    }

    /**
     * Get an HR manager surname.
     * @return HR manager surname
     */
    public String getHrManagerSurname() {
        return hrManagerSurname;
    }

    /**
     * Gets an HR manager name.
     * @return HR manager name
     */
    public String getHrManagerName() {
        return hrManagerName;
    }

    /**
     * Gets an HR manager phone number.
     * @return HR manager phone number
     */
    public String getHrManagerPhoneNumber() {
        return hrManagerPhoneNumber;
    }

    /**
     * Gets an HR manager email.
     * @return HR manager email
     */
    public String getHrManagerEmail() {
        return hrManagerEmail;
    }
}
