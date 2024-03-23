package bankApp;

public class ValueErrorException extends RuntimeException{
    public ValueErrorException(String message) {
        super("Wrong Value");
    }
}
