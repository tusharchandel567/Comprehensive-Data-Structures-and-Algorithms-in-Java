public class program7 {
    //program for addition of two matrices
    public static void main(String[] args) {
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] matrix2 = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        };

        int row = matrix1.length;
        int col = matrix1[0].length;

        int[][] sumMatrix = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        System.out.println("Sum of the two matrices:");
        for (int i = 0; i < row; i++) {
            System.out.print("[ ");
            for (int j = 0; j < col; j++) {
                System.out.print(sumMatrix[i][j] + "   ");
            }
            System.out.println();
        }
    }
}
