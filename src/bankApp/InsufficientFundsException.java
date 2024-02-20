package bankApp;

public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String message) {
        super("Insufficient Funds");
    }
}
