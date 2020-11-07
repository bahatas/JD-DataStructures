public class RotateMatrixMain {
    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        int pixValue=1;
        for (int i=0;i<3;i++)
            for (int y=0;y<3;y++)
                matrix[i][y]=pixValue++;


        MatrixService.rotate90(matrix);
        System.out.println();
        MatrixService.printMatrix(matrix);
    }
}
