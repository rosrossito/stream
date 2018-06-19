package matrixMultiply;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MatrixMain {
    public static void main(String[] args) {
        MatrixM matrix1 = new MatrixM(1000, 1000);
        MatrixM matrix2 = new MatrixM(1000, 1000);

//        matrix1.printMatrix(matrix1.matrix);
        System.out.println("------------------");
//        matrix2.printMatrix(matrix2.matrix);

        MatrixM matrixRes = MatrixM.multiply(matrix1, matrix2, 10);

        matrixRes.printMatrix(matrixRes.matrix);

    }
}
