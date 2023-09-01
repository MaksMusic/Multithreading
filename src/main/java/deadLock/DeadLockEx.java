package deadLock;

public class DeadLockEx {
     static final Object lock1 = new Object();
     static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();

        thread1.start();
        thread2.start();
    }
}

class Thread1 extends Thread{
    @Override
    public void run() {
        System.out.println("Попытка занять монитор lock1 потоком Thread1");
            synchronized (DeadLockEx.lock1){
                System.out.println("Монитор lock 1 занят потоком Thread1");
                System.out.println("Попытка занять монитор lock2 потоком Thread1");
                synchronized (DeadLockEx.lock2){
                    System.out.println("Монитор объекта lock1 и lock2 заняты потоком Thread1");
                }
        }
    }
}

class Thread2 extends Thread{
    @Override
    public void run() {
        System.out.println("Попытка занять монитор lock2 потоком Thread2");
        synchronized (DeadLockEx.lock2){
            System.out.println("Монитор lock 2 занят потоком Thread2");
            System.out.println("Попытка занять монитор lock1 потоком Thread2");
            synchronized (DeadLockEx.lock1){
                System.out.println("Монитор объекта lock1 и lock2 заняты потоком Thread2");
            }
        }
    }
}



