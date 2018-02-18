package service.exception;

public class AspirantAlreadyExistsException extends Exception {

    private String aspirantEmail;

    public AspirantAlreadyExistsException(String aspirantEmail) {
        super();
        this.aspirantEmail = aspirantEmail;
    }

    public String getAspirantEmail() {
        return aspirantEmail;
    }
}
