package synchrinized;

public class SynchronizedMethods {
    private static final Object lock = new Object();

    public  void whatsappCall(){
        synchronized (lock) {
            System.out.println("Start call whatsApp");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end call whatsApp");
        }
    }

    public   void viberCall(){
        synchronized (lock) {
            System.out.println("Start call viber");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end call viber");
        }
    }

    public  void skypeCall(){
        synchronized (lock) {
            System.out.println("Start call skype");
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end call skype");
        }
    }

}

class Flow1 implements Runnable{
    @Override
    public void run() {
        new SynchronizedMethods().whatsappCall();
    }
}

class Flow2 implements Runnable{
    @Override
    public void run() {
        new SynchronizedMethods().skypeCall();
    }
}

class Flow3 implements Runnable{
    @Override
    public void run() {
        new SynchronizedMethods().viberCall();
    }
}

class Main{
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Flow1());
        Thread thread2 = new Thread(new Flow2());
        Thread thread3 = new Thread(new Flow3());

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
