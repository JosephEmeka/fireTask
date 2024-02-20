package bankApp;

public class InvalidAmountException extends RuntimeException {
    public InvalidAmountException(String message) {
        super("Invalid amount");
    }
}
