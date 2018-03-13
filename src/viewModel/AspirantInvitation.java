package viewModel;

import java.util.Date;

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

    public Date getDate() {
        return date;
    }

    public String getAddress() {
        return address;
    }

    public String getAspirantEmail() {
        return aspirantEmail;
    }

    public String getAspirantCareerObjective() {
        return aspirantCareerObjective;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getJobVacancyName() {
        return jobVacancyName;
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

    public String getHrManagerEmail() {
        return hrManagerEmail;
    }
}
