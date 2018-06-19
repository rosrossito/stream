package consumerProducer;

import java.util.Queue;
import java.util.Random;

public class Producer extends Thread{
    private Queue<Integer> queue;
    private int productsMax;

    Producer(Queue<Integer> queue, int productsMax, String name) {
        super(name);
        this.queue = queue;
        this.productsMax = productsMax;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue){
                while (queue.size()==productsMax){
                    System.out.println("Queue is full. Producer is waiting for consumer.");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Random random = new Random();
                int i = random.nextInt();
                System.out.println("Producing value: " + i);
                queue.add(i);
                queue.notifyAll();
            }

        }
    }
}
