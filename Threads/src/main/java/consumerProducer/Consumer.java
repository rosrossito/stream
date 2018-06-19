package consumerProducer;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Queue;

public class Consumer implements Runnable {
    private Queue<Integer> queue;
    private int productsMax;

    Consumer(Queue<Integer> queue, int productsMax, String name) {
//        super(name);
        this.queue = queue;
        this.productsMax = productsMax;
        new Thread(this, name).start();
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue){
                while (queue.isEmpty()){
                    System.out.println("Queue is empty.");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Consuming value : " + queue.remove());
                queue.notifyAll();
            }
        }
    }
}
