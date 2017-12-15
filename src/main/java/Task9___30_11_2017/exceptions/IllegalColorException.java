package Task9___30_11_2017.exceptions;

public class IllegalColorException extends IllegalArgumentException {
    private String illegalColor;

    public IllegalColorException(String illegalColor) {
        this.illegalColor = illegalColor;
    }

    @Override
    public String getMessage() {
        return "No such color available: " + illegalColor;
    }
}
