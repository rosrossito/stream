package deadLock;

public class DemoDeadLock implements Runnable{
    DemoDeadLock() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        method1();
        method2();
    }

    public void method1(){
        synchronized (String.class){
            System.out.println("Lock for String");
            synchronized (Integer.class){
                System.out.println("Lock on Integer");
            }
        }
    }

    public void method2(){
        synchronized (Integer.class){
            System.out.println("Lock on Integer 2");
            synchronized (String.class){
                System.out.println("Lock on String 2");
            }
        }
    }
}

