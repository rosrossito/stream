package cash;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by ������������� on 31.05.2017.
 */
public class CashDesk {

    int customers = 10;
    boolean dayIsClosed = false;


    void dayIsClosed() {
        Random rnd = new Random();
        int timeToClose = rnd.nextInt(30) + 10;
        System.out.println("Time to close " + timeToClose);
        try {
            TimeUnit.SECONDS.sleep(timeToClose);
            dayIsClosed = true;

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    void serviceCustomer() {
        while (customers > 0) {
            if (!dayIsClosed) {
                customers--;
                Random rnd = new Random();
                int serviceTime = rnd.nextInt(4)  + 2;

                try {
                    TimeUnit.SECONDS.sleep(serviceTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Customer " + (10 - customers) + " was serviced for " + serviceTime + " seconds.");
                System.out.println("Free cash desk!");

            } else {
                customers = 0;
                System.out.println("Sorry. It's time to close the bank.");
            }
        }
    }
}
