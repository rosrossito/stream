package stock;


public class Consumer implements Runnable {
    Stock s;
    Consumer(Stock s) {
        this.s = s;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (true) {
            s.get();
        }
    }
}
