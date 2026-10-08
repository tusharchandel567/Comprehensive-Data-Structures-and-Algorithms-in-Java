public class program8 {
    //program for multiplication of two matrices
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

        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;

        if (col1 != row2) {
            System.out.println("Matrix multiplication is not possible.");
            return;
        }

        int[][] productMatrix = new int[row1][col2];

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < col1; k++) {
                    productMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        System.out.println("Product of the two matrices:");
        for (int i = 0; i < row1; i++) {
            System.out.print("[ ");
            for (int j = 0; j < col2; j++) {
                System.out.print(productMatrix[i][j] + "   ");
            }
            System.out.println();
        }
    } 
}
