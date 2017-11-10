package Task0___02_11_2017;

/**
 *  task1:
 *  Используя циклы и метод:
 *  System.out.print("* "), System.out.print("  "),System.out.print("\n") (для перехода на новую строку).
 *  Выведите на экран:
 *  · прямоугольник
 *  · прямоугольный треугольник
 *  · равносторонний треугольник
 *  · ромб
 */

public class ShapePrinter {
    public static void main(String[] args) {
        printRectangle(7, 5);
        System.out.println();
        printRightTriangle();
        System.out.println();
        printRegularTriangle();
        System.out.println();
        printRhombus();
    }

    /**
     * print "прямоугольник"
     * @param height parameter of rectangle
     * @param width parameter of rectangle
     */
    public static void printRectangle(int height, int width) {
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                // for fist and last lines
                if (i == 1 | i == height) {
                    System.out.print("* ");
                }
                // for middle lines
                else if (j == 1 | j == width) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    /**
     * print "прямоугольный треугольник"
     */
    public static void printRightTriangle() {
        int a = 5;
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= i; j++) {
                //for last line
                if (i == a) {
                    System.out.print("* ");
                }
                //for other lines
                else if (j == 1) {
                    System.out.print("* ");
                } else if (j == i) {
                    System.out.print("* ");
//                    break;   -- instead of break there is the condition j<=i in inner cycle
                } else System.out.print("  ");
            }
            System.out.println();
        }
    }

    /**
     * print "равносторонний треугольник"
     */
    public static void printRegularTriangle(){
        int a = 7;
        for (int i = 1; i<=a; i++){
            for( int j = 1; j<= a*2; j++){
                //last line
                if (i == a) {
                    if (j%2==1) System.out.print("*");
                    else System.out.print(" ");
                }
                //other lines
                else if (j == a+1-i | j == a+i-1){
                    System.out.print("*");
                }
                else System.out.print(" ");
            }
            System.out.println();
        }
    }

    /**
     * print "ромб"
     */
    public static void printRhombus(){
        int a = 9; // initialize with odd numbers
        for (int i = 1; i <= a; i++){
            for (int j = 1; j <= a; j++){
                // upper half
                if (i < a/2.0){
                    if (j == (a+1)/2 - i + 1 | j == (a+1)/2 + i -1){
                        System.out.print("* ");
                    }
                    else System.out.print("  ");
                }
                // lower half and mid
                else {
                    if (j == i - (a+1)/2 +1 | j == a - (i - (a+1)/2) ){
                        System.out.print("* ");
                    }
                    else System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}

