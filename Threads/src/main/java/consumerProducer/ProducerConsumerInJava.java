package consumerProducer;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerInJava {
    public static void main(String[] args) {
        Queue <Integer> buffer = new LinkedList<Integer>();
        int productsMax = 20;

        Thread producer = new Producer(buffer, productsMax, "Producer");
        Consumer consumer = new Consumer(buffer, productsMax, "Consumer");

//        producer.start();
//        consumer.start();

    }
}
