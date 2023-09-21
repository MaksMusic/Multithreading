package AtomicInteger;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerEx {
    static AtomicInteger atomicInteger = new AtomicInteger();

    public static void increment(){
        atomicInteger.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyRunnableImpl());
        Thread thread2 = new Thread(new MyRunnableImpl());

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(atomicInteger);

    }
}

class MyRunnableImpl implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 125; i++) {
            AtomicIntegerEx.increment();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
