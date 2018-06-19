package cash;

import java.util.concurrent.TimeUnit;

/**
 * Created by ������������� on 31.05.2017.
 */
public class CashDeskMain {
    public static void main(String[] args) {

        CashDesk cashDesk = new CashDesk();
        new Cashier(cashDesk);
        new Customer(cashDesk);
        try {
            TimeUnit.SECONDS.sleep(55);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}
