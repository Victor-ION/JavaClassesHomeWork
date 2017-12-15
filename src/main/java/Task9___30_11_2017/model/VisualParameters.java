package Task9___30_11_2017.model;

import Task9___30_11_2017.exceptions.IllegalColorException;
import Task9___30_11_2017.exceptions.IllegalFacetCountException;
import Task9___30_11_2017.exceptions.InvalidTransparencyException;

public class VisualParameters {
    private Color color;
    private String transparency;
    private int facetCount;


    public Color getColor() {
        return color;
    }

    /**
     * should be one of the Color enum types
     * @param sColor source
     */
    public void setColor(String sColor) {
        try {
            Color color = Color.valueOf(sColor.toUpperCase());
            this.color = color;
        } catch (IllegalArgumentException e) {
            throw new IllegalColorException(sColor);
        }
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getTransparency() {
        return transparency;
    }

    /**
     * should be in range of 0-100%
     * @param transparency
     */
    public void setTransparency(String transparency) {
        if (transparency.matches("[0-9]{1}|[0-9]{2}|[0-9]{3}%")){
            //check that value is in range of 0-100%
            String digits = transparency.substring(0, transparency.length()-1);
            int i = Integer.parseInt(digits);
            if (i>100 || i<0) {
                throw new InvalidTransparencyException(transparency);
            } else {
                this.transparency = transparency;
            }
        } else {
            throw new InvalidTransparencyException(transparency);
        }
    }

    public int getFacetCount() {
        return facetCount;
    }

    /**
     * should be represented as integer in range of 4-15 inclusive
     * @param sFacetCount
     */
    public void setFacetCount(String sFacetCount) {
        int count = 0;
        try {
            count = Integer.parseInt(sFacetCount);
        } catch (NumberFormatException e) {
            throw new IllegalFacetCountException(sFacetCount, "not an integer");
        }
        if (count<4 ||count>15) throw new IllegalFacetCountException(sFacetCount,
                "Count is out of allowed range");
        this.facetCount = facetCount;
    }

    public void setFacetCount(int facetCount) {
        this.facetCount = facetCount;
    }
}
