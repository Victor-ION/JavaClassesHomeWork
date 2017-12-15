package Task8___28_11_2017;

public class Demo {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        String expr = "3+5";
        System.out.println(calculator.calculate(expr));
        System.out.println();
        System.out.println();

        expr = "3+5-2";
        System.out.println(calculator.calculate(expr));
        System.out.println();
        System.out.println();

        expr = "3+(5-2)";
        System.out.println(calculator.calculate(expr));
        System.out.println();
        System.out.println();

        expr = "3+4*(8)";
        System.out.println(calculator.calculate(expr));
        System.out.println();
        System.out.println();

        expr = "cos(90*3.14/180)";
        System.out.println(calculator.calculate(expr));
        System.out.println();
        System.out.println();

        expr = "sin((35-5)*3.14/180)";
        System.out.println(calculator.calculate(expr));
        System.out.println();
        System.out.println();
    }
}
