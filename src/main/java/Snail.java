public class Snail {

    /**
     *
     * TODO 5
     *
     * Input: an n x n 2d array.
     * Output: a 1d array of length n^2 that contains the order of elements visited in a snail traversal of the 2d array.
     *
     * Example:
     *
     * Input:
     *
     * {
     *     {1,2,3},
     *     {4,5,6},
     *     {7,8,9}
     * }
     *
     * Output:
     *
     * {1,2,3,6,9,8,7,4,5}
     *
     * @param array2d
     * @return a 1d array containing the order of elements visited in a snail traversal of the 2d array.
     *         returns an empty array if array2d is not square.
     */
    public static int[] flattenSnail(int[][] array2d) {
        if (!isPerfectSquare(array2d)) {
            return new int[0]; // Return empty array if array2d is not square
        }

        int n = array2d.length; // Size of the square matrix
        int[] result = new int[n * n]; // Result array to store the snail traversal

        int index = 0; // Index to track the position in the result array
        int rowStart = 0; // Starting row index
        int rowEnd = n - 1; // Ending row index
        int colStart = 0; // Starting column index
        int colEnd = n - 1; // Ending column index

        while (rowStart <= rowEnd && colStart <= colEnd) {
            // Traverse the top row from left to right
            for (int col = colStart; col <= colEnd; col++) {
                result[index++] = array2d[rowStart][col];
            }
            rowStart++;

            // Traverse the right column from top to bottom
            for (int row = rowStart; row <= rowEnd; row++) {
                result[index++] = array2d[row][colEnd];
            }
            colEnd--;

            // Traverse the bottom row from right to left
            if (rowStart <= rowEnd) {
                for (int col = colEnd; col >= colStart; col--) {
                    result[index++] = array2d[rowEnd][col];
                }
                rowEnd--;
            }

            // Traverse the left column from bottom to top
            if (colStart <= colEnd) {
                for (int row = rowEnd; row >= rowStart; row--) {
                    result[index++] = array2d[row][colStart];
                }
                colStart++;
            }
        }

        return result;
    }

    /**
     *
     * TODO 6
     *
     * Input: a 1d array of length n, where n is a perfect square.
     * Output: a 2d array of width == height == sqrt(n) that represents a snail.
     *
     * Example:
     *
     * Input:
     *
     * {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
     *
     * Output:
     *
     * {
     *     {1,2,3,4,5},
     *     {16,17,18,19,6},
     *     {15,24,25,20,7},
     *     {14,23,22,21,8},
     *     {13,12,11,10,9},
     * }
     *
     *
     * @param array1d
     * @return a 2d array of width == height == sqrt(n), where n is the length of the inputted array, that represents a snail.
     *         returns an empty 2d array if the length of array1d is not a perfect square.
     */
    public static int[][] makeSnail(int[] array1d) {
        if (array1d == null) {
            return new int[0][0]; // Array is null, return empty 2D array
        }

        int length = array1d.length;
        int sqrt = (int) Math.sqrt(length);

        if (sqrt * sqrt != length) {
            return new int[0][0]; // Return empty 2D array if length of array1d is not a perfect square
        }

        int[][] result = new int[sqrt][sqrt];

        int rowStart = 0; // Starting row index
        int rowEnd = sqrt - 1; // Ending row index
        int colStart = 0; // Starting column index
        int colEnd = sqrt - 1; // Ending column index
        int index = 0; // Index to track the position in the 1D array

        while (rowStart <= rowEnd && colStart <= colEnd) {
            // Traverse the top row from left to right
            for (int col = colStart; col <= colEnd; col++) {
                result[rowStart][col] = array1d[index++];
            }
            rowStart++;

            // Traverse the right column from top to bottom
            for (int row = rowStart; row <= rowEnd; row++) {
                result[row][colEnd] = array1d[index++];
            }
            colEnd--;

            // Traverse the bottom row from right to left
            if (rowStart <= rowEnd) {
                for (int col = colEnd; col >= colStart; col--) {
                    result[rowEnd][col] = array1d[index++];
                }
                rowEnd--;
            }

            // Traverse the left column from bottom to top
            if (colStart <= colEnd) {
                for (int row = rowEnd; row >= rowStart; row--) {
                    result[row][colStart] = array1d[index++];
                }
                colStart++;
            }
        }

        return result;
    }

    /**
     *
     * TODO 1
     *
     * Private helper method that prints the contents of a 1d array.
     * Used mainly for debugging purposes.
     *
     * @param array1d
     */

    private static void print1dArray(int[] array1d) {
        for (int i = 0; i < array1d.length; i++) {
            System.out.print(array1d[i] + " ");
        }
        System.out.println();
    }


    /**
     *
     * TODO 2
     *
     * Private helper method that prints the contents of a 2d array.
     * Used mainly for debugging purposes.
     *
     * @param array2d
     */
    private static void print2dArray(int[][] array2d) {
        for (int row = 0; row < array2d.length; row++) {
            for (int col = 0; col < array2d[row].length; col++) {
                System.out.print(array2d[row][col] + " ");
            }
            System.out.println();
        }
    }

    /**
     *
     * TODO 3
     *
     * Private helper method that checks to see if a 1d array is of a length that is a perfect square.
     *
     * @param array1d
     * @return
     */
    private static boolean isPerfectSquare(int[] array1d) {
        int length = array1d.length;
        int sqrt = (int) Math.sqrt(length);
        return sqrt * sqrt == length;
    }


    /**
     *
     * TODO 4
     *
     * Private helper method that checks to see if a 2d array is a square.
     *
     * @param array2d
     * @return
     */
    private static boolean isPerfectSquare(int[][] array2d) {
        if (array2d == null) {
            return false;
        }
        int rows = array2d.length;
        if (rows == 0) {
            return false; // Empty array, not a square
        }
        int cols = array2d[0].length;
        for (int row = 1; row < rows; row++) {
            if (array2d[row].length != cols) {
                return false; // Rows have different lengths, not a square
            }
        }
        return rows == cols;
    }


}
