package matrixMultiply;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MatrixM extends Thread{

    int [][] matrix;
    int raws;
    int columns;

    int [][] matrix1;
    int [][] matrix2;
    MatrixM matrixResult;
    int startRow;
    int endRow;

    Random r = new Random();

    public MatrixM(int raws, int columns) {
        this.raws = raws;
        this.columns = columns;
        create(raws, columns);
    }

    public MatrixM(int [][] matrix1, int [][] matrix2, MatrixM matrixResult, int startRow, int endRow) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.matrixResult = matrixResult;
        this.startRow = startRow;
        this.endRow = endRow;
    }


    void create(int m, int n){
        matrix = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int k = r.nextInt(10);
                matrix[i][j] = k;
            }
        }
    }


    @Override
    public void run() {
        System.out.println("Считаются строки от " + startRow + " до " + endRow);
        for(int row=startRow; row<endRow+1; row++) {
            for(int col=0; col<matrixResult.matrix[row].length; col++) {
                matrixResult.matrix[row][col] = calcSingleValue(row, col);
           }
        }
    }

    public int calcSingleValue(int row, int col) {
        int c = 0;
        for (int i = 0; i < matrix2.length; i++) {
            c += matrix1[row][i] * matrix2[i][col];
        }
        return c;
    }


    public static MatrixM multiply(MatrixM matrix1, MatrixM matrix2, int threadsCount){
        //проверки
        if (matrix1.matrix == null || matrix1.matrix.length == 0 || matrix1.matrix[0] == null || matrix1.matrix[0].length == 0) {
            throw new IllegalArgumentException("a");
        }
        if (matrix2.matrix == null || matrix2.matrix.length == 0 || matrix2.matrix[0] == null || matrix2.matrix[0].length == 0) {
            throw new IllegalArgumentException("b");
        }
        if (matrix1.matrix[0].length != matrix2.matrix.length) {
            throw new IllegalArgumentException("матрицы не согласованы");
        }

        //определяем размеры результирующей матрицы
        int m = matrix1.matrix.length;
        int q = matrix2.matrix[0].length;
        MatrixM matrixResult = new MatrixM(m, q);

        //если количество потоков больше чем количество строк - уменьшим кол-во потоков
        if (threadsCount > m) {
            threadsCount = m;
        }

        //посчитаем сколько строк результирующей матрицы будет считать каждый поток
        int count = m / threadsCount;
        int additional = m % threadsCount; //если не делится на threadsCount, то добавим к первому потоку
        //создаем и запускаем потоки
        Thread[] threads = new Thread[threadsCount];

        //ExecutorService service = Executors.newFixedThreadPool(20);

        int start = 0;
        for (int i = 0; i < threadsCount; i++) {
            int cnt = ((i == 0) ? count + additional : count);
            threads[i] = new MatrixM(matrix1.matrix, matrix2.matrix, matrixResult, start, start + cnt - 1);
            start += cnt;
            threads[i].start();
        }

        //ждем завершения
        try {
            for (Thread thread : threads) {
                System.out.println(thread.getName());
                thread.join();
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }

        return matrixResult;
    }


    public void printMatrix(int [][] matrix){
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
