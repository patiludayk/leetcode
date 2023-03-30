package com.uday.practise.ps;

public class MatrixExample {

    public static void main(String[] args) {
        int[][] matrix = new int[2][2];

        for (int row = 0; row < 2; row++) {
            for (int column = 0; column < 2; column++) {
                matrix[row][column] = row;
            }
        }

        System.out.println("The 2D array is: ");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(matrix

                        [i][j] + " ");
            }
            System.out.println();
        }
    }
}
