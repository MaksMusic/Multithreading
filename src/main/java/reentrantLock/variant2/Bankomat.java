package reentrantLock.variant2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bankomat {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        new Employee("Tom1",lock);
        new Employee("Tom2",lock);
        new Employee("Tom3",lock);
        new Employee("Tom4",lock);
        new Employee("Tom5",lock);

    }
}


class Employee extends Thread{
    String name;
    private Lock lock;

    public Employee(String name, Lock lock) {
        this.name = name;
        this.lock = lock;
        this.start();
    }

    @Override
    public void run() {
       // System.out.println(name + " ждет");
       // lock.lock();
        if (lock.tryLock()) {
            System.out.println(name + " пользуется банкоматом");
            try {
                Thread.sleep(2000);
                System.out.println(name + " завершил(а) работу с банкоматом");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }else {
            System.out.println(name + " не стал ждать");
        }
    }
}
