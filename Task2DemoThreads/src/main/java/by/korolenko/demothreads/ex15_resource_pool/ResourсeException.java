package by.korolenko.demothreads.ex15_resource_pool;

public class ResourсeException extends Exception {
    public ResourсeException() {
    }

    public ResourсeException(String message) {
        super(message);
    }

    public ResourсeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourсeException(Throwable cause) {
        super(cause);
    }
}
