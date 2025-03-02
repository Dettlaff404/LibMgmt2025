package lk.ijse.cmjd108.LibMgmt2025.exception;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException() {
        super();
    }

    public BookNotFoundException(String message) {
        super(message);
    }

    public BookNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
