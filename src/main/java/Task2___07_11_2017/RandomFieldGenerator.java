package Task2___07_11_2017;

import java.util.Random;

public class RandomFieldGenerator {

    /**
     * for testing static methods
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i <20; i++)
        System.out.println(getCasualName());

    }

    private static Random random = new Random();

    /**
     * generate random int in the certain area
     * @param start inclusively
     * @param end exclusively
     * @return random int
     */
    public static int getInt(int start, int end){
        return (int) (random.nextDouble()*(end-start)) + start;
    }

    /**
     * generate random int in the certain area
     * @param start inclusively
     * @param end exclusively
     * @return random double
     */
    public static double getDouble(double start, double end){
        return random.nextDouble()*(end-start) + start;
    }

    public static String getName(int length){
        //generate first UpperCase letter
        char cUpper = (char) getInt(65, 91);
        StringBuilder sb = new StringBuilder(length);
        sb.append(cUpper);

        for (int i = 0; i < length-1; i++){
            // generate
            char cLow = (char) getInt(97, 123);
            sb.append(cLow);
        }

        return sb.toString();
    }

    /**
     *
     * @param minLength inclusively
     * @param maxLength exclusively
     * @return random name
     */
    public static String getName(int minLength, int maxLength){
        return getName(getInt(minLength, maxLength));
    }

    public static String getCasualName(){
        return getName(3, 10);
    }
}
