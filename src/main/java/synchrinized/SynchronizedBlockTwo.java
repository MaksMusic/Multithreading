package synchrinized;

public class SynchronizedBlockTwo {
    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new MyRunnableImplTwo());
        Thread thread2 = new Thread(new MyRunnableImplTwo());


        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(DataBase.count);

    }
}


class DataBaseTwo {
    static int count = 0;

    public static  void imcrement() {
        synchronized (DataBaseTwo.class) {
            count++;
        }
    }
}

class MyRunnableImplTwo implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            DataBase.imcrement();
        }
    }
}
