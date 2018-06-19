package reentrantLockDemo;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    private final ReentrantLock lock = new ReentrantLock();
    private int counter = 0;

    public int getCounter1(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + " gets count: " + counter);
            return counter++;
        }finally {
            lock.unlock();
        }
    }

    public synchronized int getCounter2(){
        System.out.println(Thread.currentThread().getName() + " gets count: " + counter);
        return counter++;
    }

    public static void main(String[] args) {
        final ReentrantLockDemo rl = new ReentrantLockDemo();

        Thread th1 = new Thread(){
            @Override
            public void run() {
                while (rl.getCounter1()<6){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread th2 = new Thread(){
            @Override
            public void run() {
                while (rl.getCounter1()<6){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

    th1.start();
    th2.start();

    }
}
