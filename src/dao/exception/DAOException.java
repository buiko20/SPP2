package dao.exception;

/**
 * Represents the base exception for a DAO.
 */
public class DAOException extends Exception {

    /**
     * @see Exception#Exception(String)
     */
    public DAOException(String message) {
        super(message);
    }

    /**
     * @see Exception#Exception(String, Throwable)
     */
    public DAOException(String message, Exception e) {
        super(message, e);
    }
}
