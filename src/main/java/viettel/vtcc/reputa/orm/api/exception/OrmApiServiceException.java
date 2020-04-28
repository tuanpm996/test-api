package viettel.vtcc.reputa.orm.api.exception;

public class OrmApiServiceException extends Exception{
    private static final long serialVersionUID = 5993077978826827583L;

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public OrmApiServiceException(String message) {
        super(message);
    }
}
