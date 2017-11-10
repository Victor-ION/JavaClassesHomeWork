package Task1___03_11_2017;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Составить программу, отыскивающую проход по лабиринту
 */
public class Labyrinth {

    /**
     * for testing methods that implement solutions
     */
    public static void main(String[] args) {
        testWithExit();

        System.out.println();

        testWithoutExit();
    }

    /**
     * Finds the way out via getExit(...) method and prints either the result path or notification that exit is absent
     *
     * @param matrix represents labyrinth with y rows and x columns - matrix[y][x]. 0 - opened, 1 - closed
     * @param startX indicate start position via coordinate x
     * @param startY indicate start position via coordinate y
     */
    public static void findAndPrintExit(int[][] matrix, int startX, int startY) {
        Deque<Point> deque = getExit(matrix, new Point(startY, 0));
        if (deque == null) {
            System.out.println("No way out! Don't even try!");
        } else {
            System.out.print("Way Out:   ");
            while (!deque.isEmpty()) {
                System.out.print(deque.removeLast() + " --> ");
            }
        }
    }

    /**
     * @param matrix   represents labyrinth with y rows and x columns - matrix[y][x]. 0 - opened, 1 - closed
     * @param startPos indicates starting position in matrix via Point object
     *                 <p>
     *                 NOTE: Coordinates of every element of matrix (cube/cell) are represented by Point objects
     * @return stack (ArrayDeque) with solution path or null if there is no solution
     * @throws IllegalArgumentException when startPos is closed (matrix[y][x] != 0)
     */
    public static Deque<Point> getExit(int[][] matrix, Point startPos) {
        if (startPos.isOutOfMatrix(matrix) || !startPos.isOpen(matrix))
            throw new IllegalArgumentException("start point is closed!");
        if (startPos.isCorner(matrix)) throw new IllegalArgumentException("start point is corner!");
        Deque<Point> deque = new ArrayDeque<>();

        // handle entrance and make first step deeper
        if (startPos.isTerminal(matrix) && !startPos.isCorner(matrix)) {
            deque.addFirst(startPos);
            if (startPos.x == 0 && makeStep(matrix, deque, new Point(startPos.y, startPos.x + 1))) return deque;
            if (startPos.y == 0 && makeStep(matrix, deque, new Point(startPos.y + 1, startPos.x))) return deque;
            if (startPos.x == matrix[0].length - 1 && makeStep(matrix, deque, new Point(startPos.y, startPos.x - 1)))
                return deque;
            if (startPos.y == matrix.length - 1 && makeStep(matrix, deque, new Point(startPos.y - 1, startPos.x)))
                return deque;
        } else throw new IllegalArgumentException("start point can't be an entrance! (not terminal)");


        return null;
    }


    private static boolean makeStep(int[][] matrix, Deque<Point> deque, Point point) {
        // if point is closed.
        // There is no necessity to check borders: in previous steps they were checked (finding terminal)

        if (!point.isOpen(matrix)) return false;

        // to avoid returning or looping
        if (deque.contains(point)) return false;

        deque.addFirst(point);


        // check if point is terminal
        if (point.isTerminal(matrix)) return true;

        // up
        if (makeStep(matrix, deque, new Point(point.y - 1, point.x))) return true;
        // right
        if (makeStep(matrix, deque, new Point(point.y, point.x + 1))) return true;
        // down
        if (makeStep(matrix, deque, new Point(point.y + 1, point.x))) return true;
        // left
        if (makeStep(matrix, deque, new Point(point.y, point.x - 1))) return true;

        // if no way out
        deque.removeFirst();
        return false;
    }


    public static class Point {
        public int x, y;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        private boolean isOpen(int[][] matrix) {
            return matrix[y][x] == 0;
        }

        private boolean isOutOfMatrix(int[][] matrix) {
            return (y < 0 || y >= matrix.length || x < 0 || x >= matrix[0].length);
        }

        private boolean isTerminal(int[][] matrix) {
            return (y == 0 || y == matrix.length - 1 || x == 0 || x == matrix[0].length);
        }

        private boolean isCorner(int[][] matrix) {
            return ((x == 0 && y == 0) ||
                    (x == (matrix[0].length - 1) && y == (matrix.length - 1)) ||
                    ((x == 0) && y == (matrix.length - 1)) ||
                    (x == (matrix[0].length - 1) && y == 0)
            );
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

        @Override
        public String toString() {
            return "[" + y + "]" + "[" + x + "]";
        }
    }


    private static void testWithExit() {
        int[][] matrix = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {0, 0, 1, 0, 1},
                {1, 1, 0, 0, 1},
                {1, 1, 0, 1, 1}
        };
        System.out.println(
                "Labyrinth:   {1, 1, 1, 1, 1}\n" +
                        "             {1, 0, 0, 0, 1}\n" +
                        "             {0, 0, 1, 0, 1}\n" +
                        "             {1, 1, 0, 0, 1}\n" +
                        "             {1, 1, 0, 1, 1}\n");

        findAndPrintExit(matrix, 0, 2);
        System.out.println();
    }


    private static void testWithoutExit() {
        int[][] matrix = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {0, 0, 1, 0, 1},
                {1, 1, 0, 0, 1},
                {1, 1, 1, 1, 1}
        };
        System.out.println(
                "Labyrinth:   {1, 1, 1, 1, 1}\n" +
                        "             {1, 0, 0, 0, 1}\n" +
                        "             {0, 0, 1, 0, 1}\n" +
                        "             {1, 1, 0, 0, 1}\n" +
                        "             {1, 1, 1, 1, 1}\n");

        findAndPrintExit(matrix, 0, 2);
        System.out.println();
    }

}
