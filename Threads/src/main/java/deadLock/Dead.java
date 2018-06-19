package deadLock;

import consumerProducer.Consumer;
import consumerProducer.Producer;

import java.util.LinkedList;
import java.util.Queue;

public class Dead {
    public static void main(String[] args) {
        DemoDeadLock th1 = new DemoDeadLock();
        DemoDeadLock th2 = new DemoDeadLock();
    }
}
