package service.exception;

public class CompanyNotFoundException extends Exception {

    private String companyName;

    public CompanyNotFoundException(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }
}
