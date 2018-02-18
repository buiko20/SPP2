package service.exception;

public class AspirantNotRegisteredException extends Exception {

    private String aspirantEmail;

    public AspirantNotRegisteredException(String aspirantEmail) {
        super();
        this.aspirantEmail = aspirantEmail;
    }

    public String getAspirantEmail() {
        return aspirantEmail;
    }

}
