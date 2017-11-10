package Task1___03_11_2017;

import java.util.Arrays;

/**
 * Дана целочисленная прямоугольная матрица.
 *
 * 3. Упорядочить столбцы по убыванию среднего значения.
 *
 * 4. Упорядочить строки, по возрастанию по самой длинной серии одинаковых элементов.
 */
public class Matrix_3_4 {

    /**
     * for testing methods that implement solutions
     */
    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 3, 2},
                {1, 4, 2},
                {1, 3, 1},
                {2, 3, 2},
        };
        int[][] matrix2 = {
                {2, 1, 2},
                {2, 3, 3},
                {2, 2, 2},
                {1, 3, 2},
        };
//        int[][] matrix3 = generateMatrix(5, 6);

        System.out.println("3. Упорядочить столбцы по убыванию среднего значения.");
        System.out.println(Arrays.deepToString(matrix1));
        sortColumnsByAverageValue(matrix1);
        System.out.println(Arrays.deepToString(matrix1));

        System.out.println();
        System.out.println("4.Упорядочить строки, по возрастанию по самой длинной серии одинаковых элементов.");
        System.out.println(Arrays.deepToString(matrix2));
        sortRawsByChainLength(matrix2);
        System.out.println(Arrays.deepToString(matrix2));

    }


    /**
     * 3. Упорядочить столбцы по убыванию среднего значения.
     *
     * NOTE: used matrix[rows][columns]
     *
     * @param matrix source matrix
     */
    public static void sortColumnsByAverageValue(int[][] matrix) {
        Double[] avrgColumns = new Double[matrix[0].length];
        for (int j = 0; j < matrix[0].length; j++) {
            int sum = 0;
            for (int i = 0; i < matrix.length; i++) {
                sum += matrix[i][j];
            }
            avrgColumns[j] = sum * 1.0 / matrix.length;
        }
//        System.out.println(Arrays.deepToString(avrgColumns));

        for (int m = 0; m < avrgColumns.length; m++) {
            for (int n = 1; n < avrgColumns.length - m; n++) {
                if (avrgColumns[n - 1] < avrgColumns[n]) {
                    for (int i = 0; i < matrix.length; i++) {
                        //change matrix
                        int tmp = matrix[i][n];
                        matrix[i][n] = matrix[i][n - 1];
                        matrix[i][n - 1] = tmp;
                    }
                    //change avrgColumns
                    double tmpAvg = avrgColumns[n];
                    avrgColumns[n] = avrgColumns[n - 1];
                    avrgColumns[n - 1] = tmpAvg;
                }
            }
        }
//        System.out.println(Arrays.deepToString(avrgColumns));
    }

    /**
     * 4. Упорядочить строки, по возрастанию по самой длинной серии одинаковых элементов.
     *
     * NOTE: used matrix[rows][columns]
     *
     * @param matrix source matrix
     */
    public static void sortRawsByChainLength(int[][] matrix) {
        Integer[] longestChain = new Integer[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            int maxChain = 1;
            int currentChain = 1;
            int previous = matrix[i][0];
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == previous) {
                    currentChain++;
                    if (maxChain < currentChain) {
                        maxChain = currentChain;
                    }
                } else {
                    previous = matrix[i][j];
                    currentChain = 1;
                }
            }
            longestChain[i] = maxChain;
        }

//        System.out.println(Arrays.deepToString(longestChain));
        for (int m = 0; m < longestChain.length; m++){
            for (int n = 1; n < longestChain.length - m; n++){
                if (longestChain[n-1]>longestChain[n]){
                    // change matrix
                    int[] tmp = matrix[n];
                    matrix[n] = matrix[n-1];
                    matrix[n-1] = tmp;
                    //change longestChain
                    int tmpChain = longestChain[n];
                    longestChain[n] = longestChain[n-1];
                    longestChain[n-1] = tmpChain;
                }
            }
        }
    }


    /**
     * Generate matrix for testing
     *
     * @param a number of rows
     * @param b number of columns
     * @return matrix[a][b] with random ints
     */
    public static int[][] generateMatrix(int a, int b) {
        int[][] matrix = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                matrix[i][j] = (int) (Math.random() * 100);
            }
        }
        return matrix;
    }
}
