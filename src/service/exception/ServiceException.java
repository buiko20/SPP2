package service.exception;

/**
 * Represents the base exception for a service.
 */
public class ServiceException extends Exception {

    /**
     * @see Exception#Exception(String)
     */
    public ServiceException(String message) {
        super(message);
    }

    /**
     * @see Exception#Exception(String, Throwable)
     */
    public ServiceException(String message, Exception e) {
        super(message, e);
    }
}