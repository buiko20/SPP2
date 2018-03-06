package service.exception;

public class ResumeNotFoundException extends Exception {

    private String email;
    private String careerObjective;

    public ResumeNotFoundException(String email, String careerObjective) {
        this.email = email;
        this.careerObjective = careerObjective;
    }

    public String getEmail() {
        return email;
    }

    public String getCareerObjective() {
        return careerObjective;
    }
}
