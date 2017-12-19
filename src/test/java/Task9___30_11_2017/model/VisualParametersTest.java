package Task9___30_11_2017.model;

import Task9___30_11_2017.exceptions.IllegalColorException;
import Task9___30_11_2017.exceptions.IllegalFacetCountException;
import Task9___30_11_2017.exceptions.InvalidTransparencyException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VisualParametersTest {
    private VisualParameters visualParameters;
    @Before
    public void init(){
        visualParameters = new VisualParameters();
    }
    @Test(expected = IllegalColorException.class)
    public void setColorWrong() throws Exception {
        visualParameters.setColor("ggg");
    }

    @Test
    public void setColorCorrect() throws Exception {
        visualParameters.setColor("green");
    }

    @Test
    public void setTransparency() throws Exception {
        visualParameters.setTransparency("98%");
    }
    @Test(expected = InvalidTransparencyException.class)
    public void setTransparencyWrong() throws Exception {
        visualParameters.setTransparency("101%");
    }

    @Test
    public void setFacetCount() throws Exception {
        visualParameters.setFacetCount("4");
    }
    @Test(expected = IllegalFacetCountException.class)
    public void setFacetCountWrong() throws Exception {
        visualParameters.setFacetCount("29");
    }

}