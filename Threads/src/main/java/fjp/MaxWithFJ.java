package fjp;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class MaxWithFJ extends RecursiveAction {
    private final int threshold;
    private final SelectMaxProblem problem;
    public int result;
    public static int nThreads = 8;
    static ForkJoinPool fjPool = new ForkJoinPool(nThreads);

    public MaxWithFJ(SelectMaxProblem problem, int threshold) {
        this.problem = problem;
        this.threshold = threshold;
    }

    @Override
    protected void compute() {
        if (problem.size < threshold)
            result = problem.solveSequentially();
        else {
            int midpoint = problem.size / 2;
            MaxWithFJ left = new MaxWithFJ(problem.subproblem(0, midpoint), threshold);
            MaxWithFJ right = new MaxWithFJ(problem.subproblem(midpoint +
                    1, problem.size), threshold);

//            final File[] children = file.listFiles();
//            if (children != null) {
//                for (final File child : children) {
//                    ForkJoinTask.invokeAll(new SizeOfFileAction(child, sizeAccumulator));
//                }
//            }

//            left.fork();
//            right.fork();
            ForkJoinTask.invokeAll(left);
            ForkJoinTask.invokeAll(right);
//            coInvoke(left, right);
            System.out.println("left.result: " + left.result);
            System.out.println("right.result: " + right.result);
            result = Math.max(left.result, right.result);
        }
    }

    public static void main(String[] args) {
        int[]arr = new int[500000];
        Random r = new Random();
        for (int i=0;i<arr.length;i++){
            arr[i]=r.nextInt(10);
        }

        SelectMaxProblem problem = new SelectMaxProblem(arr, 0, arr.length-1);
        int threshold = 5000;
        MaxWithFJ mfj = new MaxWithFJ(problem, threshold);

        fjPool.invoke(mfj);
        int result = mfj.result;
        System.out.println(result);
    }

}
