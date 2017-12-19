package Task9___30_11_2017.model;

import Task9___30_11_2017.exceptions.IllegalPreciousnessException;
import Task9___30_11_2017.exceptions.InvalidValueException;
import Task9___30_11_2017.exceptions.NotUnicNameException;

import java.util.HashSet;
import java.util.Set;

public class Gem {

    private String unicName;
    private String typeName;
    private Preciousness preciousness;
    private String origin;
    private VisualParameters visualParameters;
    private Double value;

    public Gem() {
        visualParameters = new VisualParameters();
    }

    public String getUnicName() {
        return unicName;
    }

    /**
     * no restrictions
     * @param unicName source
     */
    public void setUnicName(String unicName) {
        this.unicName = unicName;

    }

    public String getTypeName() {
        return typeName;
    }

    /**
     * no restrictions
     * @param typeName source
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Preciousness getPreciousness() {
        return preciousness;
    }

    /**
     * should be one of the two enum objects
     * @param preciousness source
     */
    public void setPreciousness(String preciousness) {
        try {
            Preciousness precEnum = Preciousness.valueOf(preciousness.toUpperCase());
            setPreciousness(precEnum);
        } catch (IllegalArgumentException e) {
            throw new IllegalPreciousnessException(preciousness);
        }
    }

    public void setPreciousness(Preciousness preciousness){
        this.preciousness = preciousness;
    }

    public String getOrigin() {
        return origin;
    }

    /**
     * no restrictions
     * @param origin source
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public VisualParameters getVisualParameters() {
        return visualParameters;
    }

    /**
     * all restrictions in VisualParameters set methods
     * @param visualParameters source
     */
    public void setVisualParameters(VisualParameters visualParameters) {
        this.visualParameters = visualParameters;
    }

    public Double getValue() {
        return value;
    }

    /**
     * should be string representation of positive double
     * @param sValue source
     */
    public void setValue(String sValue) {
        double value = 0;
        try {
            value = Double.parseDouble(sValue);
        } catch (NumberFormatException e) {
            throw new InvalidValueException(sValue, "not a double!");
        }
        if (value <= 0){
            throw new InvalidValueException(sValue, "value is negative or equals to zero");
        }
        this.value = value;
    }

    public void setValue(Double value) {
        this.value = value;
    }




    @Override
    public String toString() {
        return "Gem{" +
                "unicName='" + unicName + '\'' +
                ", typeName='" + typeName + '\'' +
                ", preciousness=" + preciousness +
                ", origin='" + origin + '\'' +
                ", visualParameters=" + visualParameters +
                ", value=" + value +
                '}';
    }
}
