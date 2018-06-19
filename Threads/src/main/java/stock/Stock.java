package stock;

import java.util.concurrent.Semaphore;

/**
 * Created by ������������� on 01.06.2017.
 */
public class Stock {
    int amphitamins;
    Semaphore semCon = new Semaphore(0, true);
    Semaphore semProd = new Semaphore(1, true);

    int get() {
        try {
            semCon.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Get: " + amphitamins);
        semProd.release();
        return amphitamins;
    }


    void put(int i) {
        amphitamins = i;
        try {
            semProd.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Put: " + amphitamins);
        semCon.release();
    }
}
