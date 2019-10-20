package by.korolenko.composite.service.exception;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public class ProblemFileException extends Exception {
    /**
     * Constructor.
     */
    public ProblemFileException() {
    }

    /**
     * Constructor.
     *
     * @param message message
     */
    public ProblemFileException(final String message) {
        super(message);
    }

    /**
     * Constructor.
     *
     * @param message message
     * @param cause   cause
     */
    public ProblemFileException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor.
     *
     * @param cause cause
     */
    public ProblemFileException(final Throwable cause) {
        super(cause);
    }
}
