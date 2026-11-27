package arrays.level1;

import java.util.Scanner;

// Program 9: Copy a 2D array (matrix) into a 1D array
public class Copy2DTo1D {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Take input for rows and columns
        System.out.print("Enter number of rows: ");
        int rows = input.nextInt();
        System.out.print("Enter number of columns: ");
        int columns = input.nextInt();
        if (rows <= 0 || columns <= 0) {
            System.out.println("Invalid size.");
            input.close();
            return;
        }

        // Create the matrix and take the elements
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("Enter element [" + i + "][" + j + "]: ");
                matrix[i][j] = input.nextInt();
            }
        }

        // Create the 1D array and copy the elements
        int[] array = new int[rows * columns];
        int index = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                array[index] = matrix[i][j];
                index++;
            }
        }

        // Display the 1D array
        System.out.print("1D array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        // Close the Scanner Object
        input.close();
    }
}
