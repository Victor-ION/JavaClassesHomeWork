package Task9___30_11_2017.exceptions;

public class InvalidValueException extends IllegalArgumentException{
    private String invalidString;
    private String cause;

    public InvalidValueException(String invalidString, String cause) {
        this.invalidString = invalidString;
        this.cause = cause;
    }

    @Override
    public String getMessage() {
        return "Invalid value: " + invalidString + " (" + cause + ")";
    }
}
