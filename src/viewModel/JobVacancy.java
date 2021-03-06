package viewModel;

import java.util.Date;

/**
 * Represents a job vacancy view model.
 */
public class JobVacancy {

    public String status;
    public String name;
    public Date date;
    public String companyName;
    public String hrManagerSurname;
    public String hrManagerName;
    public String hrManagerPhoneNumber;
    public String hrManagerEmail;
    public String description;
    public String address;

    /**
     * Initializes a new instance of the {@link JobVacancy model}
     * @param status job vacancy status
     * @param name job vacancy name
     * @param date job vacancy creation date
     * @param companyName company name
     * @param hrManagerSurname HR manager surname
     * @param hrManagerName HR manager name
     * @param hrManagerPhoneNumber HR manager phone number
     * @param hrManagerEmail HR manager email
     * @param description job vacancy description
     * @param address job vacancy address
     */
    public JobVacancy(String status, String name, Date date, String companyName, String hrManagerSurname,
                      String hrManagerName, String hrManagerPhoneNumber, String hrManagerEmail,
                      String description, String address) {
        this.status = status;
        this.name = name;
        this.date = date;
        this.companyName = companyName;
        this.hrManagerSurname = hrManagerSurname;
        this.hrManagerName = hrManagerName;
        this.hrManagerPhoneNumber = hrManagerPhoneNumber;
        this.hrManagerEmail = hrManagerEmail;
        this.description = description;
        this.address = address;
    }

    public String getHrManagerEmail() {
        return hrManagerEmail;
    }

    public String getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getHrManagerSurname() {
        return hrManagerSurname;
    }

    public String getHrManagerName() {
        return hrManagerName;
    }

    public String getHrManagerPhoneNumber() {
        return hrManagerPhoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

}
