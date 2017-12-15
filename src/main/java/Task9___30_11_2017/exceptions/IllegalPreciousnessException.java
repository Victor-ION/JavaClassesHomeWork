package Task9___30_11_2017.exceptions;

public class IllegalPreciousnessException extends IllegalArgumentException {
    private String illegalArg;

    public IllegalPreciousnessException(String illegalArg) {
        this.illegalArg = illegalArg;
    }

    @Override
    public String getMessage() {
        return "no such preciousness type: " + illegalArg;
    }
}
