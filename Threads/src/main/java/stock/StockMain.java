package stock;

/**
 * Created by ������������� on 01.06.2017.
 */
public class StockMain {
    public static void main(String[] args) {
        Stock stock = new Stock();
        new Producer(stock);
        new Consumer(stock);
    }
}
