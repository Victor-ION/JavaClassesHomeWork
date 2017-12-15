package Task9___30_11_2017.exceptions;

public class IllegalFacetCountException extends IllegalArgumentException {
    private String illFacetCount;
    private String cause;

    public IllegalFacetCountException(String illFacetCount, String cause) {
        this.illFacetCount = illFacetCount;
        this.cause = cause;
    }

    @Override
    public String getMessage() {
        return "Illegal facet count: " + illFacetCount + " (" + cause + ")";
    }
}
