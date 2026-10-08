public class program6 {
    //program to display the matrix with bracket 
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int row = matrix.length;
        int col = matrix[0].length;

        System.out.println("Matrix:");
        for (int i = 0; i < row; i++) {
            System.out.print("[ ");
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j] + "   ");
            }
            System.out.println();
        }
    }

}
