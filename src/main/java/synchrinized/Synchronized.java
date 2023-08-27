package synchrinized;

public class Synchronized {
    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new MyRunnableImpl());
        Thread thread2 = new Thread(new MyRunnableImpl());


        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(DataBase.count);

    }
}


class DataBase {
    static int count = 0;

    public static synchronized void imcrement() {
        count++;
    }
}

class MyRunnableImpl implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            DataBase.imcrement();
        }
    }
}
