package Task5___17_11_2017.model.candies;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public enum Component {
    DARK_CHOCOLATE,
    MILK_CHOCOLATE,
    CARAMEL,
    NOUGAT,
    BISCUIT,
    WAFFLE,
    NUTS,
    JELLY,
    COOKIE;

    private Double sugarContent;

    /**
     * load if necessary and return sugarContent value
     *
     * @return double value of sugarContent for special enum object
     */
    public double getSugarContent() {
        if (sugarContent == null) {
            sugarContent = Double.parseDouble(sugarContentProps.getProperty(this.name()));
        }
        return sugarContent;
    }



    /**
     * for getting info about sugarContent
     */
    private static Properties sugarContentProps;
    private final static String pathToSugarContentProps = "src/main/java/Task5___17_11_2017/resources/sugarCompoundProps.properties";

    /**
     * load properties with sugarContent data
     *
     * @throw IllegalArgumentException if properties file is incorret
     */
    static {
        sugarContentProps = new Properties();
        try {
            sugarContentProps.load(new FileReader(pathToSugarContentProps));
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Incorrect properties file or pathToFile");
        }
    }



}
