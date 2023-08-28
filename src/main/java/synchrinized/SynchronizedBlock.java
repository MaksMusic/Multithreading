package synchrinized;

public class SynchronizedBlock {
    public static void main(String[] args) {
        MyRunnableImpl11 myRunnableImpl = new MyRunnableImpl11();
        Thread thread1 = new Thread(myRunnableImpl);
        Thread thread2 = new Thread(myRunnableImpl);
        Thread thread3 = new Thread(myRunnableImpl);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Counter11 {
    static int count = 0;
}

class MyRunnableImpl11 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            increment();
        }
    }

    public  void increment() {
        synchronized (this) {
            Counter11.count++;
            System.out.print(Counter11.count + " ");
        }
    }
}