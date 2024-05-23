import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static List<List<Integer>> generatePascalsTriangle(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows == 0) {
            return triangle;
        }

        // First row always contains 1
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);

            // First element in each row is always 1
            row.add(1);

            for (int j = 1; j < rowNum; j++) {
                // Each element (except the first and last) is the sum of the two elements above it
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // Last element in each row is always 1
            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }

    public static void printPascalsTriangle(List<List<Integer>> triangle) {
        int numRows = triangle.size();
        int maxNumWidth = String.valueOf(triangle.get(numRows - 1).get(numRows / 2)).length();

        for (int i = 0; i < numRows; i++) {
            // Print leading spaces to center the triangle
            for (int j = 0; j < numRows - i - 1; j++) {
                System.out.print(padWithSpaces(maxNumWidth));
            }

            List<Integer> row = triangle.get(i);
            for (Integer num : row) {
                System.out.print(padWithSpaces(maxNumWidth - String.valueOf(num).length()) + num + " ");
            }
            System.out.println();
        }
    }

    private static String padWithSpaces(int spaces) {
        return " ".repeat(Math.max(0, spaces));
    }

    public static void main(String[] args) {
        int numRows = 5; // Change this value to generate Pascal's Triangle with a different number of rows
        List<List<Integer>> triangle = generatePascalsTriangle(numRows);
        printPascalsTriangle(triangle);
    }
}
