package bankApp;

public class InvalidTransferException extends RuntimeException {
    public InvalidTransferException(String message) {
        super("Invalid Transfer");
    }
}
