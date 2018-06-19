package stock;

/**
 * Created by ������������� on 01.06.2017.
 */
public class Producer implements Runnable{
    Stock s;
    Producer(Stock s) {
        this.s = s;
        new Thread(this).start();
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            i++;
            s.put(i);
        }
    }
}
