package service.exception;

public class JobVacancyNotFoundException extends Exception {

    private String vacancyName;
    private String companyName;

    public JobVacancyNotFoundException(String vacancyName, String companyName) {
        this.vacancyName = vacancyName;
        this.companyName = companyName;
    }

    public String getVacancyName() {
        return vacancyName;
    }

    public String getCompanyName() {
        return companyName;
    }
}
