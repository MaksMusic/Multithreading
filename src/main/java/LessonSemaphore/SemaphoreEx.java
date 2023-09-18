package LessonSemaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreEx {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);

        Person person1 = new Person("Анна1",semaphore);
        Person person2 = new Person("Анна2",semaphore);
        Person person3 = new Person("Анна3",semaphore);
        Person person4 = new Person("Анна4",semaphore);
        Person person5 = new Person("Анна5",semaphore);
    }
}

class Person extends Thread{
    String name;
    private Semaphore semaphore;

    public Person(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
        this.start();
    }

    @Override
    public void run() {
        System.out.println(name + " ждет ");
        try {
            semaphore.acquire();
            System.out.println(name + " пользуется телефоном");
            Thread.sleep(2000);
            System.out.println(name+ " завершил звонок");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }
}
