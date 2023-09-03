package reentrantLock.variant1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExapmle {
    public static void main(String[] args) {

        Lock lock = new ReentrantLock();

        Thread thread1 = new Thread(()->{
            new Call("flow1",lock).mobileCall();
        });

        Thread thread2 = new Thread(()->{
            new Call("flow2",lock).skypeCall();
        });

        Thread thread3 = new Thread(()->{
            new Call("flow3",lock).whatsappCall();
        });

        thread1.start();
        thread2.start();
        thread3.start();

    }

}

class Call{
    String name;
    Lock lock;

    public Call(String name, Lock lock) {
        this.name = name;
        this.lock = lock;
    }

    void mobileCall(){
        lock.lock();
        System.out.println("mobileCall start");
        try {
            Thread.sleep(3000);
            System.out.println("mobileCall ends");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    void skypeCall(){
        lock.lock();
        System.out.println("skypeCall start");
        try {
            Thread.sleep(5000);
            System.out.println("skypeCall ends");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    void whatsappCall(){
        lock.lock();
        System.out.println("whatsappCall start");
        try {
            Thread.sleep(7000);
            System.out.println("whatsappCall ends");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
