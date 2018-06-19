package cash;

/**
 * Created by ������������� on 31.05.2017.
 */
public class Customer implements Runnable {

    CashDesk cashDesk = new CashDesk();
    Customer (CashDesk cashDesk) {
        this.cashDesk = cashDesk;
        new Thread(this).start();
    }

    @Override
    public void run() {
        cashDesk.dayIsClosed();
    }


}
