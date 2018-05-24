package service.exception;

public class HRManagerNotFoundException extends Exception {

    private String email;

    public HRManagerNotFoundException(String email) {
        super();
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

}
