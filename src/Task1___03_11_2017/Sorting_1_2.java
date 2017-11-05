package Task1___03_11_2017;

import java.util.Arrays;

/**
 * Сортировка последовательности
 * 1. Упорядочить одномерный масиве вначале отрицательные повозрастанию
 *    затем положительные по убыванию.
 *
 * 2. В одномерном массиве сначала положительные потом отрицательные за О(n).
 */

public class Sorting_1_2 {

    /**
     * for testing methods that implement solutions
     */
    public static void main(String[] args) {
        System.out.println("1. Упорядочить одномерный масиве вначале отрицательные повозрастанию " +
                              "затем положительные по убыванию.");
        int[] arr1 = {2, 7, -5, -4, 6, 3, -8, 0, 10};
        System.out.println(Arrays.toString(arr1));
        sort1(arr1);
        System.out.println(Arrays.toString(arr1));

        System.out.println();

        System.out.println("2. В одномерном массиве сначала положительные потом отрицательные за О(n).");
        int[] arr2 = {2, 7, -5, -4, 6, 3, -8, 0, 10};
        System.out.println(Arrays.toString(arr2));
        sort2(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    /**
     * 1. Упорядочить одномерный масиве вначале отрицательные повозрастанию
     *    затем положительные по убыванию.
     *
     * NOTE: 0 treated as positive number
     *
     * @param arr source int array
     */
    public static void sort1(int[] arr) {
        int sortedEnd = arr.length;
        for (int i = 0; i<sortedEnd-1; i++){
            if (arr[i] < 0){
                int minIndex = i;
                for (int j = i+1; j < sortedEnd; j++){
                    if (arr[j]<arr[minIndex]) minIndex = j;
                }
                int tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
            else {
                int maxIndex = i;
                for (int j = i+1; j < sortedEnd-1; j++){
                    if (arr[j]<arr[i] && arr[j] >=0) maxIndex = j;
                }
                int tmp = arr[sortedEnd-1];
                arr[sortedEnd-1] = arr[maxIndex];
                arr[maxIndex] = tmp;
                sortedEnd--;
                i--;
            }
        }

    }

    /**
     * 2. В одномерном массиве сначала положительные потом отрицательные за О(n)
     *
     * NOTE: 0 treated as positive number
     *
     * @param arr source int array
     */
    public static void sort2(int[] arr) {
        int fromEnd = arr.length-1;
        for (int i = 0; i < arr.length; i++) {
            // when arr[i] is negative
            if (arr[i] < 0) {
                // find positive at the right side to swap with arr[i]
                while (fromEnd > i && arr[fromEnd] < 0 ){
                    fromEnd--;
                }
                if (fromEnd > i){
                    int tmp = arr[i];
                    arr[i] = arr[fromEnd];
                    arr[fromEnd] = tmp;
                }
            }
        }
    }
}
