package Task9___30_11_2017.exceptions;

public class InvalidTransparencyException extends IllegalArgumentException {
    private String illegalTransparency;

    public InvalidTransparencyException(String illegalTransparency) {
        this.illegalTransparency = illegalTransparency;
    }

    @Override
    public String getMessage() {
        return "Transparency value should be 0-100%";
    }
}
