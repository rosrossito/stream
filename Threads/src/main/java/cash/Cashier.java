package cash;

/**
 * Created by ������������� on 31.05.2017.
 */



    public class Cashier implements Runnable {

    CashDesk cashDesk = new CashDesk();
    Cashier (CashDesk cashDesk) {
        this.cashDesk = cashDesk;
        new Thread(this).start();
    }

    @Override
    public void run() {
        cashDesk.serviceCustomer();
    }
}
