package bankApp;

public class DoubleRegistrationException extends RuntimeException{
    public DoubleRegistrationException(String message){
        super("This account has been registered before");
    }
}
