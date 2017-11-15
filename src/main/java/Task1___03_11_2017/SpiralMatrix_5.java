package Task1___03_11_2017;

/**
 * 5. Дана квадратная матрица A порядка M (M — нечетное число). Начи-
 *    ная с элемента A1,1 и перемещаясь по часовой стрелке, вывести все ее эле-
 *    менты по спирали: первая строка, последний столбец, последняя строка в
 *    обратном  порядке,  первый  столбец  в  обратном  порядке,  оставшиеся  эле-
 *    менты второй строки и т. д.; последним выводится центральный элемент
 *    матрицы.
 */
public class SpiralMatrix_5 {

    /**
     * for testing methods that implement solutions
     */
    public static void main(String[] args) {
        int[][] matrix = {
                {1,   2,  3,  4,  5},
                {6,   7,  8,  9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        System.out.println(
                "Matrix:  [  [1,   2,  3,  4,  5]\n" +
                "            [6,   7,  8,  9, 10]\n" +
                "            [11, 12, 13, 14, 15]\n" +
                "            [16, 17, 18, 19, 20]\n" +
                "            [21, 22, 23, 24, 25]  ]\n");

        System.out.print("Spiral : ");
        printMatrixSpiraly(matrix);
    }

    /*
     there are 3 evident ways to implement method :
        1. via cycle print every 4 vectors
        2. via recursion print every 4 vectors
        3. via cycle/recursion rotate matrix and print one line by step
        
        Here implemented "1" way (as the least resource-eating)
      */

    /**
     * Solution
     * @param matrix that method need to print
     */
    public static void printMatrixSpiraly(int[][] matrix){
        for (int i = 0; i <= (matrix.length/2); i++){
            printFromLeftToRight(matrix, i);
            printFromUpToDown(matrix, i);
            printFromRightToLeft(matrix, i);
            printFromDownToUp(matrix, i);
        }
//        System.out.print(matrix[(matrix.getLength/2)][(matrix.getLength/2)]); // use this when (i<...) instead of (i<=...)
    }

    private static void printFromLeftToRight(int[][] matrix, int i) {
        for (int j = i; j < matrix.length - i; j++){
            System.out.print(matrix[i][j] + " ");
        }
    }

    private static void printFromUpToDown(int[][] matrix, int i) {
        for (int j = i+1; j < matrix.length-i; j++){
            System.out.print(matrix[j][matrix.length-1-i] + " ");
        }
    }

    private static void printFromRightToLeft(int[][] matrix, int i) {
        for (int j = matrix.length-2-i; j >=i; j--){
            System.out.print(matrix[matrix.length-1-i][j] + " ");
        }
    }

    private static void printFromDownToUp(int[][] matrix, int i) {
        for (int j = matrix.length-2-i; j > i; j--){
            System.out.print(matrix[j][i] + " ");
        }
    }

}
