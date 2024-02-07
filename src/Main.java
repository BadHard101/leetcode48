import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        /*int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}};*/
        int[][] matrix = {
                { 1,  2,  3,  4,  5},
                { 6,  7,  8,  9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}};
        /*
        21,16,11,6,1
        22,17,12,7,2,
        23,18,13,8,3,
        24,19,14,9,4,
        25,20,15,10,5
        */
        printMatrix(matrix);
        System.out.println();
        rotate(matrix);
        printMatrix(matrix);
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            iteration(matrix, i, n - 1 - i);
        }
    }

    private static void iteration(int[][] matrix, int start, int end) {
        int temp1, temp2;

        temp1 = matrix[start][end];
        matrix[start][end] = matrix[start][start];

        temp2 = matrix[end][end];
        matrix[end][end] = temp1;

        temp1 = matrix[end][start];
        matrix[end][start] = temp2;

        matrix[start][start] = temp1;

        int n = matrix.length;
        for (int i = start + 1; i < end; i++) {
            temp1 = matrix[i][end];
            matrix[i][end] = matrix[start][i];

            temp2 = matrix[end][n - 1 - i];
            matrix[end][n - 1 - i] = temp1;

            temp1 = matrix[n - 1 - i][start];
            matrix[n - 1 - i][start] = temp2;

            matrix[start][i] = temp1;
        }
    }

    private static void printMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
// [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
/*
 1  2  3  4
 5  6  7  8
 9 10 11 12
13 14 15 16

13  9  3  1
14 10  6  2
15 11  7  3
16 12  8  4

13  9  5  1
14 10  6  2
15 11  7  3
16 12  8  4
 */
/*
5 1 3
2 8 9
6 4 7

3 9 5
2 8 1
6 4 7

6 2 5
4 8 1
7 9 3
 */