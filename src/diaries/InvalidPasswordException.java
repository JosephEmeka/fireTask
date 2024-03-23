package diaries;

public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException(String message) {
        super("Invalid Password");
    }

}
