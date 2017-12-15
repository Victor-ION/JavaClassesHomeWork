package Task9___30_11_2017.exceptions;

public class NotUnicNameException extends IllegalArgumentException{
    private String notUnicName;
    public NotUnicNameException(String notUnicName) {
        this.notUnicName = notUnicName;
    }

    @Override
    public String getMessage() {
        return "Not unic name of the gem: " + notUnicName;
    }
}
