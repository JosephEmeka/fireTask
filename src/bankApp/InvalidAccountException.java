package bankApp;

public class InvalidAccountException extends RuntimeException{
    public InvalidAccountException(String message){
        super("Invalid Account");
    }
}
